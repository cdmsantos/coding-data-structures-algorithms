package com.crystalsantos.coding.linkedlist;

import java.util.Stack;

public class RemoveLinkedListElements {
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

	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return false;
		}

		if (head != null && head.next == null) {
			return true;
		}

		ListNode current = head;
		Stack<Integer> values = new Stack<Integer>();

		while (current != null) {
			values.add(current.val);
			current = current.next;
		}

		current = head;
		while (current != null) {
			if (current.val == values.pop()) {
				current = current.next;
				continue;
			} else {
				return false;
			}

		}

		return true;
	}

	public void run() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode node5 = new ListNode(1);
		ListNode node6 = new ListNode(2);
		node5.next = node6;

		System.out.println(isPalindrome(node1));
		System.out.println(isPalindrome(node5));
	}

	public static void main(String[] args) {
		new RemoveLinkedListElements().run();
		;
	}
}
