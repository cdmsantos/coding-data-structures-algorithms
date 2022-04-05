package com.crystalsantos.coding.amazon.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Generate Parentheses
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * Example 1:
 * 
 * Input: n = 3 Output: ["((()))","(()())","(())()","()(())","()()()"] Example
 * 2:
 * 
 * Input: n = 1 Output: ["()"]
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 8
 * 
 * 
 * 
 * @author crystalsantos
 *
 */
public class GenerateParentheses {
	List<String> result;

	public List<String> generateParenthesis(int n) {

		if (n == 0) {
			return null;
		}

		if (n == 1) {
			return Arrays.asList("()");
		}

		result = new ArrayList<>();
		generateParenthesis(0, 0, n, new StringBuilder());
		return result;
	}

	private void generateParenthesis(int left, int right, int n, StringBuilder sb) {
		if (left == n && right == n) {
			result.add(new String(sb.toString()));
			return;
		}

		if (left < n) {
			sb.append("(");
			generateParenthesis(left + 1, right, n, sb);
			sb.deleteCharAt(sb.length() - 1);
		}

		if (left > right) {
			sb.append(")");
			generateParenthesis(left, right + 1, n, sb);
			sb.deleteCharAt(sb.length() - 1);
		}

	}
}
