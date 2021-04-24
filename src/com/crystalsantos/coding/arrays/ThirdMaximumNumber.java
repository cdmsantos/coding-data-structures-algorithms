package com.crystalsantos.coding.arrays;

import java.util.Arrays;

public class ThirdMaximumNumber {

	public int thirdMax(int[] nums) {
		int thirdMax = 0;

		if (nums.length == 1) {
			thirdMax = nums[0];
		} else if (nums.length == 2) {
			thirdMax = Math.max(nums[0], nums[1]);
		} else {
			Arrays.sort(nums);
			thirdMax = nums[nums.length - 1];
			int max = thirdMax;
			int distinct = 1;
			for (int i = nums.length - 2; i >= 0 && distinct < 3; i--) {
				if (nums[i] != nums[i + 1]) {
					distinct++;
					thirdMax = nums[i];
					if(nums[i] > max) {
						max = nums[i];
					}
				}
			}
			
			if(distinct < 3) {
				thirdMax = max;
			}
		}

		return thirdMax;
	}

	public static void main(String[] args) {
		ThirdMaximumNumber thirdMaximumNumber = new ThirdMaximumNumber();
//		int[] nums = new int[] { 5, 2, 2 };
//		int[] nums = new int[] { 1, 2, -2147483648 };
//		int[] nums = new int[] { 1, 2, 2, 5, 3, 5 };
		int[] nums = new int[] { 1, 1, 2 };
		System.out.println(thirdMaximumNumber.thirdMax(nums));
	}
}
