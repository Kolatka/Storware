package com.kolatka.app.operator;

public class SubtractOperator implements IOperator{

	@Override
	public double operate(double firstValue, double secondValue) {
		return firstValue - secondValue;
	}

	public String getSymbol() {
		return " - ";
	}
}
