package OperationPackage.operators;


import OperationPackage.Operator;
import OperationPackage.Operand;

public class multiplicationOperator extends Operator {
	@Override
	public int priority() {
		return 3;
	}

	@Override
	public Operand execute(Operand op1, Operand op2) {
		Operand result = new Operand(op1.getValue() * op2.getValue());
		return result;
	}
}
