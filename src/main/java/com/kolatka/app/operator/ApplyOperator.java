package com.kolatka.app.operator;

public class ApplyOperator implements IOperator{

	@Override
	public double operate(double firstValue, double secondValue) {
		return firstValue;
	}

	@Override
	public String getSymbol() {
		return "";
	}
}
