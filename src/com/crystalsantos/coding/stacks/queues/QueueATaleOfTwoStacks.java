package com.crystalsantos.coding.stacks.queues;

import java.util.Scanner;
import java.util.Stack;

public class QueueATaleOfTwoStacks {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfQueries = scanner.nextInt();

		Stack<Integer> one = new Stack<Integer>();
		Stack<Integer> two = new Stack<Integer>();

		for (int i = 0; i < numberOfQueries; i++) {
			int option = scanner.nextInt();
			if (option == 1) { //enqueue
				one.push(scanner.nextInt());
			} else if (option == 2) { //dequeue
				if (two.isEmpty()) {
					while (!one.isEmpty()) {
						two.push(one.pop());
					}
				}

				if (!two.isEmpty()) {
					two.pop();
				}
			} else { //print the element in front of the queue
				if (two.isEmpty()) {
					while (!one.isEmpty()) {
						two.push(one.pop());
					}
					System.out.println(two.peek());
				} else {
					System.out.println(two.peek());
				}
			}

		}
		scanner.close();
	}
}
