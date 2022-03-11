package com.crystalsantos.coding.linkedlist;

import com.crystalsantos.coding.facebook.linkedlist.ListNode;

/***
 * 
 * Delete Node in a Linked List
 * 
 * Write a function to delete a node in a singly-linked list. You will not be
 * given access to the head of the list, instead you will be given access to the
 * node to be deleted directly.
 * 
 * It is guaranteed that the node to be deleted is not a tail node in the list.
 * 
 * Example 1:
 * 
 * Input: head = [4,5,1,9], node = 5 Output: [4,1,9] Explanation: You are given
 * the second node with value 5, the linked list should become 4 -> 1 -> 9 after
 * calling your function. Example 2:
 * 
 * 
 * Input: head = [4,5,1,9], node = 1 Output: [4,5,9] Explanation: You are given
 * the third node with value 1, the linked list should become 4 -> 5 -> 9 after
 * calling your function.
 * 
 * Constraints:
 * 
 * The number of the nodes in the given list is in the range [2, 1000]. -1000 <=
 * Node.val <= 1000 The value of each node in the list is unique. The node to be
 * deleted is in the list and is not a tail node
 * 
 */
public class DeleteNodeInALinkedList {
	public void deleteNode(ListNode node) {
		if (node != null) {
			ListNode temp = node.next;
			node.val = temp.val;
			node.next = temp.next;
		}
	}

	public static void main(String[] args) {
		DeleteNodeInALinkedList deleteNode = new DeleteNodeInALinkedList();
		deleteNode.run();
	}

	private void run() {
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(9);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		deleteNode(node2);
		printNodes(node1);
		
	}
	
	private void printNodes(ListNode node) {
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
}
