package com.crystalsantos.coding.amazon.arraysandstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Most Common Word
 * 
 * Given a string paragraph and a string array of the banned words banned,
 * return the most frequent word that is not banned. It is guaranteed there is
 * at least one word that is not banned, and that the answer is unique.
 * 
 * The words in paragraph are case-insensitive and the answer should be returned
 * in lowercase.
 * 
 * Example 1:
 * 
 * Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.",
 * banned = ["hit"] Output: "ball" Explanation: "hit" occurs 3 times, but it is
 * a banned word. "ball" occurs twice (and no other word does), so it is the
 * most frequent non-banned word in the paragraph. Note that words in the
 * paragraph are not case sensitive, that punctuation is ignored (even if
 * adjacent to words, such as "ball,"), and that "hit" isn't the answer even
 * though it occurs more because it is banned. Example 2:
 * 
 * Input: paragraph = "a.", banned = [] Output: "a"
 * 
 * 
 * Constraints:
 * 
 * 1 <= paragraph.length <= 1000 paragraph consists of English letters, space '
 * ', or one of the symbols: "!?',;.". 0 <= banned.length <= 100 1 <=
 * banned[i].length <= 10 banned[i] consists of only lowercase English letters.
 * 
 */
public class MostCommonWord {
	public String mostCommonWord(String paragraph, String[] banned) {
		String[] words = paragraph.replaceAll("\\.", " ").replaceAll(";", " ").replaceAll(",", " ").replaceAll("!", " ")
				.replaceAll("\\?", " ").replaceAll("\\'", " ").toLowerCase().split(" ");

		Map<String, Integer> mapWords = new HashMap<>();
		List<String> bannedList = Arrays.asList(banned);

		String commonWord = null;
		int maxCount = 0;

		for (String word : words) {
			if (!bannedList.contains(word) && !word.isEmpty()) {
				int count = mapWords.getOrDefault(word, 0) + 1;
				mapWords.put(word, count);

				if (maxCount < count) {
					maxCount = count;
					commonWord = word;
				}
			}
		}

		return commonWord;
	}

	public static void main(String[] args) {
		MostCommonWord word = new MostCommonWord();
		System.out.println(word.mostCommonWord("Bob hit a! ball, the 'hit BALL flew; far after? it was hit.",
				new String[] { "ball" }));
		System.out.println(word.mostCommonWord("\"a, a, a, a, b,b,b,c, c", new String[] { "a" }));
	}
}
