package com.crystalsantos.coding.greedy;

import java.util.Arrays;

public class SlowSums {

	static int getTotalTime(int[] arr) {
		if (arr.length == 1) {
			return arr[0];
		}

		if (arr.length == 2) {
			return arr[0] + arr[1];
		}

		Arrays.sort(arr);

		int penalties = 0;
		int lastPenalty = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (lastPenalty == 0) {
				lastPenalty = lastPenalty + arr[i] + arr[i - 1];
				i--;
				penalties += lastPenalty;
			} else {
				lastPenalty = lastPenalty + arr[i];
				penalties += lastPenalty;
			}
		}

		return penalties;
	}

	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom, but they are otherwise not editable!
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
		int[] arr_1 = { 4, 2, 1, 3 };
		int expected_1 = 26;
		int output_1 = getTotalTime(arr_1);
		check(expected_1, output_1);

		int[] arr_2 = { 2, 3, 9, 8, 4 };
		int expected_2 = 88;
		int output_2 = getTotalTime(arr_2);
		check(expected_2, output_2);
	}

	public static void main(String[] args) {
		run();
	}
}