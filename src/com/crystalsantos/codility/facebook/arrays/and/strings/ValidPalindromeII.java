package com.crystalsantos.codility.facebook.arrays.and.strings;

/***
 * 
 * Valid Palindrome II
 * 
 * Given a string s, return true if the s can be palindrome after deleting at
 * most one character from it.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aba" Output: true Example 2:
 * 
 * Input: s = "abca" Output: true Explanation: You could delete the character
 * 'c'. Example 3:
 * 
 * Input: s = "abc" Output: false
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105 s consists of lowercase English letters.
 * 
 * 
 * 
 *
 */
public class ValidPalindromeII {
	public boolean validPalindrome(String s) {
		int start = 0, end = s.length() - 1;
		while (start < end - 1) {
			if (s.charAt(start) != s.charAt(end)) {
				if (valid(s, start, end - 1)) {
					return true;
				}
				if (valid(s, start + 1, end)) {
					return true;
				}
				return false;
			} else {
				start++;
				end--;
			}
		}
		return true;
	}

	private boolean valid(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		ValidPalindromeII palindrome = new ValidPalindromeII();
		System.out.println(palindrome.validPalindrome("aba")); // true
		System.out.println(palindrome.validPalindrome("abca")); // true deleting c
		System.out.println(palindrome.validPalindrome("abc")); // false
		System.out.println(palindrome.validPalindrome("bddb")); // true
	}
}
