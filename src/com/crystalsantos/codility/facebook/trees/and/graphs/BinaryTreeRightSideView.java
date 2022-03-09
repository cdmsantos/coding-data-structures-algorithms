package com.crystalsantos.codility.facebook.trees.and.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/***
 * 
 * Binary Tree Right Side View
 * 
 * 
 * Given the root of a binary tree, imagine yourself standing on the right side
 * of it, return the values of the nodes you can see ordered from top to bottom.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,null,5,null,4] Output: [1,3,4] Example 2:
 * 
 * Input: root = [1,null,3] Output: [1,3] Example 3:
 * 
 * Input: root = [] Output: []
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 100]. -100 <= Node.val <=
 * 100
 * 
 */
public class BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> rightView = new ArrayList<>();
		if (root == null) {
			return rightView;
		}

		Queue<TreeNode> currentLevel = new ArrayDeque<>();
		Queue<TreeNode> nextLevel = new ArrayDeque<>();
		nextLevel.add(root);

		TreeNode node = null;
		while (!nextLevel.isEmpty()) {
			currentLevel.addAll(nextLevel);
			nextLevel.clear();

			while (!currentLevel.isEmpty()) {
				node = currentLevel.remove();
				if (node.left != null) {
					nextLevel.add(node.left);
				}

				if (node.right != null) {
					nextLevel.add(node.right);
				}
			}

			if (currentLevel.isEmpty()) {
				rightView.add(node.val);
			}
		}

		return rightView;
	}

	public static void main(String[] args) {
		BinaryTreeRightSideView rightSideView = new BinaryTreeRightSideView();
		rightSideView.run();
	}

	private void run() {
		TreeNode root1 = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
		printResult(rightSideView(root1));

		TreeNode root2 = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), null);
		printResult(rightSideView(root2));

		TreeNode root3 = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)),
				new TreeNode(3, null, new TreeNode(4)));
		printResult(rightSideView(root3));
	}

	private void printResult(List<Integer> result) {
		System.out.print("[ ");
		for (Integer res : result) {
			System.out.print(res + " ");
		}
		System.out.print("]");
		System.out.println();
	}
}
