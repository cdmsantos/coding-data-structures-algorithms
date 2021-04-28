package com.crystalsantos.coding.stacks.queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyStack {
	Queue<Integer> head;
	Queue<Integer> tail;

	public MyStack() {
		head = new LinkedList<Integer>();
		tail = new LinkedList<Integer>();
	}

	public void push(int x) {
		head.add(x);
	}

	public int pop() {
		if(tail.isEmpty()) {
			transferFromOneToTwo();
		}
		
		return tail.remove();
	}

	public int top() {
		if(tail.isEmpty()) {
			transferFromOneToTwo();
		}
		
		if(!head.isEmpty()) {
			return head.peek();
		}
		
		return tail.peek();
	}

	public boolean empty() {
		return head.isEmpty() && tail.isEmpty();
	}

	private void transferFromOneToTwo() {
		if (tail.isEmpty()) {
			List<Integer> elements = new ArrayList<Integer>();
			while (!head.isEmpty()) {
				elements.add(head.remove());
			}

			for (int i = elements.size() - 1; i >= 0; i--) {
				tail.add(elements.get(i));
			}
		}
	}
	
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.top());
		stack.push(3);
		System.out.println(stack.top());		
	}
}
