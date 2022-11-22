package OperationPackage.operators;

import OperationPackage.Operator;
import OperationPackage.Operand;


public class powerOperator extends Operator {
	@Override
	public int priority() {
		return 4;
	}

	@Override
	public Operand execute(Operand op1, Operand op2) {
		Operand result = new Operand((int) Math.pow(op1.getValue(), op2.getValue()));
		return result;
	}
}
