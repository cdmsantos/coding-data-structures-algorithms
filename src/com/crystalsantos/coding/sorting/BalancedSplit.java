package com.crystalsantos.coding.sorting;

import java.util.Arrays;

public class BalancedSplit {

	static boolean balancedSplitExists(int[] arr) {
		if (arr == null || arr.length <= 2) {
			return false;
		}
		
		Arrays.sort(arr);

		int i = 0;
		int j = arr.length - 1;
		int lastLeft = 0;
	    int lastRight = -1;
	    
		double left = 0;
		double right = 0;

		while (i <= j && lastLeft != lastRight) {
			if (left < right) {
				left += arr[i];
				lastLeft = arr[i];
				i++;
			} else if (right < left) {
				right += arr[j];
				lastRight = arr[j];
				j--;
			} else if (left == right) {
				left += arr[i];
				right += arr[j];
				lastLeft = arr[i];
				lastRight = arr[j];
				i++;
				j--;
			}
		}

		if (left == right && lastLeft != lastRight) {
			return true;
		} else {
			return false;
		}

	}

	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom, but they are otherwise not editable!
	static int test_case_number = 1;

	static void check(boolean expected, boolean output) {
		boolean result = (expected == output);
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			System.out.print(expected);
			System.out.print(" Your output: ");
			System.out.print(output);
			System.out.println();
		}
		test_case_number++;
	}

	static void printString(String str) {
		System.out.print("[" + str + "]");
	}

	static public void run() {
		int arr_1[] = { 2, 1, 2, 5 };
		boolean expected_1 = true;
		boolean output_1 = balancedSplitExists(arr_1);
		check(expected_1, output_1);

		int arr_2[] = { 3, 6, 3, 4, 4 };
		boolean expected_2 = false;
		boolean output_2 = balancedSplitExists(arr_2);
		check(expected_2, output_2);
	}

	public static void main(String[] args) {
		run();
	}
}