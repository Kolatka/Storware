package com.kolatka.app.operator;

public class ExponentOperator implements IOperator{

	@Override
	public double operate(double firstValue, double secondValue) {
		return Math.pow(firstValue,secondValue);
	}

	@Override
	public String getSymbol() {
		return " ^ ";
	}
}
