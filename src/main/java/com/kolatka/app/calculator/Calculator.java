package com.kolatka.app.calculator;

import com.kolatka.app.exception.InvalidInstructionException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class Calculator {

	private List<Instruction> instructionList = new ArrayList<>();
	private final Boolean extended;
	private StringBuilder output;

	public Calculator(Boolean extended) {
		this.extended =	extended;
		if(extended)
			output = new StringBuilder();

	}

	public void setInstructionList(List<Instruction> instructionList){
		this.instructionList = instructionList;
	}

	public String calculate() throws InvalidInstructionException {
		double result = 0.0;

		if(validateInstruction()){
			result = instructionList.get(instructionList.size()-1).getValue();
			if(extended)
				output.append(result);

			for(int i = 0; i< instructionList.size()-1; i++){
				result = instructionList.get(i).getIoperator().operate(result, instructionList.get(i).getValue());
				if(extended)
					output.append(instructionList.get(i).getIoperator().getSymbol()  + instructionList.get(i).getValue());
			}
		}

		return (extended ? output.toString() + " = " : "") + String.valueOf(result);
	}

	private Boolean validateInstruction() throws InvalidInstructionException {
		if(instructionList.size()==0) {
			throw new InvalidInstructionException("List of instructions is empty");
		}else if(!instructionList.get(instructionList.size() - 1).getIoperator().getClass().getSimpleName().equals("ApplyOperator")) {
			throw new InvalidInstructionException("Last instruction should be 'Apply'");
		}else
			return true;
	}





}
