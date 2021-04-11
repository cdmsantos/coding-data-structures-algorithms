package com.crystalsantos.coding.search;

import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

// modular arithmetic problem
// explanation: https://www.quora.com/What-is-the-logic-used-in-the-HackerRank-Maximise-Sum-problem
public class MaximumSubarraySum {

	// Complete the maximumSum function below.
	static long maximumSum(long[] a, long m) {
		long maxSum = 0;

		TreeSet<Long> prefix = new TreeSet<Long>();
		long currSum = 0;

		for (int i = 0; i < a.length; i++) {
			currSum = (currSum + a[i] % m) % m;
			maxSum = Math.max(maxSum, currSum);

			Long pr = prefix.higher(currSum);
			if (pr != null) {
				maxSum = Math.max(maxSum, (currSum - pr + m) % m);
			}
			prefix.add(currSum);
		}

		return maxSum;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String[] nm = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nm[0]);

			long m = Long.parseLong(nm[1]);

			long[] a = new long[n];

			String[] aItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				long aItem = Long.parseLong(aItems[i]);
				a[i] = aItem;
			}

			System.out.println(maximumSum(a, m));
		}
		scanner.close();
	}
}
