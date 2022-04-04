package com.crystalsantos.coding.amazon.arraysandstring;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Reorder Log Files
 * 
 * You are given an array of logs. Each log is a space-delimited string of
 * words, where the first word is the identifier.
 * 
 * There are two types of logs:
 * 
 * Letter-logs: All words (except the identifier) consist of lowercase English
 * letters. Digit-logs: All words (except the identifier) consist of digits.
 * Reorder these logs so that:
 * 
 * The letter-logs come before all digit-logs. The letter-logs are sorted
 * lexicographically by their contents. If their contents are the same, then
 * sort them lexicographically by their identifiers. The digit-logs maintain
 * their relative ordering. Return the final order of the logs.
 * 
 * Example 1:
 * 
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit
 * dig","let3 art zero"] Output: ["let1 art can","let3 art zero","let2 own kit
 * dig","dig1 8 1 5 1","dig2 3 6"] Explanation: The letter-log contents are all
 * different, so their ordering is "art can", "art zero", "own kit dig". The
 * digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6". Example 2:
 * 
 * Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act
 * zoo"] Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4
 * 4 7"]
 * 
 * 
 * Constraints:
 * 
 * 1 <= logs.length <= 100 3 <= logs[i].length <= 100 All the tokens of logs[i]
 * are separated by a single space. logs[i] is guaranteed to have an identifier
 * and at least one word after the identifier.
 */
public class ReorderLogFiles {

	class LetterLog {
		String identifier;
		String log;
		String initialLog;

		public LetterLog(String identifier, String log, String initialLog) {
			this.identifier = identifier;
			this.log = log;
			this.initialLog = initialLog;
		}
	}

	public String[] reorderLogFiles(String[] logs) {

		List<String> digits = new ArrayList<>();

		Queue<LetterLog> letters = new PriorityQueue<>((l1, l2) -> compare(l1, l2));

		for (String log : logs) {
			String[] findLogs = log.split(" ");
			if (findLogs[1].matches("^[0-9]+$")) {
				digits.add(log);
			} else {
				letters.add(
						new LetterLog(log.substring(0, log.indexOf(" ")), log.substring(log.indexOf(" ") + 1), log));
			}
		}

		String[] result = new String[logs.length];
		int i = 0;
		while (!letters.isEmpty()) {
			result[i] = letters.poll().initialLog;
			i++;
		}

		for (String digit : digits) {
			result[i] = digit;
			i++;
		}

		return result;
	}

	private int compare(LetterLog l1, LetterLog l2) {
		if (l1.log.equals(l2.log)) {
			return l1.identifier.compareTo(l2.identifier);
		} else {
			return l1.log.compareTo(l2.log);
		}
	}

	public static void main(String[] args) {
		ReorderLogFiles logFiles = new ReorderLogFiles();
		logFiles.printResult(logFiles.reorderLogFiles(
				new String[] { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" }));
		logFiles.printResult(logFiles.reorderLogFiles(
				new String[] { "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo" }));
		logFiles.printResult(logFiles.reorderLogFiles(
				new String[] { "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a2 act car" }));
	}

	private void printResult(String[] result) {
		System.out.print("[");

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
			if (i != result.length - 1) {
				System.out.print(", ");
			}
		}

		System.out.print("]");
		System.out.println();
	}
}
