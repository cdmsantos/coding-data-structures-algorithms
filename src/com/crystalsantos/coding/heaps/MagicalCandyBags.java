package com.crystalsantos.coding.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MagicalCandyBags {

	static int maxCandies(int[] arr, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		int maxCandies = 0;
		
		for(int i = 0; i < arr.length; i++) {
			queue.add(arr[i]);
		}
		
		for(int i = 0; i < k; i++) {
			int candy = queue.poll();
			maxCandies += candy;
			
			queue.add(candy/2);
		}
		
		return maxCandies;
	}

	static int test_case_number = 1;

	static void check(int expected, int output) {
		boolean result = (expected == output);
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printInteger(expected);
			System.out.print(" Your output: ");
			printInteger(output);
			System.out.println();
		}
		test_case_number++;
	}

	static void printInteger(int n) {
		System.out.print("[" + n + "]");
	}

	static public void run() {
		int k_1 = 3;
		int[] arr_1 = { 2, 1, 7, 4, 2 };
		int expected_1 = 14;
		int output_1 = maxCandies(arr_1, k_1);
		check(expected_1, output_1);

		int k_2 = 3;
		int[] arr_2 = { 19, 78, 76, 72, 48, 8, 24, 74, 29 };
		int expected_2 = 228;
		int output_2 = maxCandies(arr_2, k_2);
		check(expected_2, output_2);
	}

	public static void main(String[] args) {
		run();
	}
}