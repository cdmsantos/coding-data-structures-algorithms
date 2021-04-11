package com.crystalsantos.coding.search;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumTimeRequired {

	// BST logic
	static long minTime(long[] machines, long goal) {
		Arrays.sort(machines);
		long slowest = machines[machines.length - 1];
		long fastest = machines[0];
		
		// if all machines are equal to the faster one
		// this will be the minimum days required 
		long minDays = fastest * goal / machines.length; 
		
		//if all machines are equal to the slower one
		// this will be the maximum days required 
		long maxDays = slowest * goal / machines.length; 
		
		long minTime = -1;
		
		while (minDays < maxDays) {
			
			// In binary search we always start at the middle of our bounds
			long mid = (minDays + maxDays) / 2;
			
			long units = 0;
			for (long machine : machines) {
				units += mid / machine;
			}
			
			// change the boundaries
			if (units < goal) {
				minDays = mid + 1;
			} else {
				minTime = mid;
				maxDays = mid;
			}
		}
		return minTime;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nGoal = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nGoal[0]);

		long goal = Long.parseLong(nGoal[1]);

		long[] machines = new long[n];

		String[] machinesItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			long machinesItem = Long.parseLong(machinesItems[i]);
			machines[i] = machinesItem;
		}

		System.out.println(minTime(machines, goal));

		scanner.close();
	}
}
