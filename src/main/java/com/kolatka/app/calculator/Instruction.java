package com.kolatka.app.calculator;


import com.kolatka.app.operator.IOperator;

public class Instruction {

	private IOperator ioperator;
	private Double value;

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public IOperator getIoperator() {
		return ioperator;
	}

	public void setIoperator(IOperator ioperator) {
		this.ioperator = ioperator;
	}
}
