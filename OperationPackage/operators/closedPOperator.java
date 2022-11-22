package OperationPackage.operators;

import OperationPackage.Operator;
import OperationPackage.Operand;

public class closedPOperator extends Operator {
    @Override
    public int priority() {
        return 0;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        return null;
    }
}
