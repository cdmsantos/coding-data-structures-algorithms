package com.crystalsantos.coding.strings;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SherlockAndTheValidString {

    // Complete the isValid function below.
    static String isValid(String s) {
        String isValid = "NO";
        
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
        	letters[s.charAt(i) - 'a']++;
        }
        
        Arrays.sort(letters);
        int i=0;
        while(letters[i]==0){
            i++;
        }
        
        int min = letters[i];   //the smallest frequency of some letter
        int max = letters[25]; // the largest frequency of some letter

        if(min == max) {
        	isValid = "YES";
        }
        else{
            // remove one letter at higher frequency or the lower frequency 
            if(((max - min == 1) && (max > letters[24])) ||
                (min == 1) && (letters[i+1] == max)) {
            	isValid = "YES";            	
            }
        }
        
        return isValid;
    }

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String s = scanner.nextLine();
		String result = isValid(s);
		System.out.println(result);

		scanner.close();
	}
}
