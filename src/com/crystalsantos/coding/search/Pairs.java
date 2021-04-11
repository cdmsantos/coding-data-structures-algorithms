package com.crystalsantos.coding.search;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Pairs {

	static int pairs(int k, int[] arr) {
		int pairs = 0;

		HashSet<Integer> set = new HashSet<>();
		for (int num : arr) {
			set.add(num);
		}

		for (int number : arr) {
			if (set.contains(number + k)) {
				pairs++;
			}
		}

		return pairs;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		System.out.println(pairs(k, arr));

		scanner.close();
	}
}
