package com.crystalsantos.coding.arrays;

/**
 * 
 * Max Consecutive Ones II
 * 
 * Given a binary array nums, return the maximum number of consecutive 1's in
 * the array if you can flip at most one 0.
 * 
 * Example 1:
 * 
 * Input: nums = [1,0,1,1,0] Output: 4 Explanation: Flip the first zero will get
 * the maximum number of consecutive 1s. After flipping, the maximum number of
 * consecutive 1s is 4. Example 2:
 * 
 * Input: nums = [1,0,1,1,0,1] Output: 4
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 nums[i] is either 0 or 1.
 * 
 * 
 * Follow up: What if the input numbers come in one by one as an infinite
 * stream? In other words, you can't store all numbers coming from the stream as
 * it's too large to hold in memory. Could you solve it efficiently?
 */
public class MaxConsecutiveOnesII {
	public int findMaxConsecutiveOnes(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return 1;
		}

		int max = 0, ones = 0;
		boolean foundZero = false;
		int afterZero = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1 && foundZero) {
				afterZero++;
				ones++;
			} else if (nums[i] == 1) {
				ones++;
			} else {
				if (!foundZero) {
					foundZero = true;
					afterZero = 0;
					ones++;
				} else {
					max = Math.max(max, ones);
					ones = afterZero + 1;
					foundZero = true;
					afterZero = 0;
				}
			}
		}

		return Math.max(max, ones);
	}

	public static void main(String[] args) {
		MaxConsecutiveOnesII max = new MaxConsecutiveOnesII();
		System.out.println(max.findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1 })); // 4
		System.out.println(max.findMaxConsecutiveOnes(new int[] { 1, 0, 1, 1, 0 })); // 4
		System.out.println(max.findMaxConsecutiveOnes(new int[] { 1, 0, 1, 1, 0, 1 })); // 4
		System.out.println(max.findMaxConsecutiveOnes(new int[] { 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 })); // 8
	}
}
