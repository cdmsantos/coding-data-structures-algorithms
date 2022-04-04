package com.crystalsantos.coding.amazon.arraysandstring;

import java.util.Arrays;

/**
 * 3Sum Closest
 * 
 * Given an integer array nums of length n and an integer target, find three
 * integers in nums such that the sum is closest to target.
 * 
 * Return the sum of the three integers.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Example 1:
 * 
 * Input: nums = [-1,2,1,-4], target = 1 Output: 2 Explanation: The sum that is
 * closest to the target is 2. (-1 + 2 + 1 = 2). Example 2:
 * 
 * Input: nums = [0,0,0], target = 1 Output: 0
 * 
 * Constraints:
 * 
 * 3 <= nums.length <= 1000 -1000 <= nums[i] <= 1000 -104 <= target <= 104
 * 
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);

		int diff = Integer.MAX_VALUE;
		int size = nums.length;
		Arrays.sort(nums);
		for (int i = 0; i < size && diff != 0; ++i) {
			int lo = i + 1;
			int hi = size - 1;
			while (lo < hi) {
				int sum = nums[i] + nums[lo] + nums[hi];
				if (Math.abs(target - sum) < Math.abs(diff)) {
					diff = target - sum;
				}
				if (sum < target) {
					++lo;
				} else {
					--hi;
				}
			}
		}
		return target - diff;
	}
}
