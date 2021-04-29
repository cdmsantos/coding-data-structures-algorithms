package com.crystalsantos.coding.recursion;

import java.util.HashMap;

public class ClimbingStairs {

	private HashMap<Integer, Integer> store = new HashMap<Integer, Integer>();
	
	public int climbStairs(int n) {

		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}

		return climbWays(n);
	}

	private int climbWays(int n) {
		
		if(store.containsKey(n)) {
			return store.get(n);
		}
		
		int result = 0;

		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}

		result = climbWays(n - 1) + climbWays(n - 2);
		
		store.put(n, result);
		return result;
	}
	
	public static void main(String[] args) {
		ClimbingStairs climbing = new ClimbingStairs();
		System.out.println(climbing.climbStairs(3));
	}

}
