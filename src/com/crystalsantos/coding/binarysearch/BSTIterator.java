package com.crystalsantos.coding.binarysearch;

import java.util.Stack;

public class BSTIterator {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	private TreeNode curr;
	private Stack<TreeNode> stack = new Stack<>();

	public BSTIterator(TreeNode root) {
		curr = root;

		while (curr != null) {
			stack.push(curr);
			curr = curr.left;
		}
	}

	public int next() {
		curr = stack.pop();
		
		int res = curr.val;
		curr = curr.right;

		while (curr != null) {
			stack.push(curr);
			curr = curr.left;
		}

		return res;
	}

	public boolean hasNext() {
		return stack.size() > 0;
	}
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */