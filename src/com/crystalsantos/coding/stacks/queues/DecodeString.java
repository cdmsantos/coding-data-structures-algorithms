package com.crystalsantos.coding.stacks.queues;

import java.util.Stack;

public class DecodeString {
	public String decodeString(String encodedString) {

		if (encodedString == null || encodedString.length() == 0) {
			return encodedString;
		}

		Stack<String> strStack = new Stack<String>();
		Stack<Integer> numStack = new Stack<Integer>();
		StringBuilder decodedString = new StringBuilder();
		int index = 0;

		while (index < encodedString.length()) {

			if (Character.isDigit(encodedString.charAt(index))) {
				int num = 0;
				
				//if the number has more than one digit
				while (Character.isDigit(encodedString.charAt(index))) { 
					num = num * 10 + (encodedString.charAt(index) - '0');
					index++;
				}
				
				numStack.push(num);
			} else if (encodedString.charAt(index) == '[') {
				strStack.push(decodedString.toString());
				decodedString = new StringBuilder("");
				index++;
			} else if (encodedString.charAt(index) == ']') {
				StringBuilder temp = new StringBuilder(strStack.pop());
				int repeatTimes = numStack.pop();
				for (int i = 0; i < repeatTimes; i++) {
					temp.append(decodedString);
				}
				decodedString = temp;
				index++;
			} else {
				decodedString.append(encodedString.charAt(index));
				index++;
			}
		}

		return decodedString.toString();
	}

	public static void main(String[] args) {
		DecodeString decodeString = new DecodeString();
		System.out.println(decodeString.decodeString("3[a2[c]]"));
	}
}
