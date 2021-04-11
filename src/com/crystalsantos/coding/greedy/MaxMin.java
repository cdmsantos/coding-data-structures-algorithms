package com.crystalsantos.coding.greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {

	// Complete the maxMin function below.
	static int maxMin(int k, int[] arr) {
		int unfairness = Integer.MAX_VALUE;

		Arrays.sort(arr);
		for(int i = 0; i < arr.length; i++ ) {
			for(int j = i+k-1; j < arr.length; j+=k-1) {
				int difference = arr[j] - arr[i];
				if(difference < unfairness) {
					unfairness = difference;
				}
			}
		}
		return unfairness;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int k = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			int arrItem = scanner.nextInt();
			arr[i] = arrItem;
		}

		System.out.println(maxMin(k, arr));

		scanner.close();
	}
}
