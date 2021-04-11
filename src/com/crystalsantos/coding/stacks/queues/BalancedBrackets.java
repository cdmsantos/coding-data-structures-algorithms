package com.crystalsantos.coding.stacks.queues;

import java.io.IOException;
import java.util.Scanner;

public class BalancedBrackets {
	private static Node top;

	private static class Node {
		Character c;
		Node next;

		public Node(Character c) {
			this.c = c;
		}
	}

	private static void addNode(Character c) {
		Node newNode = new Node(c);
		if (top == null) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
	}

	private static Character peek() {
		Character peek = null;
		if (top != null) {
			peek = top.c;
		}

		return peek;
	}

	private static void removeNode() {
		if (top != null) {
			top = top.next;
		}
	}

	static String isBalanced(String s) {
		char[] brackets = s.toCharArray();
		for (char c : brackets) {
			if (c == '[' || c == '{' || c == '(') {
				addNode(c);
			} else {
				Character charTop = peek();
				if (charTop == null) {
					top = null;
					return "NO";
				}

				if ((c == ']' && charTop == '[') || (c == '}' && charTop == '{') || (c == ')' && charTop == '(')) {
					removeNode();
				} else {
					top = null;
					return "NO";
				}
			}
		}

		Character charTop = peek();
		if (charTop != null) {
			top = null;
			return "NO";
		}

		top = null;
		return "YES";

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String s = scanner.nextLine();

			System.out.println(isBalanced(s));
		}

		scanner.close();
	}
}
