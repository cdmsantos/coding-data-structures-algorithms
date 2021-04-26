package com.crystalsantos.coding.linkedlist;

public class ReverseLinkedList {
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

    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        
        if(head.next == null) {
            return head;
        }
        
        ListNode newHead = null;
        ListNode current = null;

        while(head.next != null) {
            current = head.next;
            head.next = current.next;
            
            if(newHead == null) {
            	current.next = head;
            	newHead = current;            	
            } else {
            	current.next = newHead;
            	newHead = current;
            }
        }
        
        return newHead;
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

		ListNode result = reverseList(node1);
		printLinkedList(result);
	}

	public static void main(String[] args) {
		new ReverseLinkedList().run();
	}
}
