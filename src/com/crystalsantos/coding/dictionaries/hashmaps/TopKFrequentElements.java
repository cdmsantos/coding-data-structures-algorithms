package com.crystalsantos.coding.dictionaries.hashmaps;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
	public int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[k];

		for (int i = 0; i < nums.length; i++) {
			int value = map.getOrDefault(nums[i], 0);
			map.put(nums[i], value + 1);
		}

		Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));

		for (int n : map.keySet()) {
			heap.add(n);
			if (heap.size() > k) {
				heap.poll();
			}
		}

		for (int i = k - 1; i >= 0; --i) {
			result[i] = heap.poll();
		}
		return result;
	}

	private void printResult(int[] result) {
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		TopKFrequentElements topKElements = new TopKFrequentElements();

		int[] nums1 = new int[] { 1, 1, 1, 2, 2, 3 };
		int k1 = 2;
		int[] result1 = topKElements.topKFrequent(nums1, k1);
		topKElements.printResult(result1);

		int[] nums2 = new int[] { 1 };
		int k2 = 1;
		int[] result2 = topKElements.topKFrequent(nums2, k2);
		topKElements.printResult(result2);
	}
}
