package com.crystalsantos.codility.facebook.arrays.and.strings;

/***
 * 
 * Valid Palindrome
 * 
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads the
 * same forward and backward. Alphanumeric characters include letters and
 * numbers.
 * 
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "A man, a plan, a canal: Panama" Output: true Explanation:
 * "amanaplanacanalpanama" is a palindrome. Example 2:
 * 
 * Input: s = "race a car" Output: false Explanation: "raceacar" is not a
 * palindrome. Example 3:
 * 
 * Input: s = " " Output: true Explanation: s is an empty string "" after
 * removing non-alphanumeric characters. Since an empty string reads the same
 * forward and backward, it is a palindrome.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 2 * 105 s consists only of printable ASCII characters.
 *
 *
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {

		if (s.isEmpty()) {
			return true;
		} else {
			s = s.toLowerCase();
			for (int i = 0, j = s.length() - 1; i < s.length() - 1 && j >= 0; ) {
				if (Character.isLetterOrDigit(s.charAt(i)) && Character.isLetterOrDigit(s.charAt(j))
						&& s.charAt(i) != s.charAt(j)) {
					return false;
				} else if (Character.isLetterOrDigit(s.charAt(i)) && Character.isLetterOrDigit(s.charAt(j))
						&& s.charAt(i) == s.charAt(j)) {
					if(i == j) {
						return true;
					}
					i++;
					j--;
				} else if(!Character.isLetterOrDigit(s.charAt(i))) {
					i++;
				} else if(!Character.isLetterOrDigit(s.charAt(j))) {
					j--;
				}
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		ValidPalindrome palindrome = new ValidPalindrome();
		System.out.println(palindrome.isPalindrome("A man, a plan, a canal: Panama")); //true
		System.out.println(palindrome.isPalindrome("race a car")); //false
		System.out.println(palindrome.isPalindrome(" ")); //true
		System.out.println(palindrome.isPalindrome("a.")); //false
		System.out.println(palindrome.isPalindrome("Never a foot too far, even.")); //true
	}
}
