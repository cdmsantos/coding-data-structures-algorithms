package com.crystalsantos.coding.dictionaries.hashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {

	public class TreeNode {
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

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		inorder(root, result, new HashMap<String, Integer>());
		return result;
	}

	private String inorder(TreeNode node, List<TreeNode> result, HashMap<String, Integer> map) {
		if (node == null) {
			return "";
		}

		String str = "(";
		str += inorder(node.left, result, map);
		str += Integer.toString(node.val);
		str += inorder(node.right, result, map);
		str += ")";

		if (map.get(str) != null && map.get(str) == 1) {
			result.add(node);
		}

		int value = map.getOrDefault(str, 0);
		map.put(str, value + 1);
		
		return str;
	}
	
	private void run() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(2);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(4);
		
		node1.left = node2;
		node1.right = node3;
		
		node2.left = node4;
		node3.left = node5;
		node3.right = node6;
		
		node5.left = node7;
		List<TreeNode> result = findDuplicateSubtrees(node1);
		for(int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i).val +  " ");
		}
	}

	public static void main(String[] args) {
		new FindDuplicateSubtrees().run();;
	}
}
