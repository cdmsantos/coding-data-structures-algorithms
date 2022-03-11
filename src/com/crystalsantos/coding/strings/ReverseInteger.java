package com.crystalsantos.coding.strings;

import java.util.InputMismatchException;

/**
 * Reverse Integer
 * 
 * Given a signed 32-bit integer x, return x with its digits reversed. If
 * reversing x causes the value to go outside the signed 32-bit integer range
 * [-231, 231 - 1], then return 0.
 * 
 * Assume the environment does not allow you to store 64-bit integers (signed or
 * unsigned).
 * 
 * Example 1:
 * 
 * Input: x = 123 Output: 321 Example 2:
 * 
 * Input: x = -123 Output: -321 Example 3:
 * 
 * Input: x = 120 Output: 21
 * 
 * 
 * Constraints:
 * 
 * -231 <= x <= 231 - 1
 * 
 */
public class ReverseInteger {
	public int reverse(int num) {
		long reverseNum = 0;
		boolean negative = false;

		if (num < 0) {
			negative = true;
			num = 0 - num;
		}

		while (num > 0) {
			reverseNum = reverseNum * 10 + num % 10;
			num = num / 10;
		}

		if (negative) {
			reverseNum = 0 - reverseNum;
		}

		if (reverseNum > Integer.MAX_VALUE || reverseNum < Integer.MIN_VALUE) {
			return 0;
		}

		return (int) reverseNum;
	}

	public static void main(String[] args) {
		ReverseInteger reverseInteger = new ReverseInteger();
		System.out.println(reverseInteger.reverse(123)); // 321
		System.out.println(reverseInteger.reverse(-123)); // -321
		System.out.println(reverseInteger.reverse(120));// 21
		System.out.println(reverseInteger.reverse(1534236469));// 0
		System.out.println(reverseInteger.reverse(-1563847412));// 0
	}
}
