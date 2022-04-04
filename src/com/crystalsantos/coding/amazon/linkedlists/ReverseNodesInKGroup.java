package com.crystalsantos.coding.amazon.linkedlists;

import com.crystalsantos.coding.facebook.linkedlist.ListNode;

/**
 * Reverse Nodes in k-Group
 * 
 * Given the head of a linked list, reverse the nodes of the list k at a time,
 * and return the modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked
 * list. If the number of nodes is not a multiple of k then left-out nodes, in
 * the end, should remain as it is.
 * 
 * You may not alter the values in the list's nodes, only nodes themselves may
 * be changed.
 * 
 * Example 1:
 * 
 * Input: head = [1,2,3,4,5], k = 2 Output: [2,1,4,3,5] Example 2:
 * 
 * Input: head = [1,2,3,4,5], k = 3 Output: [3,2,1,4,5]
 * 
 * Constraints:
 * 
 * The number of nodes in the list is n. 1 <= k <= n <= 5000 0 <= Node.val <=
 * 1000
 * 
 * Follow-up: Can you solve the problem in O(1) extra memory space?
 */
public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {

		ListNode node = head;
		ListNode ktail = null;

		ListNode newHead = null;

		while (node != null) {

			int count = 0;

			node = head;

			// Find the head of the next k nodes
			while (count < k && node != null) {
				node = node.next;
				count += 1;
			}

			// If we counted k nodes, reverse them
			if (count == k) {

				ListNode revHead = reverseLinkedList(head, k);

				if (newHead == null) {
					newHead = revHead;
				}

				if (ktail != null) {
					ktail.next = revHead;
				}

				ktail = head;
				head = node;
			}
		}

		if (ktail != null) {
			ktail.next = head;
		}

		return newHead == null ? head : newHead;
	}

	public ListNode reverseLinkedList(ListNode head, int k) {

		ListNode newHead = null;
		ListNode ptr = head;

		while (k > 0) {

			ListNode nextNode = ptr.next;

			ptr.next = newHead;
			newHead = ptr;

			ptr = nextNode;
			k--;
		}

		return newHead;
	}

	public static void main(String[] args) {
		ReverseNodesInKGroup reverseKGroup = new ReverseNodesInKGroup();
		reverseKGroup.run();
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
		System.out.println();
	}

	public void run() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		printLinkedList(reverseKGroup(node1, 2));
		
		ListNode node11 = new ListNode(1);
		ListNode node21 = new ListNode(2);
		ListNode node31 = new ListNode(3);
		ListNode node41 = new ListNode(4);
		ListNode node51 = new ListNode(5);
		node11.next = node21;
		node21.next = node31;
		node31.next = node41;
		node41.next = node51;
		printLinkedList(reverseKGroup(node11, 3));
	}
}
