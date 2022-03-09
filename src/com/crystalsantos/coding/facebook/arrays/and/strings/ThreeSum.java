package com.crystalsantos.coding.facebook.arrays.and.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/***
 * 
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]] Example 2:
 * 
 * Input: nums = [] Output: [] Example 3:
 * 
 * Input: nums = [0] Output: []
 * 
 * 
 * Constraints:
 * 
 * 0 <= nums.length <= 3000 -105 <= nums[i] <= 105
 */
public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> allThreeSums = new ArrayList<>();

		if (nums.length > 0) {
			for (int i = 0; i < nums.length - 2; i++) {
				int start = i + 1, end = nums.length - 1;

				if (i == 0 || nums[i] != nums[i - 1]) {
					while (start < end) {
						if (nums[i] + nums[start] > 0) {
							break;
						}

						int currSum = nums[i] + nums[start] + nums[end];
						if (currSum == 0) {
							allThreeSums.add(Arrays.asList(nums[i], nums[start], nums[end]));
							while (start < end && nums[start] == nums[start + 1]) {
								start++;
							}
							while (start < end && nums[end] == nums[end - 1]) {
								end--;
							}
							start++;
							end--;
						} else if (currSum > 0) {
							end--;
						} else {
							start++;
						}
					}
				}
			}
		}

		return allThreeSums;
	}

	public List<List<Integer>> threeSumWithTwoSum(int[] nums) {
		List<List<Integer>> list = new LinkedList<>();
		Arrays.sort(nums);

		if (nums.length > 0) {
			for (int i = 0; i < nums.length - 2; i++) {
				if (i > 0 && nums[i] == nums[i - 1]) {
					continue; // corner case {0,0,0,0}
				}
				twoSum(list, nums, i + 1, nums.length - 1, -nums[i]);
			}
		}
		return list;
	}

	private void twoSum(List<List<Integer>> list, int[] nums, int low, int high, int target) {
		if (low > high) {
			return;
		}
		HashSet<Integer> set = new HashSet<>();
		for (int i = low; i <= high; i++) {
			if (set.contains(target - nums[i])) {
				list.add(Arrays.asList(-target, nums[i], target - nums[i]));
				while (i + 1 <= high && nums[i] == nums[i + 1]) {
					i++; // corner case {0,0,0,0}
				}
			} else {
				set.add(nums[i]);
			}
		}
	}

	public List<List<Integer>> threeSumHard(int[] nums) {
		List<List<Integer>> sums = new ArrayList<>();
		Arrays.sort(nums);

		if (nums.length > 0) {
			int previousNumber = nums[0];

			for (int i = 0; i < nums.length; i++) {
				if (i != 0 && previousNumber != nums[i]) {
					previousNumber = nums[i];
					for (int j = i + 1; j < nums.length; j++) {
						for (int k = j + 1; k < nums.length; k++) {
							if (nums[i] + nums[j] + nums[k] == 0) {
								sums.add(Arrays.asList(nums[i], nums[j], nums[k]));
							}
						}
					}
				}
			}
		}

		return sums;
	}

	public static void main(String[] args) {
		ThreeSum threeSum = new ThreeSum();
		threeSum.printResult(threeSum.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
		threeSum.printResult(threeSum.threeSum(new int[] {}));
		threeSum.printResult(threeSum.threeSum(new int[] { 0 }));
		threeSum.printResult(threeSum.threeSum(new int[] { 0, 0, 0 }));
	}

	private void printResult(List<List<Integer>> result) {
		for (List<Integer> partialResult : result) {
			for (Integer i : partialResult) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
