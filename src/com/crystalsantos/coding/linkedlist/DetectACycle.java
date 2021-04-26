package com.crystalsantos.coding.linkedlist;

import java.util.HashSet;

public class DetectACycle {
	static class Node {
		public int data;
		public Node next;

		public Node(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	boolean hasCycle(Node head) {
		HashSet<Node> hashNode = new HashSet<>();
		while (head != null) {
			if (hashNode.contains(head)) {
				return true;
			}
			hashNode.add(head);
			head = head.next;
		}
		return false;
	}
}
