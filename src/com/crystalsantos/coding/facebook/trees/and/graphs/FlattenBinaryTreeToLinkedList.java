package com.crystalsantos.coding.facebook.trees.and.graphs;

/***
 * Flatten Binary Tree to Linked List
 * 
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * 
 * The "linked list" should use the same TreeNode class where the right child
 * pointer points to the next node in the list and the left child pointer is
 * always null. The "linked list" should be in the same order as a pre-order
 * traversal of the binary tree.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,5,3,4,null,6] Output:
 * [1,null,2,null,3,null,4,null,5,null,6] Example 2:
 * 
 * Input: root = [] Output: [] Example 3:
 * 
 * Input: root = [0] Output: [0]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 2000]. -100 <= Node.val
 * <= 100
 * 
 * 
 * Follow up: Can you flatten the tree in-place (with O(1) extra space)?
 * 
 */
public class FlattenBinaryTreeToLinkedList {

	public void flatten(TreeNode root) {
		if (root != null) {
			TreeNode rootCopy = root;
			changeSides(rootCopy);
		}
	}

	public void changeSides(TreeNode root) {
		if (root.left != null) {
			TreeNode partialRight = root.right;
			root.right = root.left;
			root.left = null;

			TreeNode findLastRight = root.right;
			while (findLastRight.right != null) {
				findLastRight = findLastRight.right;
			}
			findLastRight.right = partialRight;

			changeSides(root.right);
		} else if (root.right != null) {
			if (root.right != null) {
				changeSides(root.right);
			}
		}
	}

	public static void main(String[] args) {
		FlattenBinaryTreeToLinkedList tree = new FlattenBinaryTreeToLinkedList();
		tree.run();
	}

	private void run() {
		TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
				new TreeNode(5, null, new TreeNode(6)));
		flatten(root1);

		System.out.println("");

		TreeNode root2 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
		flatten(root2);

		System.out.println("");

		TreeNode root3 = new TreeNode(0);
		flatten(root3);
		
		System.out.println("");

		TreeNode root4 = new TreeNode(2, new TreeNode(1), new TreeNode(4, new TreeNode(3), null));
		flatten(root4);

		System.out.println("");
	}
}
