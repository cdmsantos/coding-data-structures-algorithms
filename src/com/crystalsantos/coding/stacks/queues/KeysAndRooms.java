package com.crystalsantos.coding.stacks.queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class KeysAndRooms {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		Set<Integer> set = new HashSet<Integer>();
		Stack<Integer> stack = new Stack<>();
		set.add(0);
		stack.add(0);
		while (!stack.isEmpty()) {
			int keyPopped = stack.pop();
			List<Integer> keys = rooms.get(keyPopped);
			for (Integer key : keys) {
				if (!set.contains(key)) {
					stack.push(key);
					set.add(key);
				}
			}
		}

		return set.size() == rooms.size();
	}

	public static void main(String[] args) {
		KeysAndRooms keysAndRooms = new KeysAndRooms();
		List<List<Integer>> rooms = new ArrayList<List<Integer>>();
		rooms.add(Arrays.asList(1));
		rooms.add(Arrays.asList(2));
		rooms.add(Arrays.asList());
		rooms.add(Arrays.asList(3));

		System.out.println(keysAndRooms.canVisitAllRooms(rooms));
	}
}
