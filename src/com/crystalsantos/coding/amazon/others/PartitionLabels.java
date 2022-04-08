package com.crystalsantos.coding.amazon.others;

import java.util.ArrayList;
import java.util.List;

/**
 * Partition Labels
 * 
 * You are given a string s. We want to partition the string into as many parts
 * as possible so that each letter appears in at most one part.
 * 
 * Note that the partition is done so that after concatenating all the parts in
 * order, the resultant string should be s.
 * 
 * Return a list of integers representing the size of these parts.
 * 
 * Example 1:
 * 
 * Input: s = "ababcbacadefegdehijhklij" Output: [9,7,8] Explanation: The
 * partition is "ababcbaca", "defegde", "hijhklij". This is a partition so that
 * each letter appears in at most one part. A partition like "ababcbacadefegde",
 * "hijhklij" is incorrect, because it splits s into less parts. Example 2:
 * 
 * Input: s = "eccbbbbdec" Output: [10]
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 500 s consists of lowercase English letters.
 */
public class PartitionLabels {
	public List<Integer> partitionLabels(String s) {
		int[] last = new int[26];
		for (int i = 0; i < s.length(); ++i) {
			last[s.charAt(i) - 'a'] = i;
		}
		
		int j = 0, anchor = 0;
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < s.length(); ++i) {
			j = Math.max(j, last[s.charAt(i) - 'a']);
			if (i == j) {
				result.add(i - anchor + 1);
				anchor = i + 1;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		PartitionLabels partition = new PartitionLabels();
		partition.printResult(partition.partitionLabels("ababcbacadefegdehijhklij"));
		partition.printResult(partition.partitionLabels("eccbbbbdec"));
	}
	
	private void printResult(List<Integer> result) {
		System.out.print("[ ");
		for (Integer res : result) {
			System.out.print(res + " ");
		}
		System.out.print("]");
		System.out.println();
	}
}
