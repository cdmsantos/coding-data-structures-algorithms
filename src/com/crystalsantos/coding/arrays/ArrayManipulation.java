package com.crystalsantos.coding.arrays;

import java.io.IOException;
import java.util.Scanner;

public class ArrayManipulation {

	// Complete the arrayManipulation function below.
	static long arrayManipulation(int n, int[][] queries) {
        long[] array = new long[n];
        long max = 0;
        for(int i = 0; i < queries.length; i++) {        	
        	for(int j = queries[i][0]-1; j <= queries[i][1]-1; j++) {
        		long newValue = array[j] + queries[i][2];
        		array[j] = newValue;
        		
        		if(newValue > max) {
        			max = newValue;
        		}
        	}
        }
        return max;
    }

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		int[][] queries = new int[m][3];

		for (int i = 0; i < m; i++) {
			String[] queriesRowItems = scanner.nextLine().split(" ");

			for (int j = 0; j < 3; j++) {
				int queriesItem = Integer.parseInt(queriesRowItems[j]);
				queries[i][j] = queriesItem;
			}
		}

		long result = arrayManipulation(n, queries);

		System.out.println(result);

		scanner.close();
	}
}
