package com.crystalsantos.coding.linkedlist;

public class OddEvenLinkedList {
	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}

		if (head.next == null && head.val == val) {
			return null;
		}

		if (head.next == null && head.val != val) {
			return head;
		}

		ListNode current = head;
		ListNode temp = null;

		if (current.val == val) {
			while (current != null && current.val == val) {
				head = current.next;
				current = current.next;
			}
		}

		while (current != null && current.next != null) {
			if (current.next.val == val) {
				temp = current.next;
				current.next = temp.next;
			} else {
				current = current.next;				
			}

		}

		return head;
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

	public void run() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
//		ListNode node1 = new ListNode(1);
//		ListNode node2 = new ListNode(2);
//		ListNode node3 = new ListNode(6);
//		ListNode node4 = new ListNode(3);
//		ListNode node5 = new ListNode(4);
//		ListNode node6 = new ListNode(5);
//		ListNode node7 = new ListNode(6);
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;
//		node5.next = node6;
//		node6.next = node7;

		ListNode result = removeElements(node1, 2);
		printLinkedList(result);
	}

	public static void main(String[] args) {
		new OddEvenLinkedList().run();
		;
	}
}
