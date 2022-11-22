import OperationPackage.Operand;
import OperationPackage.Operator;

import java.util.*;

public class Evaluator {
	private Stack<Operand> operandStack;
	private Stack<Operator> operatorStack;

	private StringTokenizer tokenizer;
	private static final String DELIMITERS = "+-*^/() ";

	public void processOperators(){
		Operator previousOperator = operatorStack.pop();
		Operand secondOperand = operandStack.pop();
		Operand firstOperand = operandStack.pop();
		operandStack.push(previousOperator.execute(firstOperand, secondOperand));
	}

	public Evaluator() {
		operandStack = new Stack<>();
		operatorStack = new Stack<>();
	}

	public int eval(String expression) {
		String token;
		operatorStack.empty();
		operandStack.empty();

		// The 3rd argument is true to indicate that the delimiters should be used
		// as tokens, too. But, we'll need to remember to filter out spaces.
		this.tokenizer = new StringTokenizer(expression, DELIMITERS, true);
		//break the string into tokens to iterate through

		while (this.tokenizer.hasMoreTokens()) {
			// filter out spaces
			if (!(token = this.tokenizer.nextToken()).equals(" ")) {
				// check if token is an operand
				if (Operand.isNumber(token)) {
					operandStack.push(new Operand(token));
				} else {
					if (!Operator.isOperator(token)) {
						System.out.println("*****invalid token******");
						System.exit(1);
					}

					Operator newOpr = Operator.operators.get(token); //get the operator object from HashMap

					if (operatorStack.isEmpty()) {
						operatorStack.push(newOpr);
					} else if (newOpr.priority() >= operatorStack.peek().priority()) {
						operatorStack.push(newOpr);
					} else if (token.equals("(")) {
						operatorStack.push(newOpr);
					} else if (token.equals(")")) {
						while (operatorStack.peek().priority() >= newOpr.priority() && operatorStack.peek() != Operator.operators.get("(")) {
							processOperators();
						}
					} else {
							processOperators();
							operatorStack.push(newOpr);
					}
				}
			}
		}

		while (!operatorStack.isEmpty()) {
			if (operatorStack.peek() == Operator.operators.get("(") || operatorStack.peek() == Operator.operators.get(")")) {
				operatorStack.pop();
			} else {
				processOperators();
			}
		}
		return operandStack.pop().getValue();
	}
}