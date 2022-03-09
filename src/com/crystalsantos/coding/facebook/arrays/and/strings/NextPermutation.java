package com.crystalsantos.coding.facebook.arrays.and.strings;

/**
 * Next Permutation
 * 
 * A permutation of an array of integers is an arrangement of its members into a
 * sequence or linear order.
 * 
 * For example, for arr = [1,2,3], the following are considered permutations of
 * arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1]. The next permutation of an array of
 * integers is the next lexicographically greater permutation of its integer.
 * More formally, if all the permutations of the array are sorted in one
 * container according to their lexicographical order, then the next permutation
 * of that array is the permutation that follows it in the sorted container. If
 * such arrangement is not possible, the array must be rearranged as the lowest
 * possible order (i.e., sorted in ascending order).
 * 
 * For example, the next permutation of arr = [1,2,3] is [1,3,2]. Similarly, the
 * next permutation of arr = [2,3,1] is [3,1,2]. While the next permutation of
 * arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical
 * larger rearrangement. Given an array of integers nums, find the next
 * permutation of nums.
 * 
 * The replacement must be in place and use only constant extra memory.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3] Output: [1,3,2] Example 2:
 * 
 * Input: nums = [3,2,1] Output: [1,2,3] Example 3:
 * 
 * Input: nums = [1,1,5] Output: [1,5,1]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 100 0 <= nums[i] <= 100
 *
 */
public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums != null && nums.length > 1) {
			int p = Integer.MAX_VALUE;
			for (int i = nums.length - 1; i > 0; i--) {
				if (nums[i] > nums[i - 1]) {
					p = i - 1;
					break;
				}
			}

			if (p != Integer.MAX_VALUE) {
				int q = nums.length - 1;
				for (int i = nums.length - 1; i >= p + 1; i--) {
					if (nums[i] > nums[p]) {
						q = i;
						break;
					}
				}

				swap(nums, p, q);
				reverse(nums, p + 1, nums.length - 1);
			} else {
				reverse(nums, 0, nums.length - 1);
			}

		}
	}

	private void swap(int[] nums, int p, int q) {
		int t = nums[p];
		nums[p] = nums[q];
		nums[q] = t;
	}

	private void reverse(int[] nums, int i, int j) {
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		NextPermutation nextPermutation = new NextPermutation();
		int[] nums1 = new int[] { 1, 2, 3 };
		int[] nums2 = new int[] { 3, 2, 1 };
		int[] nums3 = new int[] { 1, 1, 5 };
		int[] nums4 = new int[] { 1, 3, 2 };
//		nextPermutation.nextPermutation(nums1);
//		nextPermutation.nextPermutation(nums2);
//		nextPermutation.nextPermutation(nums3);
		nextPermutation.nextPermutation(nums4);
		nextPermutation.print(nums1);
		nextPermutation.print(nums2);
		nextPermutation.print(nums3);
		nextPermutation.print(nums4);
	}

	private void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
}
