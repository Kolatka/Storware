package com.kolatka.app.calculator;

import com.kolatka.app.exception.InvalidInstructionException;
import com.kolatka.app.operator.IOperator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler{

	private final String location;
	private final List<Instruction> instructionList = new ArrayList<>();

	public FileHandler(String location){
		this.location = location;
	}

	public void readFile() throws InvalidInstructionException {
		BufferedReader reader;
		try{
			reader = new BufferedReader(new FileReader(location));
			String singleLine = reader.readLine();
			while(singleLine != null){
				verifyLine(singleLine);
				singleLine = reader.readLine();
			}
		}catch(IOException e){
			e.printStackTrace();
		}

	}

	private void verifyLine(String line) throws InvalidInstructionException, NumberFormatException {
		String[] words = line.split(" ");
		if(words.length == 2) {
			Instruction instruction = new Instruction();
			instruction.setValue(Double.valueOf(words[1]));
			instruction.setIoperator(getOperator(words[0]));
			instructionList.add(instruction);
		}else
			throw new InvalidInstructionException("Invalid instruction: '" + line +"'.");
	}


	private IOperator getOperator(String type) throws InvalidInstructionException {
		type = type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase();
		IOperator operator = null;
		try {
			Class<IOperator> c = (Class<IOperator>) Class.forName("com.kolatka.app.operator." + type + "Operator");
			operator = c.newInstance();
		} catch (ClassNotFoundException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		if(operator == null) throw new InvalidInstructionException("Invalid operator: '" + type + "'.");
		return operator;
	}



	public List<Instruction> getInstructionList(){
		return instructionList;
	}

}
