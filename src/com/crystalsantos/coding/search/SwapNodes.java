package com.crystalsantos.coding.search;

import java.util.Scanner;

class Node {
	int leftIndex, rightIndex;
}

public class SwapNodes {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		Node[] tree = new Node[n + 1];

		for (int i = 1; i <= n; i++) {
			Node node = new Node();
			node.leftIndex = scanner.nextInt();
			node.rightIndex = scanner.nextInt();

			tree[i] = node;
		}

		int t = scanner.nextInt();

		for (int i = 0; i < t; i++) {
			int k = scanner.nextInt();

			swapSubtrees(tree, k);
			printTree(tree);
		}

		scanner.close();
	}

	static void swapSubtrees(Node[] tree, int k) {
		swapSubtrees(tree, k, 1, 1);
	}

	static void swapSubtrees(Node[] tree, int k, int depth, int index) {
		if (index == -1)
			return;

		Node node = tree[index];

		// swap subtrees at depth h where h = 1k, 2k, 3k, ...
		if (depth % k == 0) {
			int tmp = node.leftIndex;
			node.leftIndex = node.rightIndex;
			node.rightIndex = tmp;
		}

		// traverse and increment depth
		swapSubtrees(tree, k, depth + 1, node.leftIndex);
		swapSubtrees(tree, k, depth + 1, node.rightIndex);
	}

	static void printTree(Node[] tree) {
		printTree(tree, 1);
		System.out.println();
	}

	static void printTree(Node[] tree, int index) {
		if (index == -1)
			return;

		Node node = tree[index];

		// inorder traversal
		printTree(tree, node.leftIndex);
		System.out.print(index + " ");
		printTree(tree, node.rightIndex);
	}
}
