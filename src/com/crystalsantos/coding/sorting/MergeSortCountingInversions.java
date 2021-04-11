package com.crystalsantos.coding.sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MergeSortCountingInversions {

	public static long countInversions(int[] arr) {
		return mergeSort(arr, 0, arr.length - 1);
	}

	public static long mergeSort(int[] arr, int start, int end) {
		if (start == end) {
			return 0;			
		}
		
		int middle = (start + end) / 2;
		long inversions = 0;
		
		inversions += mergeSort(arr, start, middle); // left inversions
		inversions += mergeSort(arr, middle + 1, end);// right inversions
		inversions += merge(arr, start, end); // split inversions.
		
		return inversions;
	}

	public static long merge(int[] arr, int start, int end) {
		int middle = (start + end) / 2;
		int[] newArr = new int[end - start + 1];
		
		int current = 0;
		int i = start;
		int j = middle + 1;
		long inversions = 0;
		
		while (i <= middle && j <= end) {
			if (arr[i] > arr[j]) {
				newArr[current++] = arr[j++];
				inversions += middle - i + 1; // Tricky part.
			} else
				newArr[current++] = arr[i++];
		}
		
		// Leftover elements here.
		while (i <= middle) {
			newArr[current++] = arr[i++];
		}

		while (j <= end) {
			newArr[current++] = arr[j++];
		}

		System.arraycopy(newArr, 0, arr, start, end - start + 1); // Usual stuff from merge sort algorithm with arrays.
		return inversions;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] arr = new int[n];

			String[] arrItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int arrItem = Integer.parseInt(arrItems[i]);
				arr[i] = arrItem;
			}

			long result = countInversions(arr);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
