package com.crystalsantos.coding.miscelaneous;

import java.io.IOException;
import java.util.Scanner;

public class TimeComplexityPrimality {

	static String primality(int n) {
		if (n == 1) {
			return "Not prime";
		}

		boolean check = true;
		int l = (int) Math.sqrt(n);
		for (int i = 2; i <= l; ++i) {
			if (n % i == 0) {
				check = false;
				i = n;
			}
		}
		if (check) {
			return "Prime";
		} else {
			return "Not prime";
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int p = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int pItr = 0; pItr < p; pItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			System.out.println(primality(n));
		}

		scanner.close();
	}
}
