package com.crystalsantos.coding.strings;

import java.io.IOException;
import java.util.Scanner;

public class MakingAnagrams {

	// Complete the makeAnagram function below.
	static int makeAnagram(String a, String b) {
		char[] aChar = a.toCharArray();
		char[] bChar = b.toCharArray();
		
		int deletions = 0;
		
		int equalsCharacters = 0;
		for(int i = 0; i < aChar.length; i++) {
			int index = new String(bChar).indexOf(aChar[i]);
			if(index >= 0) {
				bChar[index] = '0';
				equalsCharacters++;					
			}
		}
		
		if(equalsCharacters < aChar.length) {
			deletions += aChar.length - equalsCharacters;
		} if(equalsCharacters < bChar.length) {
			deletions += bChar.length - equalsCharacters;
		}
		
		return deletions;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String a = scanner.nextLine();
		String b = scanner.nextLine();

		int res = makeAnagram(a, b);

		System.out.println(res);

		scanner.close();
	}
}
