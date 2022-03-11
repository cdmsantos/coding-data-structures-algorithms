package com.crystalsantos.coding.strings;

import java.util.HashMap;

/***
 * 
 * Valid Anagram
 * 
 * 
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "anagram", t = "nagaram" Output: true Example 2:
 * 
 * Input: s = "rat", t = "car" Output: false
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length, t.length <= 5 * 104 s and t consist of lowercase English
 * letters.
 * 
 * 
 * Follow up: What if the inputs contain Unicode characters? How would you adapt
 * your solution to such a case?
 * 
 */
public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		HashMap<Character, Integer> mapS = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			int value = mapS.getOrDefault(s.charAt(i), 0);
			mapS.put(s.charAt(i), value + 1);
		}

		for (int i = 0; i < t.length(); i++) {
			if (mapS.containsKey(t.charAt(i))) {
				int value = mapS.getOrDefault(t.charAt(i), 0);

				if (value == 1) {
					mapS.remove(t.charAt(i));
				} else {
					mapS.put(t.charAt(i), value - 1);
				}
			} else {
				return false;
			}
		}

		if (mapS.isEmpty()) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		ValidAnagram anagram = new ValidAnagram();
		System.out.println(anagram.isAnagram("anagram", "nagaram")); // true
		System.out.println(anagram.isAnagram("rat", "car")); // false
	}
}
