package com.crystalsantos.coding.facebook.linkedlist;

/***
 * 
 * Copy List with Random Pointer
 * 
 * 
 * A linked list of length n is given such that each node contains an additional
 * random pointer, which could point to any node in the list, or null.
 * 
 * Construct a deep copy of the list. The deep copy should consist of exactly n
 * brand new nodes, where each new node has its value set to the value of its
 * corresponding original node. Both the next and random pointer of the new
 * nodes should point to new nodes in the copied list such that the pointers in
 * the original list and copied list represent the same list state. None of the
 * pointers in the new list should point to nodes in the original list.
 * 
 * For example, if there are two nodes X and Y in the original list, where
 * X.random --> Y, then for the corresponding two nodes x and y in the copied
 * list, x.random --> y.
 * 
 * Return the head of the copied linked list.
 * 
 * The linked list is represented in the input/output as a list of n nodes. Each
 * node is represented as a pair of [val, random_index] where:
 * 
 * val: an integer representing Node.val random_index: the index of the node
 * (range from 0 to n-1) that the random pointer points to, or null if it does
 * not point to any node. Your code will only be given the head of the original
 * linked list.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]] Output:
 * [[7,null],[13,0],[11,4],[10,2],[1,0]] Example 2:
 * 
 * 
 * Input: head = [[1,1],[2,1]] Output: [[1,1],[2,1]] Example 3:
 * 
 * 
 * 
 * Input: head = [[3,null],[3,0],[3,null]] Output: [[3,null],[3,0],[3,null]]
 * 
 * 
 * Constraints:
 * 
 * 0 <= n <= 1000 -104 <= Node.val <= 104 Node.random is null or is pointing to
 * some node in the linked list.
 * 
 * 
 * 
 *
 */
public class CopyListWithRandomPointer {
	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}

		if (head != null && head.next == null && head.random == null) {
			return new Node(head.val);
		}

		Node currentHead = head, temp = null;

		while (currentHead != null) {
			temp = currentHead.next;
			currentHead.next = new Node(currentHead.val);
			currentHead.next.next = temp;
			currentHead = temp;
		}
		currentHead = head;

		while (currentHead != null) {
			if (currentHead.next != null) {
				currentHead.next.random = (currentHead.random != null) ? currentHead.random.next : currentHead.random;
			}
			currentHead = (currentHead.next != null) ? currentHead.next.next : currentHead.next;
		}

		Node original = head, copy = head.next;
		temp = copy;

		while (original != null && copy != null) {
			original.next = (original.next != null) ? original.next.next : original.next;
			copy.next = (copy.next != null) ? copy.next.next : copy.next;

			original = original.next;
			copy = copy.next;
		}

		return temp;
	}

	public static void main(String[] args) {
		CopyListWithRandomPointer random = new CopyListWithRandomPointer();
		random.run();
	}

	private void printLinkedList(Node head) {
		System.out.print("[");
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
			if (head != null)
				System.out.print(" ");
		}
		System.out.print("]");
	}

	private void run() {
		Node node1 = new Node(7);
		Node node12 = new Node(13);
		Node node13 = new Node(11);
		Node node14 = new Node(10);
		Node node15 = new Node(1);
		node1.next = node12;
		node12.next = node13;
		node13.next = node14;
		node14.next = node15;

		node1.random = null;
		node12.random = node1;
		node13.random = node15;
		node14.random = node13;
		node15.random = node1;

		Node result = copyRandomList(node1);
		printLinkedList(result);
	}

}
