package com.crystalsantos.coding.random;

public class AreTheyEqual {

	boolean areTheyEqual(int[] array_a, int[] array_b) {
		if(array_a.length != array_b.length) {
			return false;
		} else {
			for(int i = 0; i < array_a.length; i++) {
				for(int j = 0; j < array_a.length; j++) {
					if(array_b[j] == array_a[i]) {
						array_b[j] = -1;
						break;
					}
				}
			}
			
			for(int j = 0; j < array_a.length; j++) {
				if(array_b[j] != -1) {
					return false;
				}
			}
			return true;
		}
	}

	int test_case_number = 1;

	void check(boolean expected, boolean output) {
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

	public void run() {
		int[] array_a_1 = { 1, 2, 3, 4 };
		int[] array_b_1 = { 1, 4, 3, 2 };
		boolean expected_1 = true;
		boolean output_1 = areTheyEqual(array_a_1, array_b_1);
		check(expected_1, output_1);

		int[] array_a_2 = { 1, 2, 3, 4 };
		int[] array_b_2 = { 1, 4, 3, 3 };
		boolean expected_2 = false;
		boolean output_2 = areTheyEqual(array_a_2, array_b_2);
		check(expected_2, output_2);
	}

	public static void main(String[] args) {
		new AreTheyEqual().run();
	}
}