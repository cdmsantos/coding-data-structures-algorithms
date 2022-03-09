package com.crystalsantos.codility.facebook.sorting.and.searching;

/**
 * Search in Rotated Sorted Array
 * 
 * There is an integer array nums sorted in ascending order (with distinct
 * values).
 * 
 * Prior to being passed to your function, nums is possibly rotated at an
 * unknown pivot index k (1 <= k < nums.length) such that the resulting array is
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3
 * and become [4,5,6,7,0,1,2].
 * 
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4 Example 2:
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3 Output: -1 Example 3:
 * 
 * Input: nums = [1], target = 0 Output: -1
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 5000 -104 <= nums[i] <= 104 All values of nums are
 * unique. nums is an ascending array that is possibly rotated. -104 <= target
 * <= 104
 */
public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {

		int n = nums.length;

		if (n == 1)
			return nums[0] == target ? 0 : -1;

		int rotateIndex = findRotateIndex(nums, target, 0, n - 1);

		// if target is the smallest element
		if (nums[rotateIndex] == target) {
			return rotateIndex;
		}
		
		// if array is not rotated, search in the entire array
		if (rotateIndex == 0) {
			return search(0, n - 1, nums, target);
		}
		
		// search in the right side
		if (target < nums[0]) {
			return search(rotateIndex, n - 1, nums, target);
		}
		
		// search in the left side
		return search(0, rotateIndex, nums, target);
	}

	private int findRotateIndex(int[] nums, int target, int left, int right) {
		if (nums[left] < nums[right]) {
			return 0;
		}

		while (left <= right) {
			int pivot = (left + right) / 2;
			if (nums[pivot] > nums[pivot + 1]) {
				return pivot + 1;
			} else {
				if (nums[pivot] < nums[left]) {
					right = pivot - 1;
				} else {
					left = pivot + 1;
				}
			}
		}

		return 0;
	}

	public int search(int left, int right, int[] nums, int target) {
		/*
		 * Binary search
		 */
		while (left <= right) {
			int pivot = (left + right) / 2;
			if (nums[pivot] == target) {
				return pivot;
			} else {
				if (target < nums[pivot]) {
					right = pivot - 1;
				} else {
					left = pivot + 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		SearchInRotatedSortedArray rotated = new SearchInRotatedSortedArray();
		System.out.println(rotated.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0)); // 4
		System.out.println(rotated.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3)); // -1
		System.out.println(rotated.search(new int[] { 1 }, 3)); // -1
	}
}
