package com.crystalsantos.coding.linkedlist;
import java.io.IOException;
import java.util.Scanner;

public class ReverseADoublyLinkedList {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep) throws IOException {
        while (node != null) {
            System.out.println(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
            	System.out.println(sep);
            }
        }
    }

    // Complete the reverse function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {

    	if(head == null || (head.next == null)) {
    		return head;
    	}
    	
    	DoublyLinkedListNode current = head;
    	
    	//find currenttail
    	while(current.next != null) {
    		current = current.next;
    	}
    	
    	//define new head
    	current.next = current.prev;
    	current.prev = null;
    	head = current;
    	
    	//reverse others
    	current = head.next;

    	while(current.prev != null) {
    		DoublyLinkedListNode temp = current.next;
    		current.next = current.prev;
    		current.prev = temp;
    		
    		current = current.next;
    	}
    	
    	//define new tail
		DoublyLinkedListNode temp = current.next;
    	current.next = null;
    	current.prev = temp;
    	
    	return head;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            DoublyLinkedListNode llist1 = reverse(llist.head);

            printDoublyLinkedList(llist1, " ");
            System.out.println();
        }
        
        scanner.close();
    }
}
