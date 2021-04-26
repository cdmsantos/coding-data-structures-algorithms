package com.crystalsantos.coding.linkedlist;

public class PalindromeLinkedList {
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

	public ListNode oddEvenList(ListNode head) {

		if (head == null || (head != null && head.next == null)) {
			return head;
		}

		ListNode odd = head;
		ListNode even = head.next;

		ListNode evenFirst = even;

		while (odd.next != null || even.next != null) {
			if (odd == null || even == null || even.next == null) {
				odd.next = evenFirst;
				break;
			}

			odd.next = even.next;
			odd = even.next;

			if (odd.next == null) {
				even.next = null;
				odd.next = evenFirst;
				break;
			}

			even.next = odd.next;
			even = odd.next;
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
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		ListNode result = oddEvenList(node1);
		printLinkedList(result);
	}

	public static void main(String[] args) {
		new PalindromeLinkedList().run();
		;
	}
}
