package com.crystalsantos.codility.facebook.sorting.and.searching;

/***
 * 
 * Find Peak Element
 * 
 * 
 * A peak element is an element that is strictly greater than its neighbors.
 * 
 * Given an integer array nums, find a peak element, and return its index. If
 * the array contains multiple peaks, return the index to any of the peaks.
 * 
 * You may imagine that nums[-1] = nums[n] = -∞.
 * 
 * You must write an algorithm that runs in O(log n) time.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1] Output: 2 Explanation: 3 is a peak element and your
 * function should return the index number 2. Example 2:
 * 
 * Input: nums = [1,2,1,3,5,6,4] Output: 5 Explanation: Your function can return
 * either index number 1 where the peak element is 2, or index number 5 where
 * the peak element is 6.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 1000 -231 <= nums[i] <= 231 - 1 nums[i] != nums[i + 1]
 * for all valid i.
 * 
 */
public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		int peak = 0;
		if (nums == null || nums.length == 0) {
			return peak;
		}

		int left = 0, right = nums.length - 1;
		while (left < right) {
			int middle = (left + right) / 2;
			if (nums[middle] > nums[middle + 1]) {
				right = middle;
			} else {
				left = middle + 1;
			}
		}
		return left;

//		return search(nums, 0, nums.length - 1);
	}

	public int search(int[] nums, int left, int right) {
		if (left == right) {
			return left;
		}
		int mid = (left + right) / 2;

		if (nums[mid] > nums[mid + 1]) {
			return search(nums, left, mid);
		}
		return search(nums, mid + 1, right);
	}

	public static void main(String[] args) {
		FindPeakElement peak = new FindPeakElement();
		System.out.println(peak.findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 })); // 5 or 1
		System.out.println(peak.findPeakElement(new int[] { 1, 2, 3, 1 })); // 2
	}
}
