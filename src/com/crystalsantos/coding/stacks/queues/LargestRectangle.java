package com.crystalsantos.coding.stacks.queues;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class LargestRectangle {

	static int largestRectangle(int[] a) {
		int i, area = 0;
		int maxArea = 0;
		Stack<Integer> stack = new Stack<>();
		
		for (i = 0; i < a.length;) {
			if (stack.isEmpty() || a[stack.peek()] <= a[i]) {
				stack.push(i);
				i++;
			} else {
				maxArea = checkArea(stack, area, a, i, maxArea);
			}
		}

		while (!stack.isEmpty()) {
			maxArea = checkArea(stack, area, a, i, maxArea);
		}

		return maxArea;
	}
	
	private static int checkArea(Stack<Integer> stack, int area, int[] a, int i, int maxArea) {
		int x = stack.pop();

		if (stack.isEmpty()) {
			area = a[x] * i;
		} else {
			area = a[x] * (i - stack.peek() - 1);
		}

		if (area > maxArea) {
			maxArea = area;
		}
		
		return maxArea;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] h = new int[n];

		String[] hItems = scanner.nextLine().split(" ");

		for (int i = 0; i < n; i++) {
			int hItem = Integer.parseInt(hItems[i]);
			h[i] = hItem;
		}

		System.out.println(largestRectangle(h));

		scanner.close();
	}
}
