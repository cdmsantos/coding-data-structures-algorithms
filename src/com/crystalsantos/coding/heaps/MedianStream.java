package com.crystalsantos.coding.heaps;

import java.util.ArrayList;
import java.util.Collections;

public class MedianStream {

	static int[] findMedian(int[] arr) {
		int[] medians = new int[arr.length];
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < arr.length; i++) {
			int number = arr[i];
			list.add(number);
			
			if(i < 1) {
				medians[i] = number;
			} else {
				int size = list.size();
				Collections.sort(list);

				if(size%2 == 0) {
					medians[i] = (list.get(size/2)+list.get((size-1)/2))/2;
				} else {
					medians[i] = list.get(size/2);
				}
			}
		}
		
		return medians;
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
		int[] arr_1 = { 5, 15, 1, 3 };
		int[] expected_1 = { 5, 10, 5, 4 };
		int[] output_1 = findMedian(arr_1);
		check(expected_1, output_1);

		int[] arr_2 = { 2, 4, 7, 1, 5, 3 };
		int[] expected_2 = { 2, 3, 4, 3, 4, 3 };
		int[] output_2 = findMedian(arr_2);
		check(expected_2, output_2);
	}

	public static void main(String[] args) {
		run();
	}
}