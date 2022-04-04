package com.crystalsantos.coding.binarysearch;

import com.crystalsantos.coding.facebook.trees.and.graphs.TreeNode;

/**
 * Inorder Successor in BST
 * 
 * Given the root of a binary search tree and a node p in it, return the
 * in-order successor of that node in the BST. If the given node has no in-order
 * successor in the tree, return null.
 * 
 * The successor of a node p is the node with the smallest key greater than
 * p.val.
 * 
 * Example 1:
 * 
 * Input: root = [2,1,3], p = 1 Output: 2 Explanation: 1's in-order successor
 * node is 2. Note that both p and the return value is of TreeNode type. Example
 * 2:
 * 
 * Input: root = [5,3,6,2,4,null,null,1], p = 6 Output: null Explanation: There
 * is no in-order successor of the current node, so the answer is null.
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104]. -105 <= Node.val <=
 * 105 All Nodes will have unique values.
 * 
 */
public class InorderSuccessorInBST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

		if (root == null || (root.left == null && root.right == null)) {
			return null;
		}

		TreeNode successor = null;

		while (root != null) {

			if (p.val >= root.val) {
				root = root.right;
			} else {
				successor = root;
				root = root.left;
			}
		}

		return successor;
	}

	public static void main(String[] args) {
		InorderSuccessorInBST successor = new InorderSuccessorInBST();
		TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)),
				new TreeNode(6));
		TreeNode p = new TreeNode(5);
		TreeNode result = successor.inorderSuccessor(root, p);
		if (result != null) {
			System.out.println(result.val);
		} else {
			System.out.println("null");
		}
	}
}
