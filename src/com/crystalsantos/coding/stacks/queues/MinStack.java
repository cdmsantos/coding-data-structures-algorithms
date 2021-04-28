package com.crystalsantos.coding.stacks.queues;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinStack {
	
	private List<Integer> stack;
	private PriorityQueue<Integer> minimum;

    public MinStack() {
        stack = new ArrayList<Integer>();
        minimum = new PriorityQueue<Integer>();
    }
    
    public void push(int val) {
    	minimum.add(val);
        stack.add(val);
    }
    
    public void pop() {
        if(stack.size() != 0) {
        	int pop = stack.remove(stack.size()-1);
        	minimum.remove(pop);
        }
    }
    
    public int top() {
        return stack.get(stack.size() - 1);
    }
    
    public int getMin() {
    	if(stack.size() == 0) {
    		return -1;
    	}
        return minimum.peek();
    }
}
