package com.crystalsantos.coding.arrays;

import java.io.IOException;
import java.util.Scanner;

public class MinimumSwap2 {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
    	int swaps = 0;
    	for(int i = 0; i < arr.length; i++) {
    		if(arr[i] != i+1) {
    			int temp = i;
    			while(arr[temp]!=i+1){
                    temp++;  
                }
    			
    			int swap = arr[temp];
    			arr[temp] = arr[i];
    			arr[i] = swap;
    			swaps++;
    		}
    	}
    	
    	return swaps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        System.out.println(res);
        scanner.close();
    }
}

