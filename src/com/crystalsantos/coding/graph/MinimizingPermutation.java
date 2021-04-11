package com.crystalsantos.coding.graph;

public class MinimizingPermutation {
	static int[] swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}

	static int[] flip(int[] arr, int i, int j) {
		while (i < j) {
			arr = swap(arr, i, j);
			i++;
			j--;
		}
		return arr;
	}

	static int minOperations(int[] arr) {
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != i + 1) {
				int j = i + 1;
				while (arr[j] != i + 1) {
					j++;
				}
				flip(arr, i, j);
				result++;
			}
		}
		return result;
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
		int[] arr_1 = { 1, 2, 5, 4, 3 };
		int expected_1 = 1;
		int output_1 = minOperations(arr_1);
		check(expected_1, output_1);

		int[] arr_2 = { 3, 1, 2 };
		int expected_2 = 2;
		int output_2 = minOperations(arr_2);
		check(expected_2, output_2);
	}

	public static void main(String[] args) {
		run();
	}
}