package com.crystalsantos.coding.amazon.linkedlists;

import java.util.PriorityQueue;
import java.util.Queue;

import com.crystalsantos.coding.facebook.linkedlist.ListNode;

/**
 * Merge k Sorted Lists
 * 
 * You are given an array of k linked-lists lists, each linked-list is sorted in
 * ascending order.
 * 
 * Merge all the linked-lists into one sorted linked-list and return it.
 * 
 * Example 1:
 * 
 * Input: lists = [[1,4,5],[1,3,4],[2,6]] Output: [1,1,2,3,4,4,5,6] Explanation:
 * The linked-lists are: [ 1->4->5, 1->3->4, 2->6 ] merging them into one sorted
 * list: 1->1->2->3->4->4->5->6 Example 2:
 * 
 * Input: lists = [] Output: [] Example 3:
 * 
 * Input: lists = [[]] Output: []
 */
public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null) {
			return null;
		}

		if (lists.length == 0) {
			return null;
		}

		if (lists.length == 1) {
			return lists[0];
		}

		Queue<ListNode> queue = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);

		for (ListNode list : lists) {
			ListNode current = list;
			while (current != null) {
				queue.add(current);
				current = current.next;
			}
		}

		ListNode result = null;
		ListNode current = null;
		while (!queue.isEmpty()) {
			if (result == null) {
				result = queue.poll();
				current = result;
			} else {
				current.next = queue.poll();
				current = current.next;
			}
		}

		if (current != null) {
			current.next = null;
		}

		return result;
	}

	public static void main(String[] args) {
		MergeKSortedLists mergedLists = new MergeKSortedLists();
		mergedLists.run();
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
		System.out.println();
	}

	public void run() {
		ListNode node11 = new ListNode(1);
		ListNode node12 = new ListNode(4);
		ListNode node13 = new ListNode(5);
		node11.next = node12;
		node12.next = node13;

		ListNode node21 = new ListNode(1);
		ListNode node22 = new ListNode(3);
		ListNode node23 = new ListNode(4);
		node21.next = node22;
		node22.next = node23;

		ListNode node31 = new ListNode(2);
		ListNode node32 = new ListNode(6);
		node31.next = node32;

		printLinkedList(mergeKLists(new ListNode[] { node11, node21, node31 }));

		ListNode node41 = new ListNode(-2);
		ListNode node42 = new ListNode(-1);
		ListNode node43 = new ListNode(-1);
		ListNode node44 = new ListNode(-1);
		node41.next = node42;
		node42.next = node43;
		node43.next = node44;

		printLinkedList(mergeKLists(new ListNode[] { node41, null }));
	}
}
