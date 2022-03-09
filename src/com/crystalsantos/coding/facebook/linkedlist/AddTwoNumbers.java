package com.crystalsantos.coding.facebook.linkedlist;

/***
 * 
 * Add Two Numbers
 * 
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: l1 = [2,4,3], l2 = [5,6,4] Output: [7,0,8] Explanation: 342 + 465 =
 * 807. Example 2:
 * 
 * Input: l1 = [0], l2 = [0] Output: [0] Example 3:
 * 
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] Output: [8,9,9,9,0,0,0,1]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in each linked list is in the range [1, 100]. 0 <=
 * Node.val <= 9 It is guaranteed that the list represents a number that does
 * not have leading zeros.
 * 
 * 
 *
 */

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode currentL1 = l1;
		ListNode currentL2 = l2;

		if (l1 == null && l2 == null) {
			return new ListNode();
		}

		if (l1 == null && l2 != null) {
			return l2;
		}

		if (l1 != null && l2 == null) {
			return l1;
		}

		int carry = 0;
		boolean start = true;
		ListNode sum = new ListNode();
		ListNode currentSum = sum;
		while (currentL1 != null && currentL2 != null) {
			int partialSum = (currentL1.val + currentL2.val + carry) % 10;
			carry = (currentL1.val + currentL2.val + carry) / 10;

			if (start) {
				currentSum.val = partialSum;
				start = false;
			} else {
				currentSum.next = new ListNode(partialSum);
				currentSum = currentSum.next;
			}

			currentL1 = currentL1.next;
			currentL2 = currentL2.next;
		}
		
		if(currentL1 != null) {
			while(currentL1 != null) {
				int partialSum = (currentL1.val + carry) % 10;
				carry = (currentL1.val + carry) / 10;
				currentSum.next = new ListNode(partialSum);
				currentSum = currentSum.next;
				currentL1 = currentL1.next;
			}
		}
		
		if(currentL2 != null) {
			while(currentL2 != null) {
				int partialSum = (currentL2.val + carry) % 10;
				carry = (currentL2.val + carry) / 10;
				currentSum.next = new ListNode(partialSum);
				currentSum = currentSum.next;
				currentL2 = currentL2.next;
			}
		}
		
		if(carry != 0) {
			currentSum.next = new ListNode(carry);
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		AddTwoNumbers add = new AddTwoNumbers();
		add.run();
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
    
	private void run() {
//		ListNode node1 = new ListNode(2);
//		ListNode node12 = new ListNode(4);
//		ListNode node13 = new ListNode(3);
//		node1.next = node12;
//		node12.next = node13;
//		
//		ListNode node2 = new ListNode(5);
//		ListNode node22 = new ListNode(6);
//		ListNode node23 = new ListNode(4);
//		node2.next = node22;
//		node22.next = node23;
//		ListNode result = addTwoNumbers(node1, node2);
		
//		ListNode node1 = new ListNode(9);
//		ListNode node2 = new ListNode(9);
//		ListNode node3 = new ListNode(9);
//		ListNode node4 = new ListNode(9);
//		ListNode node5 = new ListNode(9);
//		ListNode node6 = new ListNode(9);
//		ListNode node7 = new ListNode(9);
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;
//		node5.next = node6;
//		node6.next = node7;
//		
//		ListNode node21 = new ListNode(9);
//		ListNode node22 = new ListNode(9);
//		ListNode node23 = new ListNode(9);
//		ListNode node24 = new ListNode(9);
//		node21.next = node22;
//		node22.next = node23;
//		node23.next = node24;
//		ListNode result = addTwoNumbers(node1, node21);
		
		ListNode node1 = new ListNode(2);
		ListNode node12 = new ListNode(4);
		ListNode node13 = new ListNode(9);
		node1.next = node12;
		node12.next = node13;
		
		ListNode node2 = new ListNode(5);
		ListNode node22 = new ListNode(6);
		ListNode node23 = new ListNode(4);
		ListNode node24 = new ListNode(9);
		node2.next = node22;
		node22.next = node23;
		node23.next = node24;
		ListNode result = addTwoNumbers(node1, node2);
		printLinkedList(result);
	}
}
