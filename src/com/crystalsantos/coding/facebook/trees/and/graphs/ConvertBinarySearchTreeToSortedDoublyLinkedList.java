package com.crystalsantos.coding.facebook.trees.and.graphs;

/**
 * 
 * Editor's choice
 * 
 * Convert Binary Search Tree to Sorted Doubly Linked List
 * 
 * 
 * Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in
 * place.
 * 
 * You can think of the left and right pointers as synonymous to the predecessor
 * and successor pointers in a doubly-linked list. For a circular doubly linked
 * list, the predecessor of the first element is the last element, and the
 * successor of the last element is the first element.
 * 
 * We want to do the transformation in place. After the transformation, the left
 * pointer of the tree node should point to its predecessor, and the right
 * pointer should point to its successor. You should return the pointer to the
 * smallest element of the linked list.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: root = [4,2,5,1,3]
 * 
 * 
 * Output: [1,2,3,4,5]
 * 
 * Explanation: The figure below shows the transformed BST. The solid line
 * indicates the successor relationship, while the dashed line means the
 * predecessor relationship.
 * 
 * Example 2:
 * 
 * Input: root = [2,1,3] Output: [1,2,3]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 2000]. -1000 <= Node.val
 * <= 1000 All the values of the tree are unique.
 */

//right pointer will be the next pointer
// left pointer will be the previous pointer
//to be sorted, we need to do a InOrder on BST
//Complexity Time: O(n) because I need to go through all nodes
//Space complexity: O(1) if we can ignore the space of the recursion. 
//If we cannot ignore that, space complexity will be O(h), height of the tree
//because it'll be the numbers of recursion calls 
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {

	class Node {
		public int val;
		public Node left;
		public Node right;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right) {
			val = _val;
			left = _left;
			right = _right;
		}
	};

	private Node headList;
	private Node previous;

	public Node treeToDoublyList(Node root) { // should be in order process
        if(root == null) {
            return null;
        }
        
		headList = null;
		previous = null;

		convert(root);
        previous.right = headList;
        headList.left = previous;
		return headList;
	}

	public void convert(Node node) {
		if (node != null) {
			convert(node.left);

			if (previous == null) {
				headList = node;
			} else {
				node.left = previous;
				previous.right = node;
			}

			previous = node;

			convert(node.right);
		}
	}

	public static void main(String[] args) {
		ConvertBinarySearchTreeToSortedDoublyLinkedList doubly = new ConvertBinarySearchTreeToSortedDoublyLinkedList();
		doubly.run();
	}

	private void run() {
		Node root1 = new Node(8, new Node(6, new Node(2), new Node(7)), new Node(15, null, new Node(20)));
		printList(treeToDoublyList(root1));
		
		Node root2 = new Node(4, new Node(2, new Node(1), new Node(3)), new Node(5));
		printList(treeToDoublyList(root2));
	}

	private void printList(Node node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.right;
		}
		System.out.println();
	}
}
