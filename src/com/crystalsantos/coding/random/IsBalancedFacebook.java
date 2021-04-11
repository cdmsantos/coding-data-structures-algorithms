package com.crystalsantos.coding.random;

import java.util.Stack;

public class IsBalancedFacebook {
	boolean isBalanced(String s) {
		char[] brackets = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for(char bracket : brackets) {
			if(bracket == '{' || bracket == '[' || bracket == '(') {
				stack.add(bracket);
			} else {
				char lastChar = stack.pop();
				if(bracket == '}' && lastChar != '{') {
					return false;
				} else if(bracket == ']' && lastChar != '[') {
					return false;
				} else if(bracket == ')' && lastChar != '(') {
					return false;
				}
			}
		}
		
		return true;
	}

	int test_case_number = 1;

	void check(boolean expected, boolean output) {
		boolean result = (expected == output);
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			System.out.print(expected);
			System.out.print(" Your output: ");
			System.out.print(output);
			System.out.println();
		}
		test_case_number++;
	}

	void printString(String str) {
		System.out.print("[" + str + "]");
	}

	public void run() {
		String s_1 = "{[(])}";
		boolean expected_1 = false;
		boolean output_1 = isBalanced(s_1);
		check(expected_1, output_1);

		String s_2 = "{{[[(())]]}}";
		boolean expected_2 = true;
		boolean output_2 = isBalanced(s_2);
		check(expected_2, output_2);
	}

	public static void main(String[] args) {
		new IsBalancedFacebook().run();
	}
}