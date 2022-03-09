package com.crystalsantos.coding.facebook.sorting.and.searching;

/***
 * Divide Two Integers
 * 
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division, and mod operator.
 * 
 * The integer division should truncate toward zero, which means losing its
 * fractional part. For example, 8.345 would be truncated to 8, and -2.7335
 * would be truncated to -2.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * Note: Assume we are dealing with an environment that could only store
 * integers within the 32-bit signed integer range: [−231, 231 − 1]. For this
 * problem, if the quotient is strictly greater than 231 - 1, then return 231 -
 * 1, and if the quotient is strictly less than -231, then return -231.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: dividend = 10, divisor = 3 Output: 3 Explanation: 10/3 = 3.33333..
 * which is truncated to 3. Example 2:
 * 
 * Input: dividend = 7, divisor = -3 Output: -2 Explanation: 7/-3 = -2.33333..
 * which is truncated to -2.
 * 
 * 
 * Constraints:
 * 
 * -231 <= dividend, divisor <= 231 - 1 divisor != 0
 *
 */
public class DivideTwoIntegers {
	private static int HALF_INT_MIN = -1073741824;

	public int divide(int dividend, int divisor) {

		// Special case: overflow.
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}

		/*
		 * We need to convert both numbers to negatives. Also, we count the number of
		 * negatives signs.
		 */
		int negatives = 2;
		if (dividend > 0) {
			negatives--;
			dividend = -dividend;
		}
		if (divisor > 0) {
			negatives--;
			divisor = -divisor;
		}

		/*
		 * In the first loop, we simply find the largest double of divisor that fits
		 * into the dividend. The >= is because we're working in negatives. In essence,
		 * that piece of code is checking that we're still nearer to 0 than we are to
		 * INT_MIN.
		 */
		int highestDouble = divisor;
		int highestPowerOfTwo = -1;
		while (highestDouble >= HALF_INT_MIN && dividend <= highestDouble + highestDouble) {
			highestPowerOfTwo += highestPowerOfTwo;
			highestDouble += highestDouble;
		}

		/*
		 * In the second loop, we work out which powers of two fit in, by halving
		 * highestDouble and highestPowerOfTwo repeatedly. We can do this using bit
		 * shifting so that we don't break the rules of the question :-)
		 */
		int quotient = 0;
		while (dividend <= divisor) {
			if (dividend <= highestDouble) {
				quotient += highestPowerOfTwo;
				dividend -= highestDouble;
			}
			/*
			 * We know that these are always even, so no need to worry about the annoying
			 * "bit-shift-odd-negative-number" case.
			 */
			highestPowerOfTwo >>= 1;
			highestDouble >>= 1;
		}

		/*
		 * If there was originally one negative sign, then the quotient remains
		 * negative. Otherwise, switch it to positive.
		 */
		if (negatives != 1) {
			return -quotient;
		}
		return quotient;
	}

	public static void main(String[] args) {
		DivideTwoIntegers twoIntegers = new DivideTwoIntegers();
		System.out.println(twoIntegers.divide(10, 3)); // 3
		System.out.println(twoIntegers.divide(7, -3)); // -2

	}
}
