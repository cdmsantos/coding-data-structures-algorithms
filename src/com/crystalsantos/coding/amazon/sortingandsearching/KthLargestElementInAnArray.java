package com.crystalsantos.coding.amazon.sortingandsearching;

import java.util.Arrays;

/**
 * Kth Largest Element in an Array
 * 
 * Given an integer array nums and an integer k, return the kth largest element
 * in the array.
 * 
 * Note that it is the kth largest element in the sorted order, not the kth
 * distinct element.
 * 
 * Example 1:
 * 
 * Input: nums = [3,2,1,5,6,4], k = 2 Output: 5 Example 2:
 * 
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4 Output: 4
 * 
 * 
 * Constraints:
 * 
 * 1 <= k <= nums.length <= 104 -104 <= nums[i] <= 104
 */
public class KthLargestElementInAnArray {

	public int findKthLargest(int[] nums, int k) {
		int kth = 0, current = 1;

		if (k > nums.length) {
			return kth;
		}

		Arrays.sort(nums);
		for (int i = nums.length - 1; i >= 0; i--, current++) {
			if (current == k) {
				kth = nums[i];
				break;
			}
		}

		return kth;
	}

	public static void main(String[] args) {
		KthLargestElementInAnArray kthLargest = new KthLargestElementInAnArray();
		System.out.println(kthLargest.findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2)); // 5
		System.out.println(kthLargest.findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4)); // 4
	}
}
