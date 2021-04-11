package com.crystalsantos.coding.greedy;

//Add any extra import statements you may need here

public class ElementSwapping {

	static int[] findMinArray(int[] arr, int k) {
		for (int i = 0; i < arr.length - 1 && k > 0; ++i) {

			int pos = i;
			for (int j = i + 1; j < arr.length; ++j) {

				// If we exceed the Max swaps then terminate the loop
				if (j - i > k) {
					break;
				}

				// Find the minimum value from i+1 to max k or n
				if (arr[j] < arr[pos]) {
					pos = j;
				}
			}

			// Swap the elements from Minimum position we found till now to the i index
			int temp;

			for (int j = pos; j > i; --j) {
				temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}

			// Set the final value after swapping pos-i elements
			k -= pos - i;
		}

		return arr;
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
		int k_1 = 2;
		int[] arr_1 = { 5, 3, 1 };
		int[] expected_1 = { 1, 5, 3 };
		int[] output_1 = findMinArray(arr_1, k_1);
		check(expected_1, output_1);

		int k_2 = 3;
		int[] arr_2 = { 8, 9, 11, 2, 1 };
		int[] expected_2 = { 2, 8, 9, 11, 1 };
		int[] output_2 = findMinArray(arr_2, k_2);
		check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		run();
	}
}