package com.crystalsantos.coding.dictionaries.hashmaps;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class TwoStrings {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
    	char[] s1Chars = s1.toCharArray();
    	char[] s2Chars = s2.toCharArray();
    	HashMap<Character, Integer> mapS1Chars = new HashMap<Character, Integer>();
    	
    	for(int i = 0; i < s1Chars.length; i++) {
    		if(mapS1Chars.containsKey(s1Chars[i])) {
    			int value = mapS1Chars.get(s1Chars[i]);
    			mapS1Chars.replace(s1Chars[i], value+1);
    		} else {    			
    			mapS1Chars.put(s1Chars[i], 1);
    		}
    	}
    	
    	for(int j = 0; j < s2Chars.length; j++) {
    		if(mapS1Chars.containsKey(s2Chars[j])) {
    			return "YES";
    		}
    	}
    	
    	return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            System.out.println(result);
        }
        scanner.close();
    }
}
