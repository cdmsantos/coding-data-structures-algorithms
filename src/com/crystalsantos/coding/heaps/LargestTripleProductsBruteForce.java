package com.crystalsantos.coding.heaps;

import java.util.Arrays;

public class LargestTripleProductsBruteForce {

	static int[] findMaxProduct(int[] arr) {
		//base cases
		if(arr.length == 0) {
			return null;
		}
		
		if(arr.length == 1) {
			return new int[] {-1};
		}
		
		if(arr.length == 2) {
			return new int[] {-1, -1};
		}
		
		int[] products = new int[arr.length];
		
		products[0] = -1;
		products[1] = -1;
		
		for(int i = 2; i < arr.length; i++) {
			int[] temp = new int[i+1];
			for(int j = 0; j <= i; j++) {
				temp[j] = arr[j];
			}
			Arrays.sort(temp);
			products[i] = temp[i] * temp[i-1] * temp[i-2];
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