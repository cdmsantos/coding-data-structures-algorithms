package com.crystalsantos.coding.dictionaries.hashmaps;

import java.util.HashMap;
import java.util.Scanner;

public class HashTableRansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
    	HashMap<String, Integer> magazineWords = new HashMap<String, Integer>();
    	
    	for(int i = 0; i < magazine.length; i++) {
    		if(magazineWords.containsKey(magazine[i])) {
    			int value = magazineWords.get(magazine[i]);
    			magazineWords.replace(magazine[i], value+1);
    		} else {    			
    			magazineWords.put(magazine[i], 1);
    		}
    	}
    	
    	int count = 0;
    	for(int j = 0; j < note.length; j++) {
    		if(magazineWords.containsKey(note[j])) {
    			int value = magazineWords.get(note[j]);
    			if(value > 0) {
    				count++;    			
    				magazineWords.replace(note[j], value -1);
    			} else {
    				break;
    			}
    		} else {
    			break;
    		}
    	}
    	
    	if(count == note.length) {
    		System.out.println("Yes");
    	} else {
    		System.out.println("No");
    	}
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
