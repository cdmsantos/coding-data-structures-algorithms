package com.crystalsantos.coding.trees;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NodesInASubTree {

	static class Node {
		public int val;
		public List<Node> children;

		public Node() {
			val = 0;
			children = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			children = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	static class Query {
		int u;
		char c;

		Query(int u, char c) {
			this.u = u;
			this.c = c;
		}
	}


	static int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
		if(queries.size() == 0) {
			return null;
		}
		
		int[] count = new int[queries.size()];
		
		for(int i = 0; i < queries.size(); i++) {
			Query query = queries.get(i);
			int nodeVal = query.u;
			char nodeChar = query.c;
			
			if(root.val == nodeVal) {
				count[i] = findValue(root, s, nodeChar);
			} else {
				Node node = findNode(root, nodeVal);
				if(node != null) {
					count[i] = findValue(node, s, nodeChar);
				}
			}
		}
		
		return count;
	}
	
	static Node findNode(Node root, int val) {
		Node queryNode = null;
		for(Node child : root.children) {
			if(child.val == val) {
				queryNode = child;
				return queryNode;
			} else {
				findNode(child, val);
			}
		}
		
		return queryNode;
	}
	
	static int findValue(Node root, String s, char c) {
		int val = 0;
		if(s.charAt(root.val-1) == c) {
			val++;
		}
		
		for(Node child : root.children) {
			val += findValue(child, s, c);
		}
		
		return val;
	}

	static int test_case_number = 1;

	static void check(int[] expected, int[] output) {
		int expected_size = expected.length;
		int output_size = output.length;
		boolean result = true;
		if (expected_size != output_size) {
			result = false;
		}
		for (int i = 0; i < Math.min(expected_size, output_size); i++) {
			result &= (output[i] == expected[i]);
		}
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printIntegerArray(expected);
			System.out.print(" Your output: ");
			printIntegerArray(output);
			System.out.println();
		}
		test_case_number++;
	}

	static void printIntegerArray(int[] arr) {
		int len = arr.length;
		System.out.print("[");
		for (int i = 0; i < len; i++) {
			if (i != 0) {
				System.out.print(", ");
			}
			System.out.print(arr[i]);
		}
		System.out.print("]");
	}

	static public void run() throws IOException {
		// Testcase 1
		String s_1 = "aba";
		Node root_1 = new Node(1);
		root_1.children.add(new Node(2));
		root_1.children.add(new Node(3));
		ArrayList<Query> queries_1 = new ArrayList<>();
		queries_1.add(new Query(1, 'a'));
		int[] output_1 = countOfNodes(root_1, queries_1, s_1);
		int[] expected_1 = { 2 };
		check(expected_1, output_1);

		// Testcase 2
		String s_2 = "abaacab";
		Node root_2 = new Node(1);
		root_2.children.add(new Node(2));
		root_2.children.add(new Node(3));
		root_2.children.add(new Node(7));
		root_2.children.get(0).children.add(new Node(4));
		root_2.children.get(0).children.add(new Node(5));
		root_2.children.get(1).children.add(new Node(6));
		ArrayList<Query> queries_2 = new ArrayList<>();
		queries_2.add(new Query(1, 'a'));
		queries_2.add(new Query(2, 'b'));
		queries_2.add(new Query(3, 'a'));
		int[] output_2 = countOfNodes(root_2, queries_2, s_2);
		int[] expected_2 = { 4, 1, 2 };
		check(expected_2, output_2);
	}

	public static void main(String[] args) throws IOException {
		run();
	}
}