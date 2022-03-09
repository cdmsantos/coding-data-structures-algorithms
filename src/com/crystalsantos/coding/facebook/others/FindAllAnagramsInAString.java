package com.crystalsantos.coding.facebook.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 
 * Find All Anagrams in a String
 * 
 * Given two strings s and p, return an array of all the start indices of p's
 * anagrams in s. You may return the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * Example 1:
 * 
 * Input: s = "cbaebabacd", p = "abc" Output: [0,6] Explanation: The substring
 * with start index = 0 is "cba", which is an anagram of "abc". The substring
 * with start index = 6 is "bac", which is an anagram of "abc". Example 2:
 * 
 * Input: s = "abab", p = "ab" Output: [0,1,2] Explanation: The substring with
 * start index = 0 is "ab", which is an anagram of "ab". The substring with
 * start index = 1 is "ba", which is an anagram of "ab". The substring with
 * start index = 2 is "ab", which is an anagram of "ab".
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length, p.length <= 3 * 104 s and p consist of lowercase English
 * letters.
 * 
 */
public class FindAllAnagramsInAString {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();

		if (s.length() < p.length()) {
			return result;
		}

		Map<Character, Integer> pMap = new HashMap<>();
		for (char ch : p.toCharArray()) {
			if (pMap.containsKey(ch)) {
				pMap.put(ch, pMap.get(ch) + 1);
			} else {
				pMap.put(ch, 1);
			}
		}

		Map<Character, Integer> sMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (sMap.containsKey(ch)) {
				sMap.put(ch, sMap.get(ch) + 1);
			} else {
				sMap.put(ch, 1);
			}
			// remove one letter
			// from the left side of the window
			// because size is greater than p
			if (i >= p.length()) {
				ch = s.charAt(i - p.length());
				if (sMap.get(ch) == 1) {
					sMap.remove(ch);
				} else {
					sMap.put(ch, sMap.get(ch) - 1);
				}
			}

			// compare hashmap in the sliding window
			// with the reference hashmap
			if (pMap.equals(sMap)) {
				result.add(i - p.length() + 1);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		FindAllAnagramsInAString anagrams = new FindAllAnagramsInAString();
		anagrams.printResult(anagrams.findAnagrams("cbaebabacd", "abc"));
		anagrams.printResult(anagrams.findAnagrams("abab", "ab"));
		anagrams.printResult(anagrams.findAnagrams("aaaa", "b"));
		anagrams.printResult(anagrams.findAnagrams("aa", "aa"));
		anagrams.printResult(anagrams.findAnagrams("abcabcabcabcabc", "abcabcabcabcabc"));
	}

	private void printResult(List<Integer> result) {
		System.out.print("[");

		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
			if (i != result.size() - 1) {
				System.out.print(" , ");
			}
		}

		System.out.print("]");
		System.out.println();
	}
}
