package com.crystalsantos.coding.amazon.treesandgraphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Word Ladder
 * 
 * A transformation sequence from word beginWord to word endWord using a
 * dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk
 * such that:
 * 
 * Every adjacent pair of words differs by a single letter. Every si for 1 <= i
 * <= k is in wordList. Note that beginWord does not need to be in wordList. sk
 * == endWord Given two words, beginWord and endWord, and a dictionary wordList,
 * return the number of words in the shortest transformation sequence from
 * beginWord to endWord, or 0 if no such sequence exists.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log","cog"] Output: 5 Explanation: One shortest
 * transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is
 * 5 words long. Example 2:
 * 
 * Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log"] Output: 0 Explanation: The endWord "cog" is
 * not in wordList, therefore there is no valid transformation sequence.
 * 
 * 
 * Constraints:
 * 
 * 1 <= beginWord.length <= 10 endWord.length == beginWord.length 1 <=
 * wordList.length <= 5000 wordList[i].length == beginWord.length beginWord,
 * endWord, and wordList[i] consist of lowercase English letters. beginWord !=
 * endWord All the words in wordList are unique.
 * 
 */
public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> set = new HashSet<>(wordList);
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		// COUNT NUMBER OF WORDS TRANSFORMED
		int count = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			// FOR ALL WORDS THIS ROUND
			for (int i = 0; i < size; i++) {
				char[] current = queue.poll().toCharArray();
				// TRAVERSE CURRENT WORD
				for (int j = 0; j < current.length; j++) {
					char tmp = current[j];
					// CHANGE ONE LETTER AT A TIME
					for (char c = 'a'; c <= 'z'; c++) {
						current[j] = c;
						String next = new String(current);
						// WHEN NEXT WORD IS IN THE SET
						if (set.contains(next)) {
							if (next.equals(endWord))
								return count + 1;
							queue.add(next);
							set.remove(next);
						}
					}
					// HAVE TO UNDO FOR NEXT CHANGE OF LETTER
					current[j] = tmp;
				}
			}
			// THIS ROUND ENDS WITH ONE LETTER CHANGED
			count++;
		}
		return 0;
	}

	public static void main(String[] args) {
		WordLadder wordLadder = new WordLadder();
		System.out.println(
				wordLadder.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))); // 5
		System.out.println(wordLadder.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log"))); // 0
	}
}
