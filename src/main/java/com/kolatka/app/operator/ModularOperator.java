package com.kolatka.app.operator;

public class ModularOperator implements IOperator{

	@Override
	public double operate(double firstValue, double secondValue) {
		return firstValue % secondValue;
	}

	@Override
	public String getSymbol() {
		return " % ";
	}
}
