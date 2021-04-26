package com.crystalsantos.coding.linkedlist;

public class RemoveNthNodeFromEndOfList {
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

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return head;
		}

		if (head != null && head.next == null && n == 1) {
			return null;
		}

		if (n == 1) { // remove tail
			ListNode pointerOne = head;

			while (pointerOne.next != null && pointerOne.next.next != null) {
				pointerOne = pointerOne.next;
			}
			
			pointerOne.next = null;
		} else {
			ListNode pointerOne = head;
			ListNode pointerTwo = findPointerTwoInitialPosition(head, n);

			if (pointerTwo != null) {
				while (pointerTwo.next != null) {
					pointerOne = pointerOne.next;
					pointerTwo = pointerTwo.next;
				}

				pointerTwo = pointerOne.next;
				pointerOne.next = pointerTwo.next;
			} else {
				head = head.next;
			}

		}
		printLinkedList(head);
		return head;
	}

	private ListNode findPointerTwoInitialPosition(ListNode head, int n) {
		int index = 0;
		ListNode temp = head;

		while (temp != null && index < n) {
			temp = temp.next;
			index++;
		}

		return temp;
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
//		ListNode node3 = new ListNode(3);
//		ListNode node4 = new ListNode(4);
//		ListNode node5 = new ListNode(5);
		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;

		removeNthFromEnd(node1, 2);
	}

	public static void main(String[] args) {
		new RemoveNthNodeFromEndOfList().run();
		;
	}
}
