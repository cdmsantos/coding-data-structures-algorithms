package com.crystalsantos.coding.greedy;

import java.io.IOException;
import java.util.Scanner;

/**
 * Pseudocode
		First we need to count the occurrences of the characters.
		Then we make a copy of the occurrences this call it the usable characters.
		Then we half the occurrences and call this the required characters
		Then we make an empty count for our solution.
		And and empty string for our solution
		From right to left in the string s
		— If the character is required
		— — we backtrack if we can and improve our solution
		— — we add the character to the solution
		— — we add it to the solution count
		— — we reduce form the usable count
		— else
		— — we ignore and reduce form the usable count
		return our solution
 * */
public class ReverseShuffleMerge {

	static String reverseShuffleMerge(String s) {
		int[] letters = new int[26];
		int uniqueElement = 0;

		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			if (letters[currentChar - 'a'] == 0) {
				uniqueElement++;
			}
			letters[currentChar - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			// find letter quantity for A removing the second occurrence of A
			letters[i] = letters[i] / 2;
		}

		int sSize = s.length();
		StringBuilder result = new StringBuilder(s.length() / 2); // a size
		while (uniqueElement > 0) {
			// find the smallest window which have elements of frequency as subsequence
			int[] tempFrequency = letters.clone();
			int tempUniqueElement = uniqueElement;
			int windowSize = 0;

			for (int i = 0; i < s.length(); i++) {
				char currentChar = s.charAt(i);
				tempFrequency[currentChar - 'a']--;
				if (tempFrequency[currentChar - 'a'] == 0)
					tempUniqueElement--;
				if (tempUniqueElement == 0)
					break;
				windowSize++;
			}
			Character minCharacter = null;
			for (int i = sSize - 1; i >= windowSize; i--) {
				if (letters[s.charAt(i) - 'a'] == 0) {
					continue;
				}
				if (minCharacter == null || minCharacter > s.charAt(i)) {
					minCharacter = s.charAt(i);
					sSize = i;
				}
			}
			result.append(minCharacter);
			letters[minCharacter - 'a']--;
			if (letters[minCharacter - 'a'] == 0) {
				uniqueElement--;
			}
		}
		return result.toString();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String s = scanner.nextLine();
		System.out.println(reverseShuffleMerge(s));
		scanner.close();
	}
}
