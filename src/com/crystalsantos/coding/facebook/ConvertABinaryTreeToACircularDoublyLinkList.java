package com.crystalsantos.coding.facebook;

/**
 * 1) Write a general purpose function that concatenates two given circular doubly lists
 * 2) Now traverse the given tree
 * a) Recursively convert left subtree to a circular DLL. Let the converted list be leftList.
 * b) Recursively convert right subtree to a circular DLL. Let the converted list be rightList.
 * c) Make a circular linked list of root of the tree, make left and right of root to point to itself.
 * d) Concatenate leftList with list of single root node.
 * e) Concatenate the list produced in step above (d) with rightList.
 * 
 * Note that the above code traverses tree in Postorder fashion. We can traverse in inorder fashion also. 
 * We can first concatenate left subtree and root, then recur for right subtree and concatenate the 
 * result with left-root concatenation.
 * 
 * How to Concatenate two circular DLLs?
 * - Get the last node of the left list. Retrieving the last node is an O(1) operation, 
 * since the prev pointer of the head points to the last node of the list.
 * - Connect it with the first node of the right list
 * - Get the last node of the second list
 * - Connect it with the head of the list.
 * 
 * */
public class ConvertABinaryTreeToACircularDoublyLinkList {

	public class Node {
		int val;
		Node left, right;

		public Node(int val) {
			this.val = val;
			left = right = null;
		}
	}

	public Node concatenate(Node leftList, Node rightList) {
		// If either of the list is empty, then
		// return the other list
		if (leftList == null)
			return rightList;
		if (rightList == null)
			return leftList;

		// Store the last Node of left List
		Node leftLast = leftList.left;

		// Store the last Node of right List
		Node rightLast = rightList.left;

		// Connect the last node of Left List
		// with the first Node of the right List
		leftLast.right = rightList;
		rightList.left = leftLast;

		// left of first node refers to
		// the last node in the list
		leftList.left = rightLast;

		// Right of last node refers to the first
		// node of the List
		rightLast.right = leftList;

		// Return the Head of the List
		return leftList;
	}

	public Node bTreeToCList(Node root) {
		if (root == null)
			return null;

		// Recursively convert left and right subtrees
		Node left = bTreeToCList(root.left);
		Node right = bTreeToCList(root.right);

		// Make a circular linked list of single node
		// (or root). To do so, make the right and
		// left pointers of this node point to itself
		root.left = root.right = root;

		// Step 1 (concatenate the left list with the list
		// with single node, i.e., current node)
		// Step 2 (concatenate the returned list with the
		// right List)
		return concatenate(concatenate(left, root), right);
	}

	public void display(Node head) {
		System.out.println("Circular Linked List is :");
		Node itr = head;
		do {
			System.out.print(itr.val + " ");
			itr = itr.right;
		} while (itr != head);
		System.out.println();
	}

	private void run() {
		Node root = new Node(10);
		root.left = new Node(12);
		root.right = new Node(15);
		root.left.left = new Node(25);
		root.left.right = new Node(30);
		root.right.left = new Node(36);

		Node head = bTreeToCList(root);
		display(head);
	}

	public static void main(String args[]) {
		new ConvertABinaryTreeToACircularDoublyLinkList().run();
		;

	}
}
