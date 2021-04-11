package com.crystalsantos.coding.stacks.queues;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class PoisonousPlants {

	static class Pair {
		int val, count;

		public Pair(int val, int count) {
			this.val = val;
			this.count = count;
		}
	}

	// Complete the poisonousPlants function below.
	static int poisonousPlants(int[] p) {
		Stack<Pair> stack = new Stack<>();
		int countDays = 0;
		for (int i = p.length - 1; i >= 0; i--) {
			int temp = 0;
			
			while (!stack.empty() && p[i] < stack.peek().val) {
				temp++;
				Pair pair = stack.pop();
				temp = Math.max(temp, pair.count);
			}
			
			countDays = Math.max(countDays, temp);
			stack.push(new Pair(p[i], temp));
		}

		return countDays;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] p = new int[n];

		String[] pItems = scanner.nextLine().split(" ");

		for (int i = 0; i < n; i++) {
			int pItem = Integer.parseInt(pItems[i]);
			p[i] = pItem;
		}

		System.out.println(poisonousPlants(p));

		scanner.close();
	}
}
