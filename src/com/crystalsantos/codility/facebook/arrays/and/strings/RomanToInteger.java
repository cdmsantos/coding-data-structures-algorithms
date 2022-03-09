package com.crystalsantos.codility.facebook.arrays.and.strings;

/***
 * Roman to Integer
 * 
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1000 For example, 2 is written
 * as II in Roman numeral, just two one's added together. 12 is written as XII,
 * which is simply X + II. The number 27 is written as XXVII, which is XX + V +
 * II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There
 * are six instances where subtraction is used:
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed
 * before L (50) and C (100) to make 40 and 90. C can be placed before D (500)
 * and M (1000) to make 400 and 900. Given a roman numeral, convert it to an
 * integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "III" Output: 3 Explanation: III = 3. Example 2:
 * 
 * Input: s = "LVIII" Output: 58 Explanation: L = 50, V= 5, III = 3. Example 3:
 * 
 * Input: s = "MCMXCIV" Output: 1994 Explanation: M = 1000, CM = 900, XC = 90
 * and IV = 4.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 15 s contains only the characters ('I', 'V', 'X', 'L', 'C',
 * 'D', 'M'). It is guaranteed that s is a valid roman numeral in the range [1,
 * 3999].
 * 
 *
 */
public class RomanToInteger {

	public int romanToInt(String s) {
		int roman = 0;

		if (s != null && !s.isEmpty()) {

			for (int i = 0; i < s.length(); i++) {
				char current = s.charAt(i);

				if (current == 'I') {
					int sum = checkNextPosition(roman, i, 'V', 4, 'X', 9, s);
					
					if(sum > 0) {
						roman += sum;
						i++;
					} else {
						roman += 1;
					}
				} else if (current == 'X') {
					int sum = checkNextPosition(roman, i, 'L', 40, 'C', 90, s);

					if (sum > 0) {
						roman += sum;
						i++;
					} else {
						roman += 10;
					}
				} else if (current == 'C') {
					int sum = checkNextPosition(roman, i, 'D', 400, 'M', 900, s);

					if (sum > 0) {
						roman += sum;
						i++;
					} else {
						roman += 100;
					}
				} else if (current == 'V') {
					roman += 5;
				} else if (current == 'L') {
					roman += 50;
				} else if (current == 'D') {
					roman += 500;
				} else if (current == 'M') {
					roman += 1000;
				}
			}
		}

		return roman;
	}

	private int checkNextPosition(int roman, int i, char firstLetter, int firstValue, char secondLetter,
			int secondValue, String s) {
		int nextPosition = i + 1;

		if ((nextPosition) < s.length() && s.charAt(nextPosition) == firstLetter) {
			return firstValue;
		} else if ((nextPosition) < s.length() && s.charAt(nextPosition) == secondLetter) {
			return secondValue;
		}

		return 0;
	}

	public static void main(String[] args) {
		RomanToInteger roman = new RomanToInteger();
		System.out.println(roman.romanToInt("III"));
		System.out.println(roman.romanToInt("LVIII"));
		System.out.println(roman.romanToInt("MCMXCIV"));
	}
}
