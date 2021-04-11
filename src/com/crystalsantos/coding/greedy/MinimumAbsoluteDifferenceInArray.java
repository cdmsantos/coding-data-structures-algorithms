package com.crystalsantos.coding.greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumAbsoluteDifferenceInArray {

	static int minimumAbsoluteDifference(int[] arr) {
		
		Arrays.sort(arr);
		int minimum = Integer.MAX_VALUE;
		for(int i = 0; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				int diff = Math.abs(arr[i] - arr[j]);
				if(diff < minimum && diff >= 0) {
					minimum = diff;
				} else if(diff > minimum) {
					break;
				}
			}
		}
		
		return minimum;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");

		for (int i = 0; i < arrItems.length; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		System.out.println(minimumAbsoluteDifference(arr));

		scanner.close();
	}
}
