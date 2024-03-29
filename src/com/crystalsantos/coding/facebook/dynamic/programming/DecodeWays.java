package com.crystalsantos.coding.facebook.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

/***
 * 
 * Decode Ways
 * 
 * 
 * A message containing letters from A-Z can be encoded into numbers using the
 * following mapping:
 * 
 * 'A' -> "1" 'B' -> "2" ... 'Z' -> "26" To decode an encoded message, all the
 * digits must be grouped then mapped back into letters using the reverse of the
 * mapping above (there may be multiple ways). For example, "11106" can be
 * mapped into:
 * 
 * "AAJF" with the grouping (1 1 10 6) "KJF" with the grouping (11 10 6) Note
 * that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F'
 * since "6" is different from "06".
 * 
 * Given a string s containing only digits, return the number of ways to decode
 * it.
 * 
 * The test cases are generated so that the answer fits in a 32-bit integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "12" Output: 2 Explanation: "12" could be decoded as "AB" (1 2) or
 * "L" (12). Example 2:
 * 
 * Input: s = "226" Output: 3 Explanation: "226" could be decoded as "BZ" (2
 * 26), "VF" (22 6), or "BBF" (2 2 6). Example 3:
 * 
 * Input: s = "06" Output: 0 Explanation: "06" cannot be mapped to "F" because
 * of the leading zero ("6" is different from "06").
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 100 s contains only digits and may contain leading zero(s).
 */
public class DecodeWays {

	Map<Integer, Integer> memo = new HashMap<>();

	public int numDecodings(String s) {
		if (s != null && !s.isEmpty()) {
			memo = new HashMap<>();
			return recursiveWithMemo(0, s);
		} else {
			return 0;
		}
	}

	private int recursiveWithMemo(int index, String str) {
		// Have we already seen this substring?
		if (memo.containsKey(index)) {
			return memo.get(index);
		}

		// If you reach the end of the string
		// Return 1 for success.
		if (index == str.length()) {
			return 1;
		}

		// If the string starts with a zero, it can't be decoded
		if (str.charAt(index) == '0') {
			return 0;
		}

		if (index == str.length() - 1) {
			return 1;
		}

		int ans = recursiveWithMemo(index + 1, str); //single digit
		if (Integer.parseInt(str.substring(index, index + 2)) <= 26) { //double digit
			ans += recursiveWithMemo(index + 2, str);
		}

		// Save for memoization
		memo.put(index, ans);

		return ans;
	}

	public static void main(String[] args) {
		DecodeWays decode = new DecodeWays();
		System.out.println(decode.numDecodings("12")); // 2
		System.out.println(decode.numDecodings("226")); // 3
		System.out.println(decode.numDecodings("06")); // 0
	}
}
