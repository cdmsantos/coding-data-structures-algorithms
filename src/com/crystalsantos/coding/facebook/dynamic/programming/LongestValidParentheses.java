package com.crystalsantos.coding.facebook.dynamic.programming;

/***
 * 
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "(()" Output: 2 Explanation: The longest valid parentheses
 * substring is "()". Example 2:
 * 
 * Input: s = ")()())" Output: 4 Explanation: The longest valid parentheses
 * substring is "()()". Example 3:
 * 
 * Input: s = "" Output: 0
 * 
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 3 * 104 s[i] is '(', or ')'.
 * 
 */
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		int left = 0, right = 0, maxlength = 0;

		// de frente para trás
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				maxlength = Math.max(maxlength, 2 * right);
			} else if (right >= left) {
				left = right = 0;
			}
		}
		left = right = 0;

		// de trás para frente
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				maxlength = Math.max(maxlength, 2 * left);
			} else if (left >= right) {
				left = right = 0;
			}
		}
		return maxlength;
	}

	public static void main(String[] args) {
		LongestValidParentheses parentheses = new LongestValidParentheses();
//		System.out.println(parentheses.longestValidParentheses("(()")); // 2
//		System.out.println(parentheses.longestValidParentheses(")()())")); // 4
//		System.out.println(parentheses.longestValidParentheses(""));// 0
//		System.out.println(parentheses.longestValidParentheses("("));// 0
//		System.out.println(parentheses.longestValidParentheses(")("));// 0
		System.out.println(parentheses.longestValidParentheses("()(())"));// 6
	}
}
