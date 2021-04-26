package com.crystalsantos.coding.linkedlist;

public class AddTwoNumbers {
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
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        
        if (l1 == null && l2 != null) {
            return l2;
        }
        
        if (l1 != null && l2 == null) {
            return l1;
        }
        
        ListNode currentL1 = l1;
        ListNode previousCurrentL1 = l1;
        ListNode currentL2 = l2;
        
        int sendToNextNumber = 0;
        while (currentL1 != null && currentL2 != null) {
            int newValue = (currentL1.val + currentL2.val + sendToNextNumber)%10;
            sendToNextNumber = (currentL1.val + currentL2.val + sendToNextNumber)/10;
            
            currentL1.val = newValue;
            
            previousCurrentL1 = currentL1;
            currentL1 = currentL1.next;
            currentL2 = currentL2.next;
        }
        
        if(currentL1 != null) {
            if(sendToNextNumber != 0) {
                while(sendToNextNumber != 0 && currentL1 != null) {
                    int newValue = (currentL1.val + sendToNextNumber)%10;
                    sendToNextNumber = (currentL1.val + sendToNextNumber)/10;

                    currentL1.val = newValue;
                    previousCurrentL1 = currentL1;
                    currentL1 = currentL1.next;
                }
            }
        }

        if(currentL2 != null) {
            while(currentL2 != null) {
                int newValue = (currentL2.val + sendToNextNumber)%10;
                sendToNextNumber = (currentL2.val + sendToNextNumber)/10;

                if(currentL1 == null) {
                	currentL1 = new ListNode(newValue);
                	previousCurrentL1.next = currentL1;
                	previousCurrentL1 = currentL1;
                	currentL1 = currentL1.next;
                } else {
                	currentL1.next = new ListNode(newValue);
                	previousCurrentL1 = currentL1;
                	currentL1 = currentL1.next;
                }
                
                currentL2 = currentL2.next;
            }
        }
        
        if(sendToNextNumber != 0) {
            currentL1 = new ListNode(sendToNextNumber);
            previousCurrentL1.next = currentL1;
        }
        
        return l1;
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
		
		ListNode node1 = new ListNode(0);
		ListNode node21 = new ListNode(7);
		ListNode node22 = new ListNode(3);
		node21.next = node22;
		ListNode result = addTwoNumbers(node1, node21);
		
		printLinkedList(result);
	}

	public static void main(String[] args) {
		new AddTwoNumbers().run();
	}

}
