package com.crystalsantos.codility.facebook.sorting.and.searching;

/***
 * 
 * Find First and Last Position of Element in Sorted Array
 * 
 * 
 * 
 * Given an array of integers nums sorted in non-decreasing order, find the
 * starting and ending position of a given target value.
 * 
 * If target is not found in the array, return [-1, -1].
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1] Example 3:
 * 
 * Input: nums = [], target = 0 Output: [-1,-1]
 * 
 * 
 * Constraints:
 * 
 * 0 <= nums.length <= 105 -109 <= nums[i] <= 109 nums is a non-decreasing
 * array. -109 <= target <= 109
 * 
 * 
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[] { -1, -1 };

		if (nums == null || nums.length == 0) {
			return result;
		}

		int founded = search(0, nums.length - 1, nums, target);

		if (founded == -1) {
			return result;
		}

		int left = founded - 1;
		if (left >= 0 && left < nums.length && nums[left] == target) { // go left
			while (left >= 0 && nums[left] == target) {
				left--;
			}
			result[0] = left + 1;
		} else {
			result[0] = founded;
		}

		int right = founded + 1;
		if (right > 0 && right < nums.length && nums[right] == target) { // go rith
			while (right < nums.length && nums[right] == target) {
				right++;
			}
			result[1] = right - 1;
		} else {
			result[1] = founded;
		}

		return result;
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
		FindFirstAndLastPositionOfElementInSortedArray find = new FindFirstAndLastPositionOfElementInSortedArray();
		find.printResult(find.searchRange(new int[] { 1, 2, 3, 3, 3, 3, 4, 5, 9 }, 3)); // 2,5
		find.printResult(find.searchRange(new int[] { 1, 1, 2 }, 1)); // 0,1
		find.printResult(find.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)); // 3,4
		find.printResult(find.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6)); // -1,-1
		find.printResult(find.searchRange(new int[] {}, 0)); // -1,-1
	}

	private void printResult(int[] result) {
		System.out.print("[");

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
			if (i != result.length - 1) {
				System.out.print(" , ");
			}
		}

		System.out.print("]");
		System.out.println();

	}
}
