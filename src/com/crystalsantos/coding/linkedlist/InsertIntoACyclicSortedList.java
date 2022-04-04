package com.crystalsantos.coding.linkedlist;

import com.crystalsantos.coding.facebook.linkedlist.Node;

/**
 * Insert into a Cyclic Sorted List
 * 
 * 
 * Given a Circular Linked List node, which is sorted in ascending order, write
 * a function to insert a value insertVal into the list such that it remains a
 * sorted circular list. The given node can be a reference to any single node in
 * the list and may not necessarily be the smallest value in the circular list.
 * 
 * If there are multiple suitable places for insertion, you may choose any place
 * to insert the new value. After the insertion, the circular list should remain
 * sorted.
 * 
 * If the list is empty (i.e., the given node is null), you should create a new
 * single circular list and return the reference to that single node. Otherwise,
 * you should return the originally given node.
 * 
 * Example 1:
 * 
 * Input: head = [3,4,1], insertVal = 2 Output: [3,4,1,2] Explanation: In the
 * figure above, there is a sorted circular list of three elements. You are
 * given a reference to the node with value 3, and we need to insert 2 into the
 * list. The new node should be inserted between node 1 and node 3. After the
 * insertion, the list should look like this, and we should still return node 3.
 * 
 * Example 2:
 * 
 * Input: head = [], insertVal = 1 Output: [1] Explanation: The list is empty
 * (given head is null). We create a new single circular list and return the
 * reference to that single node. Example 3:
 * 
 * Input: head = [1], insertVal = 0 Output: [1,0]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [0, 5 * 104]. -106 <=
 * Node.val, insertVal <= 106
 */
public class InsertIntoACyclicSortedList {
	public Node insert(Node head, int insertVal) {
		Node newNode = new Node(insertVal);
		if (head == null) {
			newNode.next = newNode;
			return newNode;
		}

		Node previous = head;
		Node current = head.next;
		boolean toInsert = false;

		do {
			if (previous.val <= insertVal && insertVal <= current.val) {
				// Case 1). The value of new node sits between the minimal and maximal values of
				// the current list. As a result, it should be inserted within the list.
				toInsert = true;
			} else if (previous.val > current.val) {
				// Case 2). The value of new node goes beyond the minimal and maximal values of
				// the current list, either less than the minimal value or greater than the
				// maximal value. In either case, the new node should be added right after the
				// tail node (i.e. the node with the maximal value of the list).
				if (insertVal >= previous.val || insertVal <= current.val)
					toInsert = true;
			}

			if (toInsert) {
				previous.next = new Node(insertVal, current);
				return head;
			}

			previous = current;
			current = current.next;
		} while (previous != head);

		// Case 3). Finally, there is one case that does not fall into any of the above
		// two cases. This is the case where the list contains uniform values.
		previous.next = new Node(insertVal, current);
		return head;
	}
}
