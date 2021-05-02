package com.crystalsantos.coding.dictionaries.hashmaps;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int start = 0;
		int end = 0;
		int maxLength = 0;
		Set<Character> uniqueCharacters = new HashSet<>();
		while (end < s.length()) {
			if (uniqueCharacters.add(s.charAt(end))) {
				end++;
				maxLength = Math.max(maxLength, uniqueCharacters.size());
			} else {
				uniqueCharacters.remove(s.charAt(start));
				start++;
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters longest = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(longest.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(longest.lengthOfLongestSubstring("bbbbb"));
		System.out.println(longest.lengthOfLongestSubstring("pwwkew"));
		System.out.println(longest.lengthOfLongestSubstring(""));
		System.out.println(longest.lengthOfLongestSubstring(" "));
		System.out.println(longest.lengthOfLongestSubstring("dvdf"));
	}
}
