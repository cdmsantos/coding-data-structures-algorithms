package com.crystalsantos.coding.linkedlist;

// Add any extra import statements you may need here
import java.util.Stack;

public class ReverseOperationsFacebook {

	class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
			next = null;
		}
	}

	// Add any helper functions you may need here

	Node reverse(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node newHead = null;
		Node newTail = null;
		Stack<Node> evenElements = new Stack<>();

		Node current = head;
		while (current != null) {

			if (current.data % 2 == 0) {
				evenElements.push(current);
			} else {
				while (!evenElements.isEmpty()) {
					Node even = evenElements.pop();
					even.next = null;

					if (newHead == null) {
						newHead = even;
					} else {
						newTail.next = even;
					}

					newTail = even;
				}

				if (newHead == null) {
					newHead = current;
				} else {
					newTail.next = current;
				}

				newTail = current;
			}

			current = current.next;
		}

		while (!evenElements.isEmpty()) {
			Node even = evenElements.pop();
			even.next = null;

			if (newHead == null) {
				newHead = even;
			} else {
				newTail.next = even;
			}

			newTail = even;
		}

		return newHead;
	}

	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom, but they are otherwise not editable!
	int test_case_number = 1;

	void printLinkedList(Node head) {
		System.out.print("[");
		while (head != null) {
			System.out.print(head.data);
			head = head.next;
			if (head != null)
				System.out.print(" ");
		}
		System.out.print("]");
	}

	void check(Node expectedHead, Node outputHead) {
		boolean result = true;
		Node tempExpectedHead = expectedHead;
		Node tempOutputHead = outputHead;
		while (expectedHead != null && outputHead != null) {
			result &= (expectedHead.data == outputHead.data);
			expectedHead = expectedHead.next;
			outputHead = outputHead.next;
		}
		if (!(expectedHead == null && outputHead == null))
			result = false;

		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printLinkedList(tempExpectedHead);
			System.out.print(" Your output: ");
			printLinkedList(tempOutputHead);
			System.out.println();
		}
		test_case_number++;
	}

	Node createLinkedList(int[] arr) {
		Node head = null;
		Node tempHead = head;
		for (int v : arr) {
			if (head == null) {
				head = new Node(v);
				tempHead = head;
			} else {
				head.next = new Node(v);
				head = head.next;
			}
		}
		return tempHead;
	}

	public void run() {

		int[] arr_1 = { 1, 2, 8, 9, 12, 16 };
		int[] expected1 = { 1, 8, 2, 9, 16, 12 };
		Node head_1 = createLinkedList(arr_1);
		Node expected_1 = createLinkedList(expected1);
		Node output_1 = reverse(head_1);
		check(expected_1, output_1);

		int[] arr_2 = { 2, 18, 24, 3, 5, 7, 9, 6, 12 };
		int[] expected2 = { 24, 18, 2, 3, 5, 7, 9, 12, 6 };
		Node head_2 = createLinkedList(arr_2);
		Node expected_2 = createLinkedList(expected2);
		Node output_2 = reverse(head_2);
		check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new ReverseOperationsFacebook().run();
	}
}