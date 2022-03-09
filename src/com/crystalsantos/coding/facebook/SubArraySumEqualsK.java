package com.crystalsantos.coding.facebook;

import java.util.HashMap;

/*
 * Given a sequence of positive integers nums and an integer k, return whether there is a continuous sequence of nums that sums up to exactly k.
 * Example 1:
 * 
 * Input: nums = [23, 5, 4, 7, 2, 11], k = 20
 * Output: true
 * Output: 7 + 2 + 11 = 20
 * 
 * Example 2:
 * Input: nums = [1, 3, 5, 23, 2], k = 8
 * Output: true
 * Explanation: 3 + 5 = 8
 * 
 * Example 3:
 * Input: nums = [1, 3, 5, 23, 2], k = 7
 * Output: false
 * Explanation: because no sequence in this array adds up to 7.
 * 
 * */
public class SubArraySumEqualsK {
	boolean subArraySum(int arr[], int sum) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(arr[0], arr[0]);

		for (int i = 1; i < arr.length; i++) {
			map.put(arr[i], map.get(arr[i - 1]) + arr[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			if (map.containsValue(map.get(arr[i]) - sum)) {
				return true;
			}
		}

		return false;

	}

	public static void main(String[] args) {
		SubArraySumEqualsK arraysum = new SubArraySumEqualsK();
		int arr[] = { 9, -1, 5, 23, 2 };
		int sum = 4;
		System.out.println(arraysum.subArraySum(arr, sum));
	}
}
