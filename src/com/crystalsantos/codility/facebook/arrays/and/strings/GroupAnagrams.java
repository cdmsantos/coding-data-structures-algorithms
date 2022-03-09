package com.crystalsantos.codility.facebook.arrays.and.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 
 * Group Anagrams
 * 
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: strs = ["eat","tea","tan","ate","nat","bat"] Output:
 * [["bat"],["nat","tan"],["ate","eat","tea"]] Example 2:
 * 
 * Input: strs = [""] Output: [[""]] Example 3:
 * 
 * Input: strs = ["a"] Output: [["a"]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= strs.length <= 104 0 <= strs[i].length <= 100 strs[i] consists of
 * lowercase English letters.
 *
 */
public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> values = new ArrayList<String>();

		if (strs.length == 1) {
			values.add(strs[0]);
			result.add(values);
			return result;
		}

		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		for (int i = 0; i < strs.length; i++) {
			String key = orderedString(strs[i]);
			List<String> valuesList = map.getOrDefault(key, new ArrayList<String>());
			
			valuesList.add(strs[i]);
			map.put(key, valuesList);
		}

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			values.addAll(entry.getValue());
			result.add(values);
			values = new ArrayList<String>();
		}
		
		return result;
	}

	private String orderedString(String str) {
		char charArray[] = str.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
	
	private void printResult(List<List<String>> result) {
		for (int i = 0; i < result.size(); i++) {
			List<String> temp = result.get(i);

			for (int j = 0; j < temp.size(); j++) {
				System.out.print(temp.get(j) + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		GroupAnagrams group = new GroupAnagrams();

		String[] strs1 = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> result1 = group.groupAnagrams(strs1);
		group.printResult(result1);

		String[] strs2 = { "" };
		List<List<String>> result2 = group.groupAnagrams(strs2);
		group.printResult(result2);

		String[] strs3 = { "a" };
		List<List<String>> result3 = group.groupAnagrams(strs3);
		group.printResult(result3);
	}
}
