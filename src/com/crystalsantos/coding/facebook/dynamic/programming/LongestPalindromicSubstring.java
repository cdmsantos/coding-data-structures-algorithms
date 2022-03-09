package com.crystalsantos.coding.facebook.dynamic.programming;

/**
 * 
 * Longest Palindromic Substring
 * 
 * 
 * Given a string s, return the longest palindromic substring in s.
 * 
 * Example 1:
 * 
 * Input: s = "babad" Output: "bab" Explanation: "aba" is also a valid answer.
 * Example 2:
 * 
 * Input: s = "cbbd" Output: "bb"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 1000 s consist of only digits and English letters.
 * 
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		StringBuilder palindrome = new StringBuilder();

		if (s != null && !s.isEmpty()) {
			// table[i][j] will be false if substring str[i..j] is not palindrome.
			// Else table[i][j] will be true
			boolean table[][] = new boolean[s.length()][s.length()];

			// All substrings of length 1 are palindromes
			int maxLength = 1;
			for (int i = 0; i < s.length(); ++i) {
				table[i][i] = true;
			}

			// check for sub-string of length 2.
			int start = 0;
			for (int i = 0; i < s.length() - 1; ++i) {
				if (s.charAt(i) == s.charAt(i + 1)) {
					table[i][i + 1] = true;
					start = i;
					maxLength = 2;
				}
			}

			// Check for lengths greater than 2.
			// k is length of substring
			for (int k = 3; k <= s.length(); ++k) {

				// Fix the starting index
				for (int i = 0; i < s.length() - k + 1; ++i) {
					// Get the ending index of substring from
					// starting index i and length k
					int j = i + k - 1;

					// checking for sub-string from ith index to
					// jth index iff str.charAt(i+1) to
					// str.charAt(j-1) is a palindrome
					if (table[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
						table[i][j] = true;

						if (k > maxLength) {
							start = i;
							maxLength = k;
						}
					}
				}
			}

			palindrome.append(s.substring(start, start + maxLength));
		}

		return palindrome.toString();
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring palindromic = new LongestPalindromicSubstring();

		System.out.println(palindromic.longestPalindrome("babad")); // bab
		System.out.println(palindromic.longestPalindrome("cbbd")); // bb
	}
}
