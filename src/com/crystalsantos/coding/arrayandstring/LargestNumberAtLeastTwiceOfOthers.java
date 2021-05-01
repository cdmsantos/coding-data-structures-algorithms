package com.crystalsantos.coding.arrayandstring;

public class LargestNumberAtLeastTwiceOfOthers {
	public int dominantIndex(int[] nums) {
		if (nums == null) {
			return -1;
		}

		if (nums != null && nums.length == 1) {
			return 0;
		}

		int maxValue = Integer.MIN_VALUE;
		int maxIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > maxValue) {
				maxValue = nums[i];
				maxIndex = i;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (i != maxIndex && nums[i] > maxValue / 2) {
				return -1;
			}
		}

		return maxIndex;
	}

	public static void main(String[] args) {
		LargestNumberAtLeastTwiceOfOthers dominant = new LargestNumberAtLeastTwiceOfOthers();

		int[] nums1 = new int[] { 3, 6, 1, 0 };
		System.out.println(dominant.dominantIndex(nums1));

		int[] nums2 = new int[] { 1, 2, 3, 4 };
		System.out.println(dominant.dominantIndex(nums2));

		int[] nums3 = new int[] { 1 };
		System.out.println(dominant.dominantIndex(nums3));
	}
}
