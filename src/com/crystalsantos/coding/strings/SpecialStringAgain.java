package com.crystalsantos.coding.strings;

import java.io.IOException;
import java.util.Scanner;

public class SpecialStringAgain {

	static long substrCount(int n, String s) {
	    int counter = n;
					
	    // to count consecutive characters that are the same
	    int consec = 1;
	    
	    int midIndex = -1;
					
	    for (int i = 1; i < n; i++) {
	        if (s.charAt(i) == s.charAt(i-1)) {
	            
	            counter += consec;
	            consec++;
	                
	            // Condition 2: All characters except the middle one are the same
	            if (midIndex > 0) {
	                if ((midIndex-consec) >= 0 && s.charAt(midIndex-consec) == s.charAt(i)) {
	                    counter++;
	                } else {
	                    midIndex = -1; 
	                }
	            }
	        } else {
	            consec = 1;
	                
	            if (((i-2) >= 0) && s.charAt(i-2) == s.charAt(i)) {
	                counter++; // 3-char symmetry is detected

	                midIndex = i-1;
	            } else {
	                midIndex = -1;
	            }
	        }
	    }
	    return counter;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = scanner.nextLine();

		System.out.println(substrCount(n, s));

		scanner.close();
	}
}
