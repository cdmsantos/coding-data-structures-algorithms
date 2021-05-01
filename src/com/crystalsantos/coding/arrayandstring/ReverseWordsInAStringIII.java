package com.crystalsantos.coding.arrayandstring;

public class ReverseWordsInAStringIII {
	public String reverseWords(String s) {
		char[] sChar = s.toCharArray();
		int start = 0;
		int end = 0;

		for (int i = 0; i < sChar.length; i++) {
			if (sChar[i] == ' ') {
				end = i - 1;
				swap(sChar, start, end);
				start = i + 1;
				end = i + 1;
			}
		}

		if (start == end && start != sChar.length - 1) {
			swap(sChar, start, sChar.length - 1);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sChar.length; i++) {
			sb.append(sChar[i]);
		}

		return sb.toString();
	}

	private void swap(char[] sChar, int start, int end) {
		while (start < end) {
			char temp = sChar[end];
			sChar[end] = sChar[start];
			sChar[start] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		ReverseWordsInAStringIII reverseWord = new ReverseWordsInAStringIII();
		System.out.println(reverseWord.reverseWords("Let's take LeetCode contest"));
		System.out.println(reverseWord.reverseWords("God Ding"));
	}
}
