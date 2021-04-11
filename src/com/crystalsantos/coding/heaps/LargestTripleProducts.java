package com.crystalsantos.coding.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class LargestTripleProducts {

	static int[] findMaxProduct(int[] arr) {
		int[] products = new int[arr.length];
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i = 0; i < arr.length; i++) {
			queue.add(arr[i]);
			
			if(queue.size() < 3) {
				products[i] = -1;
			} else {
				int a = queue.poll();
				int b = queue.poll();
				int c = queue.poll();
				
				products[i] = a*b*c;
				queue.add(a);
				queue.add(b);
				queue.add(c);
			}
		}
		
		return products;
	}

	static int test_case_number = 1;

	static void check(int[] expected, int[] output) {
		int expected_size = expected.length;
		int output_size = output.length;
		boolean result = true;
		if (expected_size != output_size) {
			result = false;
		}
		for (int i = 0; i < Math.min(expected_size, output_size); i++) {
			result &= (output[i] == expected[i]);
		}
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printIntegerArray(expected);
			System.out.print(" Your output: ");
			printIntegerArray(output);
			System.out.println();
		}
		test_case_number++;
	}

	static void printIntegerArray(int[] arr) {
		int len = arr.length;
		System.out.print("[");
		for (int i = 0; i < len; i++) {
			if (i != 0) {
				System.out.print(", ");
			}
			System.out.print(arr[i]);
		}
		System.out.print("]");
	}

	static public void run() {
		int[] arr_1 = { 1, 2, 3, 4, 5 };
		int[] expected_1 = { -1, -1, 6, 24, 60 };
		int[] output_1 = findMaxProduct(arr_1);
		check(expected_1, output_1);

		int[] arr_2 = { 2, 4, 7, 1, 5, 3 };
		int[] expected_2 = { -1, -1, 56, 56, 140, 140 };
		int[] output_2 = findMaxProduct(arr_2);
		check(expected_2, output_2);
	}

	public static void main(String[] args) {
		run();
	}
}