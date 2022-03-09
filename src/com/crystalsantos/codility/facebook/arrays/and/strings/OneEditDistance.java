package com.crystalsantos.codility.facebook.arrays.and.strings;

/***
 * 
 * One Edit Distance
 * 
 * 
 * Given two strings s and t, return true if they are both one edit distance
 * apart, otherwise return false.
 * 
 * A string s is said to be one distance apart from a string t if you can:
 * 
 * Insert exactly one character into s to get t. Delete exactly one character
 * from s to get t. Replace exactly one character of s with a different
 * character to get t.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "ab", t = "acb" Output: true Explanation: We can insert 'c' into s
 * to get t. Example 2:
 * 
 * Input: s = "", t = "" Output: false Explanation: We cannot get t from s by
 * only one step.
 * 
 * 
 * Constraints:
 * 
 * 0 <= s.length, t.length <= 104 s and t consist of lowercase letters,
 * uppercase letters, and digits.
 * 
 *
 */
public class OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
		boolean oneEditDistance = false;

		if (Math.abs(s.length() - t.length()) > 1) {
			return oneEditDistance;
		} else if (s.equals(t)) {
			return oneEditDistance;
		}

		int changes = 0;
		int i = 0, j = 0;
		while (i < t.length() && j < s.length()) {
			if (t.charAt(i) == s.charAt(j)) {
				i++;
				j++;
			} else {
				changes++;
				if (s.length() > t.length()) {
					j++;
				} else if (t.length() > s.length()) {
					i++;
				} else {
					j++;
					i++;
				}
			}
		}

		if (changes == 1 || (changes == 0 && j == s.length() - 1) || (changes == 0 && i == t.length() - 1)) {
			oneEditDistance = true;
		}

		return oneEditDistance;
	}

	public static void main(String[] args) {
		OneEditDistance distance = new OneEditDistance();
		System.out.println(distance.isOneEditDistance("ab", "acb")); // true insert
		System.out.println(distance.isOneEditDistance("", "")); // false
		System.out.println(distance.isOneEditDistance("abbbb", "abc")); // false
		System.out.println(distance.isOneEditDistance("abcb", "abc")); // true removal
		System.out.println(distance.isOneEditDistance("abd", "abc")); // true replace
		System.out.println(distance.isOneEditDistance("abcc", "accc")); // true
		System.out.println(distance.isOneEditDistance("c", "c")); // false
		System.out.println(distance.isOneEditDistance("ab", "ba")); // false
		System.out.println(distance.isOneEditDistance("", "A")); // true
	}
}
