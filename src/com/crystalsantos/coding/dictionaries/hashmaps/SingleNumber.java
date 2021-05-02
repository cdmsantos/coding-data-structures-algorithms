package com.crystalsantos.coding.dictionaries.hashmaps;

import java.util.Arrays;

public class SingleNumber {
	public int singleNumber(int[] nums) {

		if (nums.length == 1) {
			return nums[0];
		}

		Arrays.sort(nums);

		for (int i = 1; i < nums.length; i = i + 2) {
			if (nums[i] != nums[i - 1]) {
				return nums[i - 1];
			}
		}

		return nums[nums.length - 1];
	}

	public static void main(String[] args) {
		SingleNumber singleNumber = new SingleNumber();

		int[] nums1 = new int[] { 2, 2, 1 };
		System.out.println(singleNumber.singleNumber(nums1));

		int[] nums2 = new int[] { 4, 1, 2, 1, 2 };
		System.out.println(singleNumber.singleNumber(nums2));

		int[] nums3 = new int[] { 1 };
		System.out.println(singleNumber.singleNumber(nums3));
	}
}
