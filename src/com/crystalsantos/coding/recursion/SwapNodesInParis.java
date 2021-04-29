package com.crystalsantos.coding.recursion;

public class SwapNodesInParis {
	public class ListNode {
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

	public ListNode swapPairs(ListNode head) {
		if(head == null) {
			return null;
		}
		
		if(head != null && head.next == null) {
			return head;
		}
		
		return swap(head);
	}
	
	private ListNode swap(ListNode node) {
		if(node != null && node.next != null) {
			ListNode temp = node;
			ListNode tempNext = node.next;
			temp.next = node.next.next;
			node = tempNext;
			node.next = temp;
		}

		if(node!= null && node.next != null && node.next.next != null) {
			node.next.next = swap(node.next.next);
		}
		
		return node;
	}
	
	
	private void run() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		ListNode result = swapPairs(node1);
		System.out.println(result.val);
	}
	
	public static void main(String[] args) {
		new SwapNodesInParis().run();
	}
}
