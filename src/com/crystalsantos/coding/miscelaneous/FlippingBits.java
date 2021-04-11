package com.crystalsantos.coding.miscelaneous;

import java.io.IOException;
import java.util.Scanner;

public class FlippingBits {
	static long flippingBits(long n) {
		long[] b = new long[32];
		int j = b.length - 1;
		
		//from base 10 to base 2
		while (n != 0) {
			b[j] = n % 2;
			n = n / 2;
			j--;
		}
		
		for (int i = 0; i < b.length; i++) {
			if (b[i] == 0) {
				b[i] = 1;
			} else {
				b[i] = 0;
			}
		}
		
		//from base 2 to base 10
		long num = 2 * b[0];
		for (int i = 1; i < b.length - 1; i++) {
			num += b[i];
			num = num * 2;
		}
		
		return num + b[b.length - 1];
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			long n = scanner.nextLong();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			System.out.println(flippingBits(n));
		}

		scanner.close();
	}
}
