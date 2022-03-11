package com.crystalsantos.coding.dynamic.programming;

/**
 * 
 * Maximum Subarray
 * 
 * 
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * A subarray is a contiguous part of an array.
 * 
 * Example 1:
 * 
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation: [4,-1,2,1] has
 * the largest sum = 6. Example 2:
 * 
 * Input: nums = [1] Output: 1 Example 3:
 * 
 * Input: nums = [5,4,-1,7,8] Output: 23
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 -104 <= nums[i] <= 104
 * 
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution using the divide and conquer approach, which is more subtle.
 * 
 */
public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		return findBestSubArray(nums, 0, nums.length - 1);
	}

	private int findBestSubArray(int[] nums, int left, int right) {
		if (left > right) {
			return Integer.MIN_VALUE;
		}

		int mid = Math.floorDiv(left + right, 2);
		int curr = 0;
		int bestLeftSum = 0;
		int bestRightSum = 0;

		// Iterate from the middle to the beginning.
		for (int i = mid - 1; i >= left; i--) {
			curr += nums[i];
			bestLeftSum = Math.max(bestLeftSum, curr);
		}

		// Reset curr and iterate from the middle to the end.
		curr = 0;
		for (int i = mid + 1; i <= right; i++) {
			curr += nums[i];
			bestRightSum = Math.max(bestRightSum, curr);
		}

		// The bestCombinedSum uses the middle element and the best
		// possible sum from each half.
		int bestCombinedSum = nums[mid] + bestLeftSum + bestRightSum;

		// Find the best subarray possible from both halves.
		int leftHalf = findBestSubArray(nums, left, mid - 1);
		int rightHalf = findBestSubArray(nums, mid + 1, right);

		// The largest of the 3 is the answer for any given input array.
		return Math.max(bestCombinedSum, Math.max(leftHalf, rightHalf));
	}

	public int maxSubArrayBruteForce(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		int sum = 0;
		int minSum = Integer.MAX_VALUE;
		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (minSum > sum) {
				minSum = sum;
			}
			sum += nums[i];
			maxSum = Math.max(maxSum, sum - minSum);
		}
		return maxSum;
	}

	public static void main(String[] args) {
		MaximumSubarray maximum = new MaximumSubarray();
		System.out.println(maximum.maxSubArrayBruteForce(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 })); // 6
		System.out.println(maximum.maxSubArrayBruteForce(new int[] { 1 })); // 1
		System.out.println(maximum.maxSubArrayBruteForce(new int[] { 5, 4, -1, 7, 8 })); // 23
	}
}
