package OperationPackage;

import OperationPackage.operators.*;

import java.util.HashMap;

public abstract class Operator {
	// The EvaluatorOperators.Operator class should contain an instance of a HashMap
	// This map will use keys as the tokens we're interested in,
	// and values will be instances of the Operators.

	public static HashMap<String, Operator> operators = new HashMap<>();

	static {
		operators.put("+", new additionOperator());
		operators.put("-", new subtractionOperator());
		operators.put("*", new multiplicationOperator());
		operators.put("/", new DivisionOperator());
		operators.put("^", new powerOperator());
		operators.put("(", new openPOperator());
		operators.put(")", new closedPOperator());
	}

	public abstract int priority();

	public abstract Operand execute(Operand op1, Operand op2);

	public static boolean isOperator(String token) {
		return operators.containsKey(token);
	}
}