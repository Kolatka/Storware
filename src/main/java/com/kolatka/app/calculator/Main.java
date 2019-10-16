package com.kolatka.app.calculator;

import com.kolatka.app.exception.InvalidInstructionException;

public class Main {
	public static void main(String[] args) {
		try {
			if (args.length>1 && args[1].equals("-full")) runApp(args[0], true);
			else if(args.length>0)runApp(args[0], false);
			else System.out.println("File location is missing");
		} catch (InvalidInstructionException e) {
			e.printStackTrace();
		}
	}

	public static void runApp(String location, Boolean extended) throws InvalidInstructionException {
		Calculator calculator = new Calculator(extended);
		FileHandler fileHandler = new FileHandler(location);
		fileHandler.readFile();
		calculator.setInstructionList(fileHandler.getInstructionList());
		try {
			System.out.println(calculator.calculate());
		} catch (InvalidInstructionException e) {
			e.printStackTrace();
		}
	}

}
