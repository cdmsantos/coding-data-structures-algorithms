package com.crystalsantos.coding.random;

import java.io.IOException;

public class MinimumLengthSubstring {

	int minLengthSubstring(String s, String t) {
		if(t.length() > s.length()) {
			return -1;
		}
		
		char[] sChar = s.toCharArray();
		char[] tChar = t.toCharArray();
		
		int contains = 0;
		int finalIndex = 0;
		for(int i = 0; i < sChar.length; i++) {
			if(t.indexOf(sChar[i]) >= 0) {
				tChar[t.indexOf(sChar[i])] = 0;
				t = String.valueOf(tChar);
				contains++;
			}
			
			if(contains == tChar.length) {
				finalIndex = i;
				break;
			}
		}
		
		if(contains != tChar.length) {
			return -1;
		} 
			
		return finalIndex + 1;
	}

	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom, but they are otherwise not editable!
	int test_case_number = 1;

	void check(int expected, int output) {
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

	void printInteger(int n) {
		System.out.print("[" + n + "]");
	}

	public void run() throws IOException {
		String s_1 = "dcbefebce";
		String t_1 = "fd";
		int expected_1 = 5;
		int output_1 = minLengthSubstring(s_1, t_1);
		check(expected_1, output_1);

		String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
		String t_2 = "cbccfafebccdccebdd";
		int expected_2 = -1;
		int output_2 = minLengthSubstring(s_2, t_2);
		check(expected_2, output_2);
	}

	public static void main(String[] args) throws IOException {
		new MinimumLengthSubstring().run();
	}
}