package com.crystalsantos.coding.dynamic.programming;

import java.io.IOException;
import java.util.Scanner;

public class MaxArraySum {

	public static int maxSubsetSum(int[] arr) {
		if (arr.length == 0) {
			return 0;
		}
		//return 0 if sum is negative
		arr[0] = Math.max(0, arr[0]);
		if (arr.length == 1) {
			return arr[0];
		}

		arr[1] = Math.max(arr[0], arr[1]);
		for (int i = 2; i < arr.length; i++) {
			arr[i] = Math.max(arr[i - 1], arr[i] + arr[i - 2]);
		}
		return arr[arr.length - 1];
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

		System.out.println(maxSubsetSum(arr));

		scanner.close();
	}
}
