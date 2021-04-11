package com.crystalsantos.coding.random;

import java.util.Scanner;

public class QueueUsingTwoStacksPartialSolution {
        
    private static class Node {
        int data;
        Node next;
        
        public Node (int data) {
            this.data = data;
        }
    }
    
    private static Node top = null;
    private static Node newTop = null; 

    private static void push(int data) {
    	Node newNode = new Node(data);
    	
    	if(top == null) {
    		top = newNode;
    		return;
    	}
    	
    	newNode.next = top;
    	top = newNode;
    }
    
    private static void pushNewTop(int data) {
    	Node newNode = new Node(data);
    	
    	if(newTop == null) {
    		newTop = newNode;
    		return;
    	}
    	
    	newNode.next = newTop;
    	newTop = newNode;
    }
    
    private static Node pop() {
    	if(top == null) {
    		return null;
    	}
    	
    	Node removedNode = top;
    	top = top.next;
    	return removedNode;
    }
    
    private static Node popNewTop() {
    	if(newTop == null) {
    		return null;
    	}
    	
    	Node removedNode = newTop;
    	newTop = newTop.next;
    	return removedNode;
    }
    
    private static void enqueue(int data) {
    	push(data);
    }
    
    private static void dequeue() {
    	if(top != null) {
        	newTop = null;
        	
    		while(top.next != null) {
        		Node removedNode = pop();
        		pushNewTop(removedNode.data);
        	}
        	
        	pop();
        	
        	if(newTop == null) {
        		top = null;
        		return;
        	}
        	
        	while(newTop.next != null) {
        		Node removedNode = popNewTop();
        		push(removedNode.data);
        	}
        	
        	push(newTop.data);
    	}
    }
    
    private static int printHead() {
    	if(top.next == null) {
    		return top.data;
    	}
    	
    	Node current = top;
    	while(current.next != null) {
    		current = current.next;
    	}
    	
    	return current.data;
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int numberOfQueries = scanner.nextInt();
                
        for(int i = 0; i < numberOfQueries; i++) {
            int option = scanner.nextInt();
            if(option == 1) { 
            	enqueue(scanner.nextInt());
            } else if(option == 2) {
            	dequeue();
            } else { 
            	System.out.println(printHead());
            }
            
        }
        
        scanner.close();
    }
}