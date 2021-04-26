package com.crystalsantos.coding.linkedlist;

public class MergeTwoSortedLists {
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
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
        
        if(l1 == null && l2 != null) {
            return l2;
        }
        
        if(l1 != null && l2 == null) {
            return l1;
        }
        
        ListNode currentL1 = l1;
        ListNode currentL2 = l2;
        ListNode mergedListHead = null;
        ListNode mergedListCurrent = null;

        while(currentL1 != null && currentL2 != null) {
            
            if(currentL1.val <= currentL2.val) {
                if(mergedListHead == null) {
                    mergedListHead = currentL1;
                    mergedListCurrent = currentL1;
                } else {
                    mergedListCurrent.next = currentL1;
                    mergedListCurrent = currentL1;
                }
                currentL1 = currentL1.next;
            } else {
                if(mergedListHead == null) {
                    mergedListHead = currentL2;
                    mergedListCurrent = currentL2;
                } else {
                    mergedListCurrent.next = currentL2;
                    mergedListCurrent = currentL2;
                }
                currentL2 = currentL2.next;
            }
        }
        
        if(currentL1 != null) { //copy remaining elements from L1
            mergedListCurrent.next = currentL1;
        }
        
        if(currentL2 != null) { //copy remaining elements from L2
            mergedListCurrent.next = currentL2;
        }
        
        return mergedListHead;
    }
}
