package com.crystalsantos.coding.arrays;

import java.io.IOException;
import java.util.Scanner;

public class ArrayManipulationBetterTime {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);
		long[] array = new long[n + 1];

		while (m-- > 0) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int k = scanner.nextInt();
			array[a - 1] += k;
			array[b] -= k;
		}
		scanner.close();

		long sum = 0;
		long max = 0;
		for (int i = 0; i < n; i++) {
			sum += array[i];
			max = Math.max(max, sum);
		}

		System.out.println(max);
	}
}
