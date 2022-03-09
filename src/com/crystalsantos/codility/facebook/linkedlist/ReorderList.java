package com.crystalsantos.codility.facebook.linkedlist;

/***
 * 
 * Reorder List
 * 
 * 
 * ou are given the head of a singly linked-list. The list can be represented
 * as:
 * 
 * L0 → L1 → … → Ln - 1 → Ln Reorder the list to be on the following form:
 * 
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … You may not modify the values in the
 * list's nodes. Only nodes themselves may be changed.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4] Output: [1,4,2,3] Example 2:
 * 
 * 
 * Input: head = [1,2,3,4,5] Output: [1,5,2,4,3]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [1, 5 * 104]. 1 <= Node.val
 * <= 1000
 * 
 * 
 *
 */
public class ReorderList {

	public void reorderList(ListNode head) {
		if (head == null)
			return;

		// find the middle of linked list
		// slow will be the middle of the linked list
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// reverse the second half in-place
		ListNode prev = null, curr = slow, tmp;
		while (curr != null) {
			tmp = curr.next;

			curr.next = prev;
			prev = curr;
			curr = tmp;
		}

		// merge two sorted linked lists [Problem 21]
		ListNode first = head, second = prev;
		while (second.next != null) {
			tmp = first.next;
			first.next = second;
			first = tmp;

			tmp = second.next;
			second.next = first;
			second = tmp;
		}
	}

	public static void main(String[] args) {
		ReorderList reorder = new ReorderList();
		reorder.run();
	}

	private void printLinkedList(ListNode head) {
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
		ListNode node1 = new ListNode(1);
		ListNode node12 = new ListNode(2);
		ListNode node13 = new ListNode(3);
		ListNode node14 = new ListNode(4);
		ListNode node15 = new ListNode(5);
		node1.next = node12;
		node12.next = node13;
		node13.next = node14;
		node14.next = node15;

		reorderList(node1);
		printLinkedList(node1);
	}
}
