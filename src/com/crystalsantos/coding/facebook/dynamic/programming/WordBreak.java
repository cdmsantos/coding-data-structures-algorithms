package com.crystalsantos.coding.facebook.dynamic.programming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/***
 * 
 * Word Break
 * 
 * Given a string s and a dictionary of strings wordDict, return true if s can
 * be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * Note that the same word in the dictionary may be reused multiple times in the
 * segmentation.
 * 
 * Example 1:
 * 
 * Input: s = "leetcode", wordDict = ["leet","code"] Output: true Explanation:
 * Return true because "leetcode" can be segmented as "leet code". Example 2:
 * 
 * Input: s = "applepenapple", wordDict = ["apple","pen"] Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple". Note that you are allowed to reuse a dictionary word. Example 3:
 * 
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"] Output:
 * false
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 300 1 <= wordDict.length <= 1000 1 <= wordDict[i].length <=
 * 20 s and wordDict[i] consist of only lowercase English letters. All the
 * strings of wordDict are unique.
 */
public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		if (wordDict != null && !wordDict.isEmpty() && s != null && !s.isEmpty()) {
			Set<String> wordDictSet = new HashSet<>(wordDict);
			Queue<Integer> queue = new LinkedList<>();
			boolean[] visited = new boolean[s.length()];
			queue.add(0);
			while (!queue.isEmpty()) {
				int start = queue.remove();
				if (visited[start]) {
					continue;
				}
				for (int end = start + 1; end <= s.length(); end++) {
					if (wordDictSet.contains(s.substring(start, end))) {
						queue.add(end);
						if (end == s.length()) {
							return true;
						}
					}
				}
				visited[start] = true;
			}
			return false;
		}

		return false;
	}

	public static void main(String[] args) {
		WordBreak wordBreak = new WordBreak();
		System.out.println(wordBreak.wordBreak("leetcode", Arrays.asList("leet", "code"))); // true
		System.out.println(wordBreak.wordBreak("applepenapple", Arrays.asList("apple", "pen"))); // true
		System.out.println(wordBreak.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"))); // false
	}
}
