package com.crystalsantos.coding.facebook.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Editors choice!
 * 
 * 
 * Letter Combinations of a Phone Number
 * 
 * 
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent. Return the answer in any
 * order.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * Example 1:
 * 
 * Input: digits = "23" Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 * 
 * Input: digits = "" Output: [] Example 3:
 * 
 * Input: digits = "2" Output: ["a","b","c"]
 * 
 * 
 * Constraints:
 * 
 * 0 <= digits.length <= 4 digits[i] is a digit in the range ['2', '9'].
 * 
 */
public class LetterCombinationsOfAPhoneNumber {
	public List<String> letterCombinations(String digits) {
		if (digits != null && !digits.isEmpty()) {
			List<String> result = new ArrayList<String>();
			String[] table = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
			helper(digits, 0, table, result, digits.toCharArray());
//			return letterCombinationsUtil(digits.toCharArray(), digits.length(), table);
			return result;
		}
		return new ArrayList<>();
	}

	// recursion
	private void helper(String digits, int index, String[] table, List<String> result, char[] letters) {
		if (index == digits.length()) {
			result.add(new String(letters));
			return;
		}

		char number = digits.charAt(index);
		char[] candidates = table[Character.getNumericValue(number)].toCharArray();
		for (int i = 0; i < candidates.length; i++) {
			letters[index] = candidates[i];
			helper(digits, index + 1, table, result, letters);
		}
	}

	// option with queue
	private ArrayList<String> letterCombinationsUtil(char[] number, int n, String[] table) {
		ArrayList<String> list = new ArrayList<>();

		Queue<String> q = new LinkedList<>();
		q.add("");

		while (!q.isEmpty()) {
			String s = q.remove();

			if (s.length() == n) {
				list.add(s);
			} else {
				String val = table[Character.getNumericValue(number[s.length()])];
				for (int i = 0; i < val.length(); i++) {
					q.add(s + val.charAt(i));
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber letters = new LetterCombinationsOfAPhoneNumber();
		letters.run();
	}

	private void run() {
		printResult(letterCombinations("23"));
		printResult(letterCombinations(""));
		printResult(letterCombinations("2"));
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
