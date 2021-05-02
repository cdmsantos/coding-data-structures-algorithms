package com.crystalsantos.coding.dictionaries.hashmaps;

import java.util.HashSet;
import java.util.Set;

public class FirstUniqueCharacterInAString {
	public int firstUniqChar(String s) {
		Set<Character> set = new HashSet<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			int found = 0;
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					found++;
					set.add(s.charAt(i));
					break;
				}
			}

			if (found == 0 && !set.contains(s.charAt(i))) {
				return i;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		FirstUniqueCharacterInAString unique = new FirstUniqueCharacterInAString();

		System.out.println(unique.firstUniqChar("leetcode"));
		System.out.println(unique.firstUniqChar("loveleetcode"));
		System.out.println(unique.firstUniqChar("aabb"));
	}
}
