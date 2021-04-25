package com.crystalsantos.coding.trees;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildSearchTree(inorder, postorder, 0, inorder.length -1, 0, postorder.length-1);
	}

	private static TreeNode buildSearchTree(int inOrder[], int postOrder[], int inOrderStart, int inOrderEnd,
			int postOrderStart, int postOrderEnd) {

		if (inOrderStart > inOrderEnd) {
			return null;
		}

		TreeNode node = new TreeNode(postOrder[postOrderEnd]);

		if (inOrderStart == inOrderEnd) { // has no children
			return node;
		}

		int inOrderIndex = search(inOrder, inOrderStart, inOrderEnd, node.val);

		node.left = buildSearchTree(inOrder, postOrder, inOrderStart, inOrderIndex - 1, postOrderStart,
				postOrderStart - inOrderStart + inOrderIndex - 1);
		node.right = buildSearchTree(inOrder, postOrder, inOrderIndex + 1, inOrderEnd,
				postOrderEnd - inOrderEnd + inOrderIndex, postOrderEnd - 1);

		return node;
	}

	private static int search(int array[], int start, int end, int value) {
		int position = start;
		while (position <= end) {
			if (array[position] == value) {
				break;
			}
			position++;
		}

		return position;
	}

	public static void main(String[] args) {
		int[] inorder = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 };
		int[] postorder = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 };

		TreeNode tree = buildTree(inorder, postorder);

		System.out.println(tree.val);
	}
}
