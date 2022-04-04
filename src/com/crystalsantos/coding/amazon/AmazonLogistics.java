package com.crystalsantos.coding.amazon;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AmazonLogistics {
//	public static long getTotalImbalance(List<Integer> weight) {
//		if (weight == null || weight.isEmpty() || weight.size() == 1) {
//			return 0;
//		}
//
//		if (weight.size() == 2) {
//			return Math.abs(weight.get(0) - weight.get(1));
//		}
//
//		long sumWeight = 0;
//
//		for (int i = 0; i < weight.size() - 1; i++) {
//			int minimum = weight.get(i);
//			int maximum = weight.get(i);
//			for (int j = i + 1; j < weight.size(); j++) {
//				minimum = Math.min(minimum, weight.get(j));
//				maximum = Math.max(maximum, weight.get(j));
//				sumWeight += (long) maximum - minimum;
//			}
//		}
//
//		return sumWeight;
//	}

	public static long getTotalImbalance(List<Integer> weight) {
		if (weight == null || weight.isEmpty() || weight.size() == 1) {
			return 0;
		}

		if (weight.size() == 2) {
			return Math.abs(weight.get(0) - weight.get(1));
		}

		long sumWeight = 0;

		Stack<Integer> weightStack = new Stack<>();

		for (int i = 0; i <= weight.size(); i++) {

			while (!weightStack.isEmpty() && (i == weight.size() || weight.get(weightStack.peek()) < weight.get(i))) {
				int top = weightStack.pop();
				int left = top - (weightStack.isEmpty() ? -1 : weightStack.peek());
				int right = i - top;
				sumWeight += (long) weight.get(top) * left * right;

			}
			weightStack.push(i);
		}
		
		weightStack.clear();

		for (int i = 0; i <= weight.size(); i++) {

			while (!weightStack.isEmpty() && (i == weight.size() || weight.get(weightStack.peek()) > weight.get(i))) {
				int top = weightStack.pop();
				int left = top - (weightStack.isEmpty() ? -1 : weightStack.peek());
				int right = i - top;
				sumWeight -= (long) weight.get(top) * left * right;

			}
			weightStack.push(i);
		}

		return sumWeight;
	}

	public static void main(String[] args) {
		System.out.println(AmazonLogistics.getTotalImbalance(Arrays.asList(1, 2, 3))); // 4
		System.out.println(AmazonLogistics.getTotalImbalance(Arrays.asList(3, 2, 3))); // 3
		System.out.println(AmazonLogistics.getTotalImbalance(Arrays.asList(4, 4, 4, 4, 4))); // 0
	}
}
