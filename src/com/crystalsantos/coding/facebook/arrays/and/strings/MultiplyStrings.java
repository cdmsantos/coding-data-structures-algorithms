package com.crystalsantos.coding.facebook.arrays.and.strings;

/***
 * Multiply Strings
 * 
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2, also represented as a string.
 * 
 * Note: You must not use any built-in BigInteger library or convert the inputs
 * to integer directly.
 * 
 * Example 1:
 * 
 * Input: num1 = "2", num2 = "3" Output: "6" Example 2:
 * 
 * Input: num1 = "123", num2 = "456" Output: "56088"
 * 
 * 
 * Constraints:
 * 
 * 1 <= num1.length, num2.length <= 200 num1 and num2 consist of digits only.
 * Both num1 and num2 do not contain any leading zero, except the number 0
 * itself.
 *
 */
public class MultiplyStrings {

	public String multiply(String num1, String num2) {
		String n1 = new StringBuilder(num1).reverse().toString();
		String n2 = new StringBuilder(num2).reverse().toString();

		int[] d = new int[num1.length() + num2.length()];

		// multiply each digit and sum at the corresponding positions
		for (int i = 0; i < n1.length(); i++) {
			for (int j = 0; j < n2.length(); j++) {
				// charAt returns ascii.
				// so '1' would return 49 when converted to int.
				// n1.charAt(i)-'0' essential converts the integer to its ascii and substracts
				// the ascii of '0' i.e. 48 to get that number.
				// Ex: 5 to asii is 53
				// 0 to ascii is 48
				// 53 - 48 would return 5.
				d[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
			}
		}

		StringBuilder sb = new StringBuilder();

		// calculate each digit
		for (int i = 0; i < d.length; i++) {
			int mod = d[i] % 10;
			int carry = d[i] / 10;
			if (i + 1 < d.length) {
				d[i + 1] += carry;
			}
			sb.insert(0, mod);
		}

		// remove front 0's
		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		MultiplyStrings multiply = new MultiplyStrings();
		System.out.println(multiply.multiply("2", "3"));
		System.out.println(multiply.multiply("123", "456"));
		System.out.println(multiply.multiply("123456789", "987654321"));
	}
}
