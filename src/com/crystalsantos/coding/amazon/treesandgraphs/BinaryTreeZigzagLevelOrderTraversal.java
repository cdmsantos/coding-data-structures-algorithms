package com.crystalsantos.coding.amazon.treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.crystalsantos.coding.facebook.trees.and.graphs.TreeNode;

/**
 * Binary Tree Zigzag Level Order Traversal
 * 
 * Given the root of a binary tree, return the zigzag level order traversal of
 * its nodes' values. (i.e., from left to right, then right to left for the next
 * level and alternate between).
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7] Output: [[3],[20,9],[15,7]] Example 2:
 * 
 * Input: root = [1] Output: [[1]] Example 3:
 * 
 * Input: root = [] Output: []
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<List<Integer>>();
		}

		List<List<Integer>> results = new ArrayList<List<Integer>>();

		// add the root element with a delimiter to kick off the BFS loop
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		nodes.addLast(root);
		nodes.addLast(null);

		LinkedList<Integer> levelList = new LinkedList<Integer>();
		boolean isOrderLeft = true;

		while (nodes.size() > 0) {
			TreeNode currentNode = nodes.pollFirst();
			if (currentNode != null) {
				if (isOrderLeft) {
					levelList.addLast(currentNode.val);
				} else {
					levelList.addFirst(currentNode.val);
				}

				if (currentNode.left != null) {
					nodes.addLast(currentNode.left);
				}
				if (currentNode.right != null) {
					nodes.addLast(currentNode.right);
				}

			} else {
				// we finish the scan of one level
				results.add(levelList);
				levelList = new LinkedList<Integer>();
				// prepare for the next level
				if (nodes.size() > 0) {
					nodes.addLast(null);
				}
				isOrderLeft = !isOrderLeft;
			}
		}
		return results;
	}

	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversal zigZag = new BinaryTreeZigzagLevelOrderTraversal();
		zigZag.printResult(zigZag.zigzagLevelOrder(
				new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)))));
		zigZag.printResult(zigZag.zigzagLevelOrder(
				new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
	}

	private void printResult(List<List<Integer>> result) {
		System.out.print("[ ");
		for (List<Integer> partialResult : result) {
			System.out.print("[ ");
			for (Integer res : partialResult) {
				System.out.print(res + " ");
			}
			System.out.print("]");
		}
		System.out.print("]");
		System.out.println();
	}
}
