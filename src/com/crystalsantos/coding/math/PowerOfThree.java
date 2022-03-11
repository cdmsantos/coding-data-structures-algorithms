package com.crystalsantos.coding.math;

/**
 * 
 * Power of Three
 * 
 * Given an integer n, return true if it is a power of three. Otherwise, return
 * false.
 * 
 * An integer n is a power of three, if there exists an integer x such that n ==
 * 3x.
 * 
 * Example 1:
 * 
 * Input: n = 27 Output: true Example 2:
 * 
 * Input: n = 0 Output: false Example 3:
 * 
 * Input: n = 9 Output: true
 * 
 * 
 * Constraints:
 * 
 * -231 <= n <= 231 - 1
 * 
 * 
 * Follow up: Could you solve it without loops/recursion?
 */
public class PowerOfThree {
	public boolean isPowerOfThree(int n) {
		if (n > 0) {
			while (n > 1) {
				if (n % 3 == 0) {
					n = n / 3;
				} else {
					return false;
				}
			}
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		PowerOfThree power = new PowerOfThree();
		System.out.println(power.isPowerOfThree(27)); // true
		System.out.println(power.isPowerOfThree(0)); // false
		System.out.println(power.isPowerOfThree(9)); // true
		System.out.println(power.isPowerOfThree(34)); // false
	}
}
