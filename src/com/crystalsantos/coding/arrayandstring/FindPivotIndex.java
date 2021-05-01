package com.crystalsantos.coding.arrayandstring;

public class FindPivotIndex {

	public int pivotIndex(int[] nums) {
		if (nums == null || nums.length < 3) {
			return -1;
		}

		int totalSum = 0;
		for (int i = 0; i < nums.length; i++) {
			totalSum += nums[i];
		}
		
		int leftSum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (leftSum == totalSum - leftSum - nums[i]) {
				return i;
			}
			leftSum += nums[i];
		}
		
		return -1;
	}

	public static void main(String[] args) {
		FindPivotIndex findPivot = new FindPivotIndex();
		int[] nums1 = new int[] { 1, 7, 3, 6, 5, 6 };
		System.out.println(findPivot.pivotIndex(nums1));
		int[] nums2 = new int[] { 1, 2, 3 };
		System.out.println(findPivot.pivotIndex(nums2));
		int[] nums3 = new int[] { 2, 1, -1 };
		System.out.println(findPivot.pivotIndex(nums3));
	}
}
