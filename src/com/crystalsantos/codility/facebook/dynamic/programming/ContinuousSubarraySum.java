package com.crystalsantos.codility.facebook.dynamic.programming;

import java.util.HashMap;

/****
 * 
 * Continuous Subarray Sum
 * 
 * 
 * Given an integer array nums and an integer k, return true if nums has a
 * continuous subarray of size at least two whose elements sum up to a multiple
 * of k, or false otherwise.
 * 
 * An integer x is a multiple of k if there exists an integer n such that x = n
 * * k. 0 is always a multiple of k.
 * 
 * Example 1:
 * 
 * Input: nums = [23,2,4,6,7], k = 6 Output: true Explanation: [2, 4] is a
 * continuous subarray of size 2 whose elements sum up to 6. Example 2:
 * 
 * Input: nums = [23,2,6,4,7], k = 6 Output: true Explanation: [23, 2, 6, 4, 7]
 * is an continuous subarray of size 5 whose elements sum up to 42. 42 is a
 * multiple of 6 because 42 = 7 * 6 and 7 is an integer. Example 3:
 * 
 * Input: nums = [23,2,6,4,7], k = 13 Output: false
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 0 <= nums[i] <= 109 0 <= sum(nums[i]) <= 231 - 1 1 <=
 * k <= 231 - 1
 * 
 */
public class ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
		if (k == 0 || nums == null || nums.length == 0 || nums.length == 1) {
			return false;
		}

		HashMap<Integer, Integer> hashmap = new HashMap<>();
		int currSum = 0;
		hashmap.put(currSum, -1);

		for (int i = 0; i < nums.length; i++) {
			currSum += nums[i];

			if (hashmap.containsKey(currSum % k)) {
				if (i - hashmap.get(currSum % k) >= 2) {
					return true;
				}
			} else {
				hashmap.put(currSum % k, i);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		ContinuousSubarraySum sum = new ContinuousSubarraySum();
		System.out.println(sum.checkSubarraySum(new int[] { 23, 2, 4, 6, 7 }, 6)); // true (2+4)
		System.out.println(sum.checkSubarraySum(new int[] { 23, 2, 6, 4, 7 }, 6)); // true (all elements = 42)
		System.out.println(sum.checkSubarraySum(new int[] { 23, 2, 6, 4, 7 }, 13)); // false
		System.out.println(sum.checkSubarraySum(new int[] { 5, 0, 0, 0 }, 3)); // true
		System.out.println(sum.checkSubarraySum(new int[] { 2, 4, 3 }, 6)); // true
		System.out.println(sum.checkSubarraySum(new int[] { 1, 2, 3 }, 5)); // true
	}
}
