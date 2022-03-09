package com.crystalsantos.coding.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string as input, return the list of all the patterns possible:
 * '1'  : ['A', 'B', 'C'], 
 * '2'  : ['D', 'E'], 
 * '12' : ['X'],
 * '3'  : ['P', 'Q']
 * 
 * Example if input is '123', then output should be [ADP, ADQ, AEP, AEQ, BDP,
 * BDQ, BEP, BEQ, CDP, CDQ, CEP, CEQ, XP, XQ]
 * 
 */
public class GeneratePatterns {

	public static List<String> getAllPatterns(Map<String, List<Character>> map, String str) {
		List<String> ans = new ArrayList<>();
		dfsPatterns(map, str, 0, new StringBuilder(), ans);
		return ans;
	}

	private static void dfsPatterns(Map<String, List<Character>> map, String str, int index, StringBuilder sb,
			List<String> ans) {
		if (index >= str.length()) {
			ans.add(sb.toString());
			return;
		}

		for (int i = index + 1; i <= str.length(); i++) {
			String key = str.substring(index, i);
			if (map.containsKey(key)) {
				List<Character> list = map.get(key);
				for (Character c : list) {
					sb.append(c);
					dfsPatterns(map, str, i, sb, ans);
					sb.deleteCharAt(sb.length() - 1);
				}
			}

		}
	}

	public static void main(String[] args) {
		Map<String, List<Character>> map = new HashMap<>();
		map.put("1", Arrays.asList('A', 'B', 'C'));
		map.put("2", Arrays.asList('D', 'E'));
		map.put("12", Arrays.asList('X'));
		map.put("3", Arrays.asList('P', 'Q'));
		System.out.println(getAllPatterns(map, "12"));
	}
}
