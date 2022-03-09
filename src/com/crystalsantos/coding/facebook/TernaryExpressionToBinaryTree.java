package com.crystalsantos.coding.facebook;

import java.util.Stack;

/**
 * Convert a ternary expression to a binary tree.
 * 
 * Example 1: Input: "a?b:c" Output: 
 *     a
     /  \
    b    c
 * Example 2: Input: "a?b?c:d:e"
 * Output: 
 *       a
        / \
       b   e
      / \
     c   d
 * 
 * Also, think about "a?b:c?d:e"
 * 
 */
public class TernaryExpressionToBinaryTree {

	public class TreeNode {
		Character val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(Character val) {
			this.val = val;
		}

		TreeNode(Character val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public TreeNode convert(char[] expr) {
		if (expr.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(expr[0]);
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		for (int i = 1; i < expr.length; i += 2) {
			if (expr[i] == '?') {
				TreeNode node = new TreeNode(expr[i + 1]);
				stack.peek().left = node;
				stack.push(node);
			} else if (expr[i] == ':') {
				stack.pop();
				TreeNode cur = stack.pop();
				TreeNode node = new TreeNode(expr[i + 1]);
				cur.right = node;
				stack.push(node);
			}
		}
		return root;
	}
	
	private void inorderRec(TreeNode root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.val + " ");
			inorderRec(root.right);
		}
	}

	public static void main(String[] args) {
		TernaryExpressionToBinaryTree ternary = new TernaryExpressionToBinaryTree();
		TreeNode result1 = ternary.convert(new char[] { 'a', '?', 'b', ':', 'c' });
		ternary.inorderRec(result1);
		TreeNode result2 = ternary.convert(new char[] { 'a', '?', 'b', '?', 'c', ':', 'd', ':', 'e' });
		ternary.inorderRec(result2);
	}
}
