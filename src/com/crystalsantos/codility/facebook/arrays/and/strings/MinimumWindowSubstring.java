package com.crystalsantos.codility.facebook.arrays.and.strings;

import java.util.HashMap;
import java.util.Map;

/***
 * 
 * Minimum Window Substring
 * 
 * Given two strings s and t of lengths m and n respectively, return the minimum
 * window substring of s such that every character in t (including duplicates)
 * is included in the window. If there is no such substring, return the empty
 * string "".
 * 
 * The testcases will be generated such that the answer is unique.
 * 
 * A substring is a contiguous sequence of characters within the string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "ADOBECODEBANC", t = "ABC" Output: "BANC" Explanation: The minimum
 * window substring "BANC" includes 'A', 'B', and 'C' from string t. Example 2:
 * 
 * Input: s = "a", t = "a" Output: "a" Explanation: The entire string s is the
 * minimum window. Example 3:
 * 
 * Input: s = "a", t = "aa" Output: "" Explanation: Both 'a's from t must be
 * included in the window. Since the largest window of s only has one 'a',
 * return empty string.
 * 
 * 
 * Constraints:
 * 
 * m == s.length n == t.length 1 <= m, n <= 105 s and t consist of uppercase and
 * lowercase English letters.
 * 
 * 
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 *
 */
public class MinimumWindowSubstring {

	public String minWindow(String s, String t) {

		if (s != null && !s.isEmpty() && t != null && !t.isEmpty() && s.length() >= t.length()) {
			int n = s.length();

			// length of the minimum window substring (smallest substring of s that has all
			// characters of t)
			int minWindowSubstrLength = Integer.MAX_VALUE;

			// start index of the minimum window substring
			int minWindowSubstrStart = 0;

			// stores the count of each character in the current window
			Map<Character, Integer> windowMap = new HashMap<>();

			// stores the count of each character in the string t
			Map<Character, Integer> tCharacter = new HashMap<>();
			for (int i = 0; i < t.length(); i++) {
				char c = t.charAt(i);
				tCharacter.put(c, tCharacter.getOrDefault(c, 0) + 1);
			}

			int windowStart = 0;
			for (int windowEnd = 0; windowEnd < n; windowEnd++) {
				// Add the next character of the string to the window
				char c = s.charAt(windowEnd);
				windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

				// Keep looking for a smaller window while the current window substring contains
				// all the characters of t
				while (containsAll(windowMap, tCharacter)) {
					if (windowEnd - windowStart + 1 < minWindowSubstrLength) {
						minWindowSubstrLength = windowEnd - windowStart + 1;
						minWindowSubstrStart = windowStart;
					}

					// move the leftmost character out of the window
					char leftChar = s.charAt(windowStart);
					windowMap.put(leftChar, windowMap.get(leftChar) - 1);
					if (windowMap.get(leftChar) == 0) {
						windowMap.remove(leftChar);
					}
					windowStart++; // shrink the window
				}
			}

			if (minWindowSubstrLength == Integer.MAX_VALUE) {
				return "";
			} else {
				return s.substring(minWindowSubstrStart, minWindowSubstrStart + minWindowSubstrLength);
			}
		} else {
			return "";
		}
	}

	private boolean containsAll(Map<Character, Integer> windowCharMap, Map<Character, Integer> substrMap) {
		for (Map.Entry<Character, Integer> entry : substrMap.entrySet()) {
			char c = entry.getKey();
			int count = entry.getValue();

			if (!windowCharMap.containsKey(c)) {
				return false;
			}

			if (windowCharMap.get(c) < count) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		MinimumWindowSubstring minimum = new MinimumWindowSubstring();
		System.out.println("Minimum = " + minimum.minWindow("ADOBECODEBANC", "ABC"));
		System.out.println("Minimum = " + minimum.minWindow("a", "a"));
		System.out.println("Minimum = " + minimum.minWindow("a", "aa"));
		System.out.println("Minimum = " + minimum.minWindow("a", "b"));
	}
}
