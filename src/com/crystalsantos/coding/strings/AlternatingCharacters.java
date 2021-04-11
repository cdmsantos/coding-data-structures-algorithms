package com.crystalsantos.coding.strings;

import java.io.IOException;
import java.util.Scanner;

public class AlternatingCharacters {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
    	int deletions = 0;
    	char[] sChar = s.toCharArray();
    	
    	for(int i = 1; i < sChar.length; i++) {
    		if(sChar[i] == sChar[i-1]) {
    			deletions++;
    		}
    	}
    	
    	return deletions;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);
            System.out.println(result);
        }

        scanner.close();
    }
}
