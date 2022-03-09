package com.crystalsantos.coding.facebook.arrays.and.strings;

import java.util.HashSet;
import java.util.Set;

/***
 * Longest Substring Without Repeating Characters:
 * 
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * 
 * Example 1: Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc",
 * with the length of 3.
 * 
 * Example 2: Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with
 * the length of 1.
 * 
 * Example 3: Input: s = "pwwkew" Output: 3 Explanation: The answer is "wke",
 * with the length of 3. Notice that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * Constraints: 0 <= s.length <= 5 * 104 s consists of English letters, digits,
 * symbols and spaces.
 ***/

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstringSet(String s) {
		int longest = 0;
		if (s != null && !s.isEmpty()) {
			int start = 0, end = 0;
			Set<Character> uniques = new HashSet<>();

			while (end < s.length()) {
				if (uniques.add(s.charAt(end))) {
					end++;
					longest = Math.max(longest, uniques.size());
				} else {
					uniques.remove(s.charAt(start));
					start++;
				}
			}
		}
		return longest;
	}

	public int lengthOfLongestSubstring(String s) {
		int longest = 0;

		for (int i = 0; i < s.length(); i++) {

			boolean[] visited = new boolean[256];

			for (int j = i; j < s.length(); j++) {

				if (visited[s.charAt(j)] == true) {
					break;
				} else {
					longest = Math.max(longest, j - i + 1);
					visited[s.charAt(j)] = true;
				}
			}

			visited[s.charAt(i)] = false;
		}
		return longest;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters substring = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(substring.lengthOfLongestSubstring("abcabcbb")); //3
		System.out.println(substring.lengthOfLongestSubstring("bbbbb")); //1
		System.out.println(substring.lengthOfLongestSubstring("pwwkew")); //3
	}
}
