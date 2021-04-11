package com.crystalsantos.coding.recursion;

import java.util.HashSet;
import java.util.Set;

public class ChangeInAForeignCurrency {
	
	static Set<Integer> modulos = new HashSet<Integer>();

	static boolean canGetExactChange(int targetMoney, int[] denominations) {
		boolean exactChange = false;
		for(int i = 0; i < denominations.length; i++) {
			int modulo = targetMoney%denominations[i];
			
			if(modulo == 0) {
				exactChange = true;
				break;
			} else {
				if(!modulos.contains(modulo)) {
					modulos.add(modulo);
					exactChange = canGetExactChange(modulo, denominations);
				}
			}
		}
		return exactChange;
	}

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
		System.out.print("[\"" + str + "\"]");
	}

	static public void run() {
		int target_1 = 94;
		int arr_1[] = { 5, 10, 25, 100, 200 };
		boolean expected_1 = false;
		boolean output_1 = canGetExactChange(target_1, arr_1);
		check(expected_1, output_1);

		int target_2 = 75;
		int arr_2[] = { 4, 17, 29 };
		boolean expected_2 = true;
		boolean output_2 = canGetExactChange(target_2, arr_2);
		check(expected_2, output_2);
	}

	public static void main(String[] args) {
		run();
	}
}