package com.crystalsantos.coding.linkedlist;

public class MyDoublyLinkesList {

	public class LinkedListNode {
		public int data;
		public LinkedListNode next;
		public LinkedListNode previous;

		public LinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
			this.previous = null;
		}
	}

	public static LinkedListNode head;

	/** Initialize your data structure here. */
	public MyDoublyLinkesList() {
		head = null;
	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {
		if (head == null) {
			return -1;
		}

		if (head != null && index == 0) {
			return head.data;
		}

		if (index > 0) {
			int findIndex = 0;
			LinkedListNode temp = head;

			while (temp != null && findIndex < index) {
				findIndex++;
				temp = temp.next;
			}

			if (temp != null) {
				return temp.data;
			}
		}
		return -1;
	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		if (head == null) {
			head = new LinkedListNode(val);
		} else {
			LinkedListNode newHead = new LinkedListNode(val);
			head.previous = newHead;
			newHead.next = head;
			head = newHead;
		}
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		if (head == null) {
			addAtHead(val);
		} else {
			LinkedListNode newNode = new LinkedListNode(val);
			LinkedListNode current = head;

			while (current.next != null) {
				current = current.next;
			}

			current.next = newNode;
			newNode.previous = current;
		}
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted.
	 */
	public void addAtIndex(int index, int val) {
		if (index == 0) {
			addAtHead(val);
		} else if (index > 0) {
			LinkedListNode newNode = new LinkedListNode(val);

			int findIndex = 0;
			LinkedListNode current = head;

			while (current.next != null && findIndex != index - 1) {
				findIndex++;
				current = current.next;
			}

			if (findIndex == index - 1) {
				LinkedListNode temp = current.next;

				if (temp != null) {
					current.next = newNode;
					temp.previous = newNode;
					newNode.next = temp;
					newNode.previous = current;
				} else {
					current.next = newNode;
					newNode.previous = current;
				}
			}
		}
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if (index == 0 && head != null) {
			head = head.next;
		} else if (index > 0) {
			int findIndex = 0;
			LinkedListNode current = head;

			while (current.next != null && findIndex != index - 1) {
				findIndex++;
				current = current.next;
			}

			if (current.next != null) {
				LinkedListNode temp = current.next;
				current.next = temp.next;
				temp.previous = current;
			}
		}
	}

	public static void main(String[] args) {
		MyDoublyLinkesList myList = new MyDoublyLinkesList();
		myList.addAtHead(7);
		myList.addAtHead(2);
		myList.addAtHead(1);
		myList.addAtIndex(3, 0);
		myList.deleteAtIndex(2);
		myList.addAtHead(6);
		myList.addAtTail(4);
		System.out.println(myList.get(4));
		myList.addAtHead(4);
		myList.addAtIndex(5, 0);
		myList.addAtHead(6);

		LinkedListNode current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList(); int param_1 = obj.get(index);
 * obj.addAtHead(val); obj.addAtTail(val); obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
