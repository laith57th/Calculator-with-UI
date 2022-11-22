package OperationPackage.operators;

import OperationPackage.Operand;
import OperationPackage.Operator;

public class additionOperator extends Operator {
 @Override
 public int priority() {
  return 2;
 }

 @Override
 public Operand execute(Operand op1, Operand op2) {
  Operand result = new Operand(op1.getValue() + op2.getValue());
  return result;
 }
}
