package com.crystalsantos.coding.design;

import java.util.Random;

/**
 * 
 * Shuffle an Array
 * 
 * Given an integer array nums, design an algorithm to randomly shuffle the
 * array. All permutations of the array should be equally likely as a result of
 * the shuffling.
 * 
 * Implement the Solution class:
 * 
 * Solution(int[] nums) Initializes the object with the integer array nums.
 * int[] reset() Resets the array to its original configuration and returns it.
 * int[] shuffle() Returns a random shuffling of the array.
 * 
 * 
 * Example 1:
 * 
 * Input ["Solution", "shuffle", "reset", "shuffle"] [[[1, 2, 3]], [], [], []]
 * Output [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 * 
 * Explanation Solution solution = new Solution([1, 2, 3]); solution.shuffle();
 * // Shuffle the array [1,2,3] and return its result. // Any permutation of
 * [1,2,3] must be equally likely to be returned. // Example: return [3, 1, 2]
 * solution.reset(); // Resets the array back to its original configuration
 * [1,2,3]. Return [1, 2, 3] solution.shuffle(); // Returns the random shuffling
 * of array [1,2,3]. Example: return [1, 3, 2]
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 200 -106 <= nums[i] <= 106 All the elements of nums are
 * unique. At most 5 * 104 calls in total will be made to reset and shuffle.
 * 
 */
public class ShuffleAnArray {
	Random rand = new Random();
	
	int[] original;
	int[] nums;

	public ShuffleAnArray(int[] nums) {
		this.nums = nums;

		original = new int[nums.length];
		setArray(nums, original);
	}

	public int[] reset() {
		setArray(original, nums);
		return nums;
	}

	public int[] shuffle() {
		for (int i = 0; i < nums.length; i++) {
            swapAt(i, rand.nextInt(nums.length - i) + i);
        }
        return nums;
	}

	private void setArray(int[] from, int[] to) {
		for (int i = 0; i < from.length; i++) {
			to[i] = from[i];
		}
	}

    private void swapAt(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

	public static void main(String[] args) {
		ShuffleAnArray shuffle = new ShuffleAnArray(new int[] { 1, 2 });
		shuffle.shuffle();
		shuffle.printResult();
		shuffle.reset();
		shuffle.printResult();
		shuffle.shuffle();
		shuffle.printResult();
	}

	private void printResult() {
		System.out.print("[");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			if (i != nums.length - 1) {
				System.out.print(" , ");
			}
		}
		System.out.print("]");
		System.out.println();
	}
}
