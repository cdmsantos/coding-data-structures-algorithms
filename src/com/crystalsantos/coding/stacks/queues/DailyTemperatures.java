package com.crystalsantos.coding.stacks.queues;

import java.util.Stack;

public class DailyTemperatures {
	public int[] dailyTemperatures(int[] temperatures) {
		int[] ret = new int[temperatures.length];
		if (temperatures.length == 0)
			return ret;

		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < temperatures.length; ++i) {
			while (!st.empty() && temperatures[i] > temperatures[st.peek()]) {
				int index = st.pop();
				ret[index] = i - index;
			}
			st.push(i);
		}
		
		while (!st.empty()) {
			ret[st.pop()] = 0;
		}
		
		return ret;
	}

	public static void main(String[] args) {
		DailyTemperatures daily = new DailyTemperatures();
		int[] temperatures = new int[] { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] result = daily.dailyTemperatures(temperatures);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
