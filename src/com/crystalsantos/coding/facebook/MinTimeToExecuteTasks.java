package com.crystalsantos.coding.facebook;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

/*
 * Given a set of tasks, and int k, which is the waiting time between two same tasks. 
 * Calculate the min total execution time if you are allowed to rearrange the tasks. 
 * Assume the execution for each individual task is 1.
 * 
 * Example:
 * Input: tasks = [A A B], k = 1
 * Output: 3
 * 
 * Explanation:
 * Without rearrangement, the execution time would be 4:
 * A wait A B 
 * 1  1   1 1
 * 
 * With rearrangement, the execution time would be 3:
 * 
 * A B A
 * 1 1 1
 * */
public class MinTimeToExecuteTasks {
	public String rearrange(String str) {
		final Stack<Character> stack = new Stack<>();
		final List<Character> tasks = new LinkedList<Character>();
		
		for (final char c : str.toCharArray()) {
			tasks.add(c);
		}
		
		Iterator<Character> it = tasks.iterator();
		final Set<Character> allItems = new HashSet<>();
		while (!tasks.isEmpty()) {
			if (!it.hasNext()) {
				final Set<Character> dups = tasks.stream().filter(e -> !allItems.add(e)).collect(Collectors.toSet());
				if (dups.size() > 1) {
					it = tasks.iterator();
				} else {
					tasks.stream().forEach(e -> stack.push(e));
					tasks.clear();
					continue;
				}
			}
			final char c = it.next();
			if (stack.isEmpty() || (stack.peek() != c)) {
				stack.push(c);
				it.remove();
			}
		}
		return stack.toString();
	}
}
