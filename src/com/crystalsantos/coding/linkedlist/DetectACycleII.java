package com.crystalsantos.coding.linkedlist;

public class DetectACycleII {
	static class Node {
		public int data;
		public Node next;

		public Node(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}
	
	boolean hasCycle(Node head) {
		boolean cycle = false;
		
		if(head == null || head.next == null) {
			return cycle;
		}
		
		Node pointerOne = head;
		Node pointerTwo = head;
		
		while(pointerTwo != null && pointerTwo.next != null) {
			pointerOne = pointerOne.next;
            pointerTwo = pointerTwo.next.next;
            
            if(pointerOne == pointerTwo) {
                return true;
            }
		}
		
		return cycle;
	}
}
