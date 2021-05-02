package com.crystalsantos.coding.dictionaries.hashmaps;

import java.util.Arrays;

public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		Boolean[] marked = new Boolean[256];
		Arrays.fill(marked, Boolean.FALSE);

		int[] map = new int[256];
		Arrays.fill(map, -1);

		for (int i = 0; i < t.length(); i++) {

			if (map[s.charAt(i)] == -1) {

				if (marked[t.charAt(i)] == true) {
					return false;
				}

				marked[t.charAt(i)] = true;

				map[s.charAt(i)] = t.charAt(i);
			} else if (map[s.charAt(i)] != t.charAt(i)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		IsomorphicStrings isomorphicStrings = new IsomorphicStrings();

		System.out.println(isomorphicStrings.isIsomorphic("egg", "add"));
		System.out.println(isomorphicStrings.isIsomorphic("foo", "bar")); // false
		System.out.println(isomorphicStrings.isIsomorphic("paper", "title"));
		System.out.println(isomorphicStrings.isIsomorphic("badc", "baba")); // false
		System.out.println(isomorphicStrings.isIsomorphic("egcd", "adfd"));// false
	}
}
