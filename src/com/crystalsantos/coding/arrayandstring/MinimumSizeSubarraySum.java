package com.crystalsantos.coding.arrayandstring;

public class MinimumSizeSubarraySum {

	public int minSubArrayLen(int target, int[] nums) {
		if (nums == null || nums.length == 0 || (nums.length == 1 && nums[0] != target)) {
			return 0;
		}

		int result = nums.length;

		int start = 0;
		int sum = 0;
		int i = 0;
		boolean exists = false;

		while (i <= nums.length) {
			if (sum >= target) {
				exists = true;
				if (start == i - 1) {
					return 1;
				}

				result = Math.min(result, i - start);
				sum = sum - nums[start];
				start++;

			} else {
				if (i == nums.length) {
					break;
				}
				sum = sum + nums[i];
				i++;
			}
		}

		if (exists) {
			return result;
		}
		return 0;
	}

	public static void main(String[] args) {
		MinimumSizeSubarraySum minimumSize = new MinimumSizeSubarraySum();

//		int[] nums1 = new int[] { 2, 3, 1, 2, 4, 3 };
//		System.out.println(minimumSize.minSubArrayLen(7, nums1));
//
//		int[] nums2 = new int[] { 2, 3, 1, 2, 4, 3 };
//		System.out.println(minimumSize.minSubArrayLen(4, nums2));

		int[] nums3 = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(minimumSize.minSubArrayLen(11, nums3));
	}

}
