package com.crystalsantos.coding.recursion;

public class EncryptedWords {

	static String findEncryptedWord(String s) {
		StringBuilder encrypted = new StringBuilder();
		
		if(s.length() == 1) {
			encrypted.append(s);
		} else if(s.length() == 2){	
			encrypted.append(s);			
		} else {
			int middle = 0;
			
			if(s.length()%2 == 0) {
				middle = s.length()/2 -1; //leftmost
			} else {
				middle = s.length()/2;
			}
			
			encrypted.append(s.charAt(middle));
			encrypted.append(findEncryptedWord(s.substring(0, middle)));
			encrypted.append(findEncryptedWord(s.substring(middle+1, s.length())));			
		}
		
		return encrypted.toString();
	}

	static int test_case_number = 1;

	static void check(String expected, String output) {
		boolean result = (expected.equals(output));
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printString(expected);
			System.out.print(" Your output: ");
			printString(output);
			System.out.println();
		}
		test_case_number++;
	}

	static void printString(String str) {
		System.out.print("[\"" + str + "\"]");
	}

	static public void run() {
		String s_1 = "abc";
		String expected_1 = "bac";
		String output_1 = findEncryptedWord(s_1);
		check(expected_1, output_1);

		String s_2 = "abcd";
		String expected_2 = "bacd";
		String output_2 = findEncryptedWord(s_2);
		check(expected_2, output_2);

		String s_3 = "abcxcba";
		String expected_3 = "xbacbca";
		String output_3 = findEncryptedWord(s_3);
		check(expected_3, output_3);

	}

	public static void main(String[] args) {
		run();
	}
}