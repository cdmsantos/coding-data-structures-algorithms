package com.crystalsantos.codility.facebook.arrays.and.strings;

import java.util.HashMap;

/***
 * 
 * Subarray Sum Equals K
 * 
 * 
 * Given an array of integers nums and an integer k, return the total number of
 * subarrays whose sum equals to k.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,1], k = 2 Output: 2 Example 2:
 * 
 * Input: nums = [1,2,3], k = 3 Output: 2
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 2 * 104 -1000 <= nums[i] <= 1000 -107 <= k <= 107
 * 
 * 
 *
 */
public class SubArraySumEqualsK {

	public int subarraySum(int[] nums, int k) {
		int count = 0, sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		SubArraySumEqualsK sum = new SubArraySumEqualsK();
		System.out.println(sum.subarraySum(new int[] { 1, 1, 1 }, 2)); // 2
		System.out.println(sum.subarraySum(new int[] { 1, 2, 3 }, 3)); // 2
	}
}
