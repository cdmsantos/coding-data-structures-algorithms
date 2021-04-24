package com.crystalsantos.coding.arrays;

public class ValidMountainArray {
	public boolean validMountainArray(int[] nums) {
		if (nums == null || nums.length < 3) {
			return false;
		} else {
			int index = 0;
			int size = nums.length;

			while (index + 1 < size && nums[index] < nums[index + 1]) {
				index++;
			}

			if (index == 0 || index == size - 1) {
				return false;
			}

			while (index + 1 < size && nums[index] > nums[index + 1]) {
				index++;
			}

			return index == size - 1;
		}
	}

	public static void main(String[] args) {
		ValidMountainArray validMountain = new ValidMountainArray();
		int[] nums = new int[] { 0, 3, 2, 1 }; // true
//		int[] nums = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 }; //false
//		int[] nums = new int[] { 4, 4, 3, 2, 1 }; //false
//		int[] nums = new int[] { 2, 1 }; //false
//		int[] nums = new int[] { 3, 5, 5 }; // false
//		int[] nums = new int[] { 1, 3, 2 }; //true
//		int[] nums = new int[] { 1, 1, 1, 1, 1, 1, 1, 2, 1 }; // false
//		int[] nums = new int[] { 0, 2, 3, 3, 5, 2, 1, 0}; // false
		System.out.println(validMountain.validMountainArray(nums));
	}
}
