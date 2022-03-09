package com.crystalsantos.codility.facebook.arrays.and.strings;

/***
 * 
 * Editors choice!
 * Integer to English Words
 * 
 * 
 * Convert a non-negative integer num to its English words representation.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: num = 123 Output: "One Hundred Twenty Three" Example 2:
 * 
 * Input: num = 12345 Output: "Twelve Thousand Three Hundred Forty Five" Example
 * 3:
 * 
 * Input: num = 1234567 Output: "One Million Two Hundred Thirty Four Thousand
 * Five Hundred Sixty Seven"
 * 
 * 
 * Constraints:
 * 
 * 0 <= num <= 231 - 1
 * 
 *
 */
public class IntegerToEnglishWords {

	private String one(int num) {
		switch (num) {
		case 0:
			return "Zero";
		case 1:
			return "One";
		case 2:
			return "Two";
		case 3:
			return "Three";
		case 4:
			return "Four";
		case 5:
			return "Five";
		case 6:
			return "Six";
		case 7:
			return "Seven";
		case 8:
			return "Eight";
		case 9:
			return "Nine";
		}
		return "";
	}

	private String twoLessThan20(int num) {
		switch (num) {
		case 10:
			return "Ten";
		case 11:
			return "Eleven";
		case 12:
			return "Twelve";
		case 13:
			return "Thirteen";
		case 14:
			return "Fourteen";
		case 15:
			return "Fifteen";
		case 16:
			return "Sixteen";
		case 17:
			return "Seventeen";
		case 18:
			return "Eighteen";
		case 19:
			return "Nineteen";
		}
		return "";
	}

	private String ten(int num) {
		switch (num) {
		case 2:
			return "Twenty";
		case 3:
			return "Thirty";
		case 4:
			return "Forty";
		case 5:
			return "Fifty";
		case 6:
			return "Sixty";
		case 7:
			return "Seventy";
		case 8:
			return "Eighty";
		case 9:
			return "Ninety";
		}
		return "";
	}

	private String two(int num) {
		if (num == 0) {
			return "";
		} else if (num < 10) {
			return one(num);
		} else if (num < 20) {
			return twoLessThan20(num);
		} else {
			int tenner = num / 10;
			int rest = num - tenner * 10;
			if (rest != 0) {
				return ten(tenner) + " " + one(rest);
			} else {
				return ten(tenner);
			}
		}
	}

	private String three(int num) {
		int hundred = num / 100;
		int rest = num - hundred * 100;
		String res = "";
		
		if (hundred * rest != 0) {
			res = one(hundred) + " Hundred " + two(rest);
		} else if ((hundred == 0) && (rest != 0)) {
			res = two(rest);
		} else if ((hundred != 0) && (rest == 0)) {
			res = one(hundred) + " Hundred";
		}
		return res;
	}

	public String numberToWords(int num) {
		StringBuilder sb = new StringBuilder();

		if (num == 0) {
			return sb.append(one(num)).toString();
		}

		int billion = num / 1000000000;
		int million = (num - billion * 1000000000) / 1000000;
		int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
		int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;

		if (billion != 0) {
			sb.append(three(billion) + " Billion");
		}

		if (million != 0) {
			if (sb.length() > 0) {
				sb.append(" ");
			}
			sb.append(three(million) + " Million");
		}
		if (thousand != 0) {
			if (sb.length() > 0) {
				sb.append(" ");
			}
			sb.append(three(thousand) + " Thousand");
		}
		if (rest != 0) {
			if (sb.length() > 0) {
				sb.append(" ");
			}
			sb.append(three(rest));
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		IntegerToEnglishWords englishWords = new IntegerToEnglishWords();
		System.out.println(englishWords.numberToWords(123));
		System.out.println(englishWords.numberToWords(12345));
		System.out.println(englishWords.numberToWords(1234567));
		System.out.println(englishWords.numberToWords(1000));
	}
}
