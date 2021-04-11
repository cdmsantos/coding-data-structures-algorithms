package com.crystalsantos.coding.stacks.queues;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class MinMaxRiddle {

	static long[] riddle(long[] arr) {
		int n = arr.length;
		Stack<Integer> s = new Stack<>();

		long left[] = new long[n + 1];
		long right[] = new long[n + 1];

        // Initialize elements of left[] and right[]
        for (int i=0; i<n; i++){
            left[i] = -1;
            right[i] = n;
        }
        
		// Fill elements of left[] using logic discussed on
		// https://www.geeksforgeeks.org/next-greater-element/
		for (int i = 0; i < n; i++) {
			while (!s.empty() && arr[s.peek()] >= arr[i])
				s.pop();

			if (!s.empty())
				left[i] = s.peek();

			s.push(i);
		}

		s.clear();

		// Fill elements of right[] using same logic
		for (int i = n - 1; i >= 0; i--) {
			while (!s.empty() && arr[s.peek()] >= arr[i])
				s.pop();

			if (!s.empty())
				right[i] = s.peek();

			s.push(i);
		}

		long answer[] = new long[n + 1];

		// Fill answer array by comparing minimums of all
		// lengths computed using left[] and right[]
		for (int i = 0; i < n; i++) {
			int len = (int) ((int) right[i] - left[i] - 1);
			answer[len] = Math.max(answer[len], arr[i]);
		}

		// Some entries in ans[] may not be filled yet. Fill
		// them by taking values from right side of ans[]
		for (int i = n - 1; i >= 1; i--) {
			answer[i] = Math.max(answer[i], answer[i + 1]);
		}

		return answer;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		long[] arr = new long[n];

		String[] arrItems = scanner.nextLine().split(" ");

		for (int i = 0; i < n; i++) {
			long arrItem = Long.parseLong(arrItems[i]);
			arr[i] = arrItem;
		}

		long[] res = riddle(arr);

		for (int i = 1; i < res.length; i++) {
			System.out.print(String.valueOf(res[i]));

			if (i != res.length - 1) {
				System.out.print(" ");
			}
		}

		scanner.close();
	}
}
