package com.crystalsantos.coding.arrays;

public class MoveZeroes {

	//if order matters
	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return;
		}

		int writeIndex = getWriteIndexPosition(0, nums);

		for (int readIndex = writeIndex + 1; readIndex < nums.length && writeIndex < nums.length; readIndex++) {
			if (nums[readIndex] != 0) {
				nums[writeIndex] = nums[readIndex];
				nums[readIndex] = 0;
				writeIndex = getWriteIndexPosition(writeIndex + 1, nums);
			}
		}
	}

	private int getWriteIndexPosition(int start, int[] nums) {

		while (start < nums.length) {
			if (nums[start] == 0) {
				break;
			}

			start++;
		}

		return start;
	}

	//if order doesn't matters (less operations)
//	public void moveZeroes(int[] nums) {
//		int writeIndex = getWriteIndexPosition(nums.length - 1, nums);
//		int readIndex = 0;
//
//		while (readIndex < nums.length && readIndex <= writeIndex) {
//
//			if (nums[readIndex] == 0 && nums[writeIndex] != 0) {
//				nums[readIndex] = nums[writeIndex];
//				nums[writeIndex] = 0;
//				writeIndex = getWriteIndexPosition(writeIndex - 1, nums);
//			}
//
//			readIndex++;
//		}
//	}
//
//	private int getWriteIndexPosition(int start, int[] nums) {
//
//		while (start >= 0) {
//			if (nums[start] != 0) {
//				break;
//			}
//
//			start--;
//		}
//
//		return start;
//	}

	public static void main(String[] args) {
		MoveZeroes moveZeroes = new MoveZeroes();
//		int[] nums = new int[] { 0, 1, 0, 3, 12 };
//		int[] nums = new int[] { 0 };
		int[] nums = new int[] { 4, 2, 4, 0, 0, 3, 0, 5, 1, 0 };
		moveZeroes.moveZeroes(nums);

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
