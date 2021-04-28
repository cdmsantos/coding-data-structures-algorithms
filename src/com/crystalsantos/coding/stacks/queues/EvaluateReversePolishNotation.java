package com.crystalsantos.coding.stacks.queues;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {
		if (tokens == null) {
			return 0;
		}

		if (tokens.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
				int number1 = stack.pop();
				int number2 = stack.pop();

				int result = 0;
				if (tokens[i].equals("+")) {
					result = number1 + number2;
				} else if (tokens[i].equals("-")) {
					result = number2 - number1;
				} else if (tokens[i].equals("*")) {
					result = number1 * number2;
				} else {
					result = number2 / number1;
				}

				stack.add(result);
			} else {
				stack.add(Integer.parseInt(tokens[i]));
			}
		}

		return stack.peek();
	}

	public static void main(String[] args) {
		EvaluateReversePolishNotation polishNotation = new EvaluateReversePolishNotation();
		String[] tokens1 = { "2", "1", "+", "3", "*" };
		System.out.println(polishNotation.evalRPN(tokens1)); // output = 9

		String[] tokens2 = { "4", "13", "5", "/", "+" };
		System.out.println(polishNotation.evalRPN(tokens2)); // output = 6

		String[] tokens3 = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		System.out.println(polishNotation.evalRPN(tokens3)); // output = 9

		String[] tokens4 = { "4", "3", "-" };
		System.out.println(polishNotation.evalRPN(tokens4)); // output = 1
	}
}
