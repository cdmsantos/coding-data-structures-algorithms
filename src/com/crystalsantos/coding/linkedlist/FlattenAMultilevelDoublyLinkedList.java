package com.crystalsantos.coding.linkedlist;

import java.util.Stack;

public class FlattenAMultilevelDoublyLinkedList {
	class Node {
		int val;
		Node next;
		Node prev;
		Node child;

		Node() {
		}

		Node(int val) {
			this.val = val;
		}
	}

	public Node flatten(Node head) {
		if (head == null) {
			return null;
		}

		if (head != null && head.next == null && head.prev == null && head.child == null) {
			return head;
		}

		Node current = head;
		Node previousCurrent = head;
		Stack<Node> waitingToBeProcessed = new Stack<Node>();

		while (current != null) {
			if (current.child != null) {
				if (current.next != null) {
					waitingToBeProcessed.add(current.next);
				}

				Node temp = current.child;
				current.next = current.child;
				temp.prev = current;
				current.child = null;
			}

			previousCurrent = current;
			current = current.next;
		}

		while (!waitingToBeProcessed.isEmpty()) {
			Node nextNode = waitingToBeProcessed.pop();
			if (current == null) {
				current = previousCurrent;
			}

			nextNode.prev = current;
			current.next = nextNode;

			previousCurrent = current;
			current = current.next;

			if (!waitingToBeProcessed.isEmpty()) {
				while (current != null) {
					previousCurrent = current;
					current = current.next;
				}
			}
		}

		return head;
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

	public void run() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node11 = new Node(11);
		Node node12 = new Node(12);

		node1.next = node2;
		node2.prev = node1;
		node2.next = node3;
		node3.prev = node2;
		node3.next = node4;
		node4.prev = node3;
		node4.next = node5;
		node5.prev = node4;
		node5.next = node6;
		node5.prev = node5;

		node3.child = node7;

		node7.next = node8;
		node8.prev = node7;
		node8.next = node9;
		node9.prev = node8;
		node9.next = node10;
		node10.prev = node9;

		node8.child = node11;

		node11.next = node12;
		node12.prev = node11;

		Node result = flatten(node1);

		printLinkedList(result);
	}

	public static void main(String[] args) {
		new FlattenAMultilevelDoublyLinkedList().run();
	}

}
