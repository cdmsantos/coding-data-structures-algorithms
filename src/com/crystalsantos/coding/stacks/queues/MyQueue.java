package com.crystalsantos.coding.stacks.queues;

import java.util.Stack;

public class MyQueue {
	private Stack<Integer> one;
	private Stack<Integer> two;

	public MyQueue() {
		this.one = new Stack<Integer>();
		this.two = new Stack<Integer>();
	}

	public void push(int x) {
		one.push(x);
	}

	public int pop() {
		transferFromOneToTwo();
		return two.pop();
	}

	public int peek() {
		transferFromOneToTwo();
		return two.peek();
	}

	public boolean empty() {
		return one.isEmpty() && two.isEmpty();
	}
	
	private void transferFromOneToTwo() {
		if (two.isEmpty()) {
			while (!one.isEmpty()) {
				two.push(one.pop());
			}
		}
	}
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */