package com.crystalsantos.coding.binarysearch;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {
	PriorityQueue<Integer> pq;

	int k;

	public KthLargestElementInAStream(int k, int[] nums) {
		pq = new PriorityQueue<>();
		for (int num : nums) {
			pq.add(num);
		}
		this.k = k;
	}

	public int add(int num) {
		pq.add(num);
		while (pq.size() > k) {
			pq.remove();
		}
		return pq.peek();
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 4, 5, 8, 2 };
		int k = 3;
		KthLargestElementInAStream obj = new KthLargestElementInAStream(k, nums);
		System.out.println(obj.add(3));
		System.out.println(obj.add(5));
		System.out.println(obj.add(10));
		System.out.println(obj.add(9));
		System.out.println(obj.add(4));
	}
}
