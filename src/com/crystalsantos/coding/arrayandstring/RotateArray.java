package com.crystalsantos.coding.arrayandstring;

public class RotateArray {

	public void rotate(int[] nums, int k) {
		if (nums == null || k == 0 || nums.length == 0 || nums.length == 1) {
			return;
		}

		int offset = k % nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, offset - 1);
		reverse(nums, offset, nums.length - 1);
	}

	private void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		RotateArray rotateArray = new RotateArray();
		int[] nums = new int[] { -1, -100, 3, 99 };
		rotateArray.rotate(nums, 2);
//		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7};
//		rotateArray.rotate(nums, 3);
//		int[] nums = new int[] { 1, 2 };
//		rotateArray.rotate(nums, 1);
//		int[] nums = new int[] { 1, 2, 3 };
//		rotateArray.rotate(nums, 2);

		for (int j = 0; j < nums.length; j++) {
			System.out.print(nums[j] + " ");
		}
	}
}
