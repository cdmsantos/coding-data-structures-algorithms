package com.crystalsantos.coding.arrays;

public class SortArrayByParity {
	public int[] sortArrayByParity(int[] nums) {
		int rightIndex = nums.length - 1;
		int leftIndex = 0;
		while (leftIndex < nums.length && leftIndex <= rightIndex) {
			if (nums[leftIndex] % 2 != 0) { 
				if (nums[rightIndex] % 2 == 0) { 
					int temp = nums[rightIndex];
					nums[rightIndex] = nums[leftIndex];
					nums[leftIndex] = temp;
				} else {
					rightIndex--;
				}
			} else {
				leftIndex++;
			}
		}

		return nums;
	}

	public static void main(String[] args) {
		SortArrayByParity sortArray = new SortArrayByParity();
		int[] nums = new int[] { 3, 1, 2, 4 };
		int[] result = sortArray.sortArrayByParity(nums);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}
}
