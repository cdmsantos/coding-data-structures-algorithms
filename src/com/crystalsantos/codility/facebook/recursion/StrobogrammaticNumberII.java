package com.crystalsantos.codility.facebook.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 
 * Strobogrammatic Number II
 * 
 * 
 * Given an integer n, return all the strobogrammatic numbers that are of length
 * n. You may return the answer in any order.
 * 
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 2 Output: ["11","69","88","96"] Example 2:
 * 
 * Input: n = 1 Output: ["0","1","8"]
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 14
 * 
 */
public class StrobogrammaticNumberII {
	public char[][] reversiblePairs = { { '0', '0' }, { '1', '1' }, { '6', '9' }, { '8', '8' }, { '9', '6' } };

	public List<String> generateStroboNumbers(int n, int finalLength) {
		if (n == 0) {
			// 0-digit strobogrammatic number is an empty string.
			return new ArrayList<>(Arrays.asList(""));
		}

		if (n == 1) {
			// 1-digit strobogrammatic numbers.
			return new ArrayList<>(Arrays.asList("0", "1", "8"));
		}

		List<String> prevStroboNums = generateStroboNumbers(n - 2, finalLength);
		List<String> currStroboNums = new ArrayList<>();

		for (String prevStroboNum : prevStroboNums) {
			for (char[] pair : reversiblePairs) {
				// We can only append 0's if it is not first digit.
				if (pair[0] != '0' || n != finalLength) {
					currStroboNums.add(pair[0] + prevStroboNum + pair[1]);
				}
			}
		}

		return currStroboNums;
	}

	public List<String> findStrobogrammatic(int n) {
		return generateStroboNumbers(n, n);
	}

	public static void main(String[] args) {
		StrobogrammaticNumberII strobogrammatic = new StrobogrammaticNumberII();
		strobogrammatic.run();
	}

	private void run() {
		printResult(findStrobogrammatic(1));
		printResult(findStrobogrammatic(2));
		printResult(findStrobogrammatic(3));
		printResult(findStrobogrammatic(4));
	}

	private void printResult(List<String> result) {
		System.out.print("[");

		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
			if (i != result.size() - 1) {
				System.out.print(" , ");
			}
		}

		System.out.print("]");
		System.out.println();
	}
}
