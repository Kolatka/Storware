package com.kolatka.app.operator;

public class AddOperator implements IOperator{

	@Override
	public double operate(double firstValue, double secondValue) {
		return firstValue + secondValue;
	}

	@Override
	public String getSymbol() {
		return " + ";
	}

}
