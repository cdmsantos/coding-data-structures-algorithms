package com.crystalsantos.codility.facebook.others;

import java.util.HashMap;
import java.util.Map;

/***
 * 
 * Permutation in String
 * 
 * 
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1,
 * or false otherwise.
 * 
 * In other words, return true if one of s1's permutations is the substring of
 * s2.
 * 
 * Example 1:
 * 
 * Input: s1 = "ab", s2 = "eidbaooo" Output: true Explanation: s2 contains one
 * permutation of s1 ("ba"). Example 2:
 * 
 * Input: s1 = "ab", s2 = "eidboaoo" Output: false
 * 
 * 
 * Constraints:
 * 
 * 1 <= s1.length, s2.length <= 104 s1 and s2 consist of lowercase English
 * letters.
 * 
 */
public class PermutationInString {
	public boolean checkInclusion(String s1, String s2) {
		if (s2.length() < s1.length()) {
			return false;
		}

		Map<Character, Integer> sOneMap = new HashMap<>();
		for (char ch : s1.toCharArray()) {
			if (sOneMap.containsKey(ch)) {
				sOneMap.put(ch, sOneMap.get(ch) + 1);
			} else {
				sOneMap.put(ch, 1);
			}
		}

		Map<Character, Integer> sTwoMap = new HashMap<>();
		for (int i = 0; i < s2.length(); i++) {
			char ch = s2.charAt(i);

			if (sTwoMap.containsKey(ch)) {
				sTwoMap.put(ch, sTwoMap.get(ch) + 1);
			} else {
				sTwoMap.put(ch, 1);
			}
			// remove one letter
			// from the left side of the window
			// because size is greater than p
			if (i >= s1.length()) {
				ch = s2.charAt(i - s1.length());
				if (sTwoMap.get(ch) == 1) {
					sTwoMap.remove(ch);
				} else {
					sTwoMap.put(ch, sTwoMap.get(ch) - 1);
				}
			}

			// compare hashmap in the sliding window
			// with the reference hashmap
			if (sOneMap.equals(sTwoMap)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		PermutationInString permutation = new PermutationInString();
		System.out.println(permutation.checkInclusion("ab", "eidbaooo"));
		System.out.println(permutation.checkInclusion("ab", "eidboaoo"));
	}
}
