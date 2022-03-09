package com.crystalsantos.codility.facebook.design;

import java.util.ArrayList;
import java.util.LinkedList;

import com.crystalsantos.codility.facebook.trees.and.graphs.TreeNode;

/**
 * 
 * Editors choice! Serialize and Deserialize Binary Tree
 * 
 * 
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * Clarification: The input/output format is the same as how LeetCode serializes
 * a binary tree. You do not necessarily need to follow this format, so please
 * be creative and come up with different approaches yourself.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,null,null,4,5] Output: [1,2,3,null,null,4,5] Example 2:
 * 
 * Input: root = [] Output: []
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 104]. -1000 <= Node.val
 * <= 1000
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class SerializeAndDeserializeBinaryTree {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "#";
		}

		ArrayList<String> list = new ArrayList<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				list.add("#");
			} else {
				list.add("" + node.val);
				queue.offer(node.left);
				queue.offer(node.right);
			}
		}

		return String.join(",", list);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] arrayData = data.split(",");

		if (arrayData[0].equals("#")) {
			return null;
		}

		TreeNode root = new TreeNode(Integer.parseInt(arrayData[0]));
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		int index = 1;

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node != null) {
				TreeNode left = null;
				if (!arrayData[index].equals("#")) {
					left = new TreeNode(Integer.parseInt(arrayData[index]));
				}
				node.left = left;
				queue.offer(left);
				index++;

				TreeNode right = null;
				if (!arrayData[index].equals("#")) {
					right = new TreeNode(Integer.parseInt(arrayData[index]));
				}
				node.right = right;
				queue.offer(right);
				index++;
			}
		}

		return root;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));