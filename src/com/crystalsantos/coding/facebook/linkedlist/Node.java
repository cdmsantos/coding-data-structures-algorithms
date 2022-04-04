package com.crystalsantos.coding.facebook.linkedlist;

public class Node {
	public int val;
	public Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}

	public Node(int val, Node next) {
		this.val = val;
		this.next = next;
	}
}
