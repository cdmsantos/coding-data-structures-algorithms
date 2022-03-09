package com.crystalsantos.codility.facebook.trees.and.graphs;

import java.util.ArrayList;
import java.util.List;

/***
 * 
 * Same as DiameterOfBinaryTree, however, it's necessary to print the path of
 * diameter
 * 
 */
public class DiameterOfBinaryTreePrintPath {
	private int diameter = 0;
	private List<TreeNode> maxPath = new ArrayList<>();

	public int diameterOfBinaryTree(TreeNode root) {
		diameter = 0;
				
		if (root == null) {
			return diameter;
		}
		
		if(root.left == null && root.right == null) {
			maxPath.add(root);
			return diameter;
		}
		
		List<TreeNode> path = new ArrayList<>();
		path.add(root);
		collectPaths(root, path);
		return diameter;
	}

	private List<TreeNode> collectPaths(TreeNode node, List<TreeNode> parentPath) {
		if (node == null) {
			return new ArrayList<>();
		}

		// add this node to the parent
		parentPath.add(node);

		// start a new path from this node
		List<TreeNode> path = new ArrayList<>();
		path.add(node);
		List<TreeNode> pathLeft = collectPaths(node.left, path);
		List<TreeNode> pathRight = collectPaths(node.right, path);

		if (pathLeft.size() + pathRight.size() > diameter) {
			maxPath = new ArrayList<>();
			maxPath.addAll(pathLeft);
			maxPath.add(node);
			maxPath.addAll(pathRight);

			diameter = pathLeft.size() + pathRight.size();
		}

		// pick one to go up to the parent
		if (pathLeft.size() > pathRight.size()) {
			pathLeft.add(node);
			return pathLeft;
		} else {
			pathRight.add(node);
			return pathRight;
		}
	}
	
	private void printList(List<TreeNode> list){
	    for(TreeNode node : list){
	        System.out.print(node.val+"->");
	    }
	    System.out.println();
	}
	
	public static void main(String[] args) {
		DiameterOfBinaryTreePrintPath diameter = new DiameterOfBinaryTreePrintPath();
		diameter.run();
	}

	private void run() {
		TreeNode root1 = new TreeNode(8, new TreeNode(6, new TreeNode(2), new TreeNode(7)),
				new TreeNode(15, null, new TreeNode(20)));
		System.out.println(diameterOfBinaryTree(root1));
		printList(maxPath);

		TreeNode root2 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5));
		System.out.println(diameterOfBinaryTree(root2));
		printList(maxPath);
	}
}
