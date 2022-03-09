package com.crystalsantos.coding.facebook.linkedlist;

/***
 * 
 * Merge Two Sorted Lists
 * 
 * You are given the heads of two sorted linked lists list1 and list2.
 * 
 * Merge the two lists in a one sorted list. The list should be made by splicing
 * together the nodes of the first two lists.
 * 
 * Return the head of the merged linked list.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: list1 = [1,2,4], list2 = [1,3,4] Output: [1,1,2,3,4,4] Example 2:
 * 
 * Input: list1 = [], list2 = [] Output: [] Example 3:
 * 
 * Input: list1 = [], list2 = [0] Output: [0]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in both lists is in the range [0, 50]. -100 <= Node.val
 * <= 100 Both list1 and list2 are sorted in non-decreasing order.
 * 
 *
 *
 */

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null && l2 == null) {
			return null;
		}

		if (l1 != null && l2 == null) {
			return l1;
		}

		if (l1 == null && l2 != null) {
			return l2;
		}

		ListNode currentL1 = l1;
		ListNode currentL2 = l2;
		ListNode merge = new ListNode();
		ListNode currentMerge = merge;
		boolean start = true;
		while (currentL1 != null && currentL2 != null) {
			if (currentL1.val <= currentL2.val) {
				if (start) {
					currentMerge.val = currentL1.val;
					start = false;
				} else {
					currentMerge.next = new ListNode(currentL1.val);
					currentMerge = currentMerge.next;
				}

				currentL1 = currentL1.next;
			} else {
				if (start) {
					currentMerge.val = currentL2.val;
					start = false;
				} else {
					currentMerge.next = new ListNode(currentL2.val);
					currentMerge = currentMerge.next;
				}

				currentL2 = currentL2.next;
			}
		}

		if (currentL1 != null) {
			while (currentL1 != null) {
				currentMerge.next = new ListNode(currentL1.val);
				currentMerge = currentMerge.next;
				currentL1 = currentL1.next;
			}
		}

		if (currentL2 != null) {
			while (currentL2 != null) {
				currentMerge.next = new ListNode(currentL2.val);
				currentMerge = currentMerge.next;
				currentL2 = currentL2.next;
			}
		}

		return merge;
	}

	public static void main(String[] args) {
		MergeTwoSortedLists merge = new MergeTwoSortedLists();
		merge.run();
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
		ListNode node13 = new ListNode(4);
		node1.next = node12;
		node12.next = node13;
		
		ListNode node2 = new ListNode(1);
		ListNode node22 = new ListNode(3);
		ListNode node23 = new ListNode(4);
		node2.next = node22;
		node22.next = node23;

//		ListNode node1 = null;
//		ListNode node2 = null;
		
//		ListNode node1 = new ListNode(5);
//		
//		ListNode node2 = new ListNode(1);
//		ListNode node22 = new ListNode(2);
//		ListNode node23 = new ListNode(4);
//		node2.next = node22;
//		node22.next = node23;

		ListNode result = mergeTwoLists(node1, node2);
		printLinkedList(result);
	}
}
