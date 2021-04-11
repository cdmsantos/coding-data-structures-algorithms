package com.crystalsantos.coding.dictionaries.hashmaps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SherlockAndAnagrams {

	static int sherlockAndAnagrams(String s) {
		ArrayList<String> subStrings = new ArrayList<String>();
		int countAnagrams = 0;
		for(int i = 0; i < s.length(); i++) {
			for(int j = 1; j <= s.length() - i; j++) {
				String sub = s.substring(i, i+j);
				subStrings.add(sub);
			}
		}
		
		for(int i = 0; i < subStrings.size(); i++) {
			String selectedString = subStrings.get(i);
			for(int j = i+1; j < subStrings.size(); j++) {
				if(isAnagram(subStrings.get(j), selectedString)) {
					countAnagrams++;
				}
			}
		}
		
		return countAnagrams;
	}
	
	private static boolean isAnagram(String a, String b) {
		if(a.length() != b.length()) {
			return false;
		}
		
		int[] letters = new int[26];
		for(int i = 0; i < a.length(); i++) {
			char letterA = a.charAt(i);
			letters[letterA - 'a']++;
			
			char letterB = b.charAt(i);
			letters[letterB - 'a']--;
		}
		
		for(int j = 0; j < letters.length; j++) {
			if(letters[j] != 0) {
				return false;
			}
		}
		
		return true;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			int result = sherlockAndAnagrams(s);

			System.out.println(result);
		}

		scanner.close();
	}
}
