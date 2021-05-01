package com.crystalsantos.coding.arrayandstring;

import java.util.Arrays;

public class ArrayPartitionI {
	public int arrayPairSum(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		Arrays.sort(nums);

		int sum = 0;
		for (int i = 0; i < nums.length; i = i + 2) {
			sum += Math.min(nums[i], nums[i + 1]);
		}

		return sum;
	}

	public static void main(String[] args) {
		ArrayPartitionI partition = new ArrayPartitionI();

		int[] nums1 = new int[] { 1, 4, 3, 2 };
		System.out.println(partition.arrayPairSum(nums1));

		int[] nums2 = new int[] { 6, 2, 6, 5, 1, 2 };
		System.out.println(partition.arrayPairSum(nums2));
	}
}
