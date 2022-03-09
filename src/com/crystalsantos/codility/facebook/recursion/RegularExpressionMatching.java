package com.crystalsantos.codility.facebook.recursion;

/**
 * 
 * Regular Expression Matching
 * 
 * 
 * 
 * Given an input string s and a pattern p, implement regular expression
 * matching with support for '.' and '*' where:
 * 
 * '.' Matches any single character.​​​​ '*' Matches zero or more of the
 * preceding element. The matching should cover the entire input string (not
 * partial).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aa", p = "a" Output: false Explanation: "a" does not match the
 * entire string "aa". Example 2:
 * 
 * Input: s = "aa", p = "a*" Output: true Explanation: '*' means zero or more of
 * the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes
 * "aa". Example 3:
 * 
 * Input: s = "ab", p = ".*" Output: true Explanation: ".*" means "zero or more
 * (*) of any character (.)".
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 20 1 <= p.length <= 30 s contains only lowercase English
 * letters. p contains only lowercase English letters, '.', and '*'. It is
 * guaranteed for each appearance of the character '*', there will be a previous
 * valid character to match.
 * 
 * @author crystalsantos
 *
 */
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		// base case
		if (p.length() == 0) {
			return s.length() == 0;
		}

		// special case
		if (p.length() == 1) {

			// if the length of s is 0, return false
			if (s.length() < 1) {
				return false;
			}

			// if the first does not match, return false
			else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
				return false;
			}

			// otherwise, compare the rest of the string of s and p.
			else {
				return isMatch(s.substring(1), p.substring(1));
			}
		}

		// case 1: when the second char of p is not '*'
		if (p.charAt(1) != '*') {
			if (s.length() < 1) {
				return false;
			}
			if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
				return false;
			} else {
				return isMatch(s.substring(1), p.substring(1));
			}
		}

		// case 2: when the second char of p is '*', complex case.
		else {
			// case 2.1: a char & '*' can stand for 0 element
			if (isMatch(s, p.substring(2))) {
				return true;
			}

			// case 2.2: a char & '*' can stand for 1 or more preceding element,
			// so try every sub string
			int i = 0;
			while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
				if (isMatch(s.substring(i + 1), p.substring(2))) {
					return true;
				}
				i++;
			}
			return false;
		}
	}

}
