package com.crystalsantos.coding.linkedlist;

public class RotateList {
	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return null;
		}

		if (head != null && head.next == null) {
			return head;
		}

		if (k == 0) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;

		ListNode temp = head;
		int length = 0;

		while (temp != null) {
			temp = temp.next;
			length++;
		}
		
		k = k % length;
		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}
		
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		fast.next = head;
		ListNode result = slow.next;
		slow.next = null;
		
		return result;
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

		node1.next = node2;

		ListNode result = rotateRight(node1, 1);

		printLinkedList(result);
	}

	public static void main(String[] args) {
		new RotateList().run();
	}

}
