package com.crystalsantos.codility.facebook.arrays.and.strings;

/***
 * 
 * Move Zeroes
 * 
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of the array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [0,1,0,3,12] Output: [1,3,12,0,0] Example 2:
 * 
 * Input: nums = [0] Output: [0]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104 -231 <= nums[i] <= 231 - 1
 * 
 * 
 * Follow up: Could you minimize the total number of operations done?
 * 
 *
 */
public class MoveZeroes {
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
}
