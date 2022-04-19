package com.crystalsantos.coding.binarysearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Tree: Level Order Traversal
 * 
 * Given a pointer to the root of a binary tree, you need to print the level
 * order traversal of this tree. In level-order traversal, nodes are visited
 * level by level from left to right. Complete the function and print the values
 * in a single line separated by a space.
 * 
 * For example:
 * 
 * 1 \ 2 \ 5 / \ 3 6 \ 4 For the above tree, the level order traversal is 1 - 2
 * - 5 - 3 - 6 - 4
 */
public class TreeLevelOrderTraversal {
	private static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
		
		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static void levelOrder(Node root) {

		List<Integer> nodeData = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		if (root != null) {
			queue.add(root);
		}
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			nodeData.add(current.data);
			
			if(current.left != null){
				queue.add(current.left);
			}
			
			if(current.right != null) {
				queue.add(current.right);
			}
		}
		
		for(int i = 0; i < nodeData.size(); i++) {
			if(i > 0 && i < nodeData.size()) {
				System.out.print(" ");
			}
			System.out.print(nodeData.get(i));
		}
	}

	public static void main(String[] args) {
		levelOrder(new Node(1, null, new Node(2, null, new Node(5, new Node(3, null, new Node(4)), new Node(6)))));
	}
}
