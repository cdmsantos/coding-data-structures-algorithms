package com.crystalsantos.coding.arrayandstring;

public class ReverseWordInAString {

	public String reverseWords(String s) {
		if (s == null) {
			return null;
		}

		if (s.isEmpty()) {
			return "";
		}

		s = s.trim().replaceAll(" +", " ");

		String[] strings = s.split(" ");

		int end = strings.length - 1;
		for (int start = 0; start < strings.length && start < end; start++) {
			String temp = strings[end].trim();
			strings[end] = strings[start].trim();
			strings[start] = temp;
			end--;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strings.length; i++) {
			if (!strings[i].trim().isEmpty()) {
				sb.append(strings[i]);
			}
			if (i + 1 < strings.length) {
				sb.append(" ");
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		ReverseWordInAString reverseWord = new ReverseWordInAString();
		System.out.println(reverseWord.reverseWords("Alice does not even like bob"));
		System.out.println(reverseWord.reverseWords("  Bob    Loves  Alice   "));
		System.out.println(reverseWord.reverseWords("a good   example"));
		System.out.println(reverseWord.reverseWords("  hello world  "));
		System.out.println(reverseWord.reverseWords("the sky is blue"));
	}
}
