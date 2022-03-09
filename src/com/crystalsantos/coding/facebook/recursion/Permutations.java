package com.crystalsantos.coding.facebook.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Permutations
 * 
 * 
 * Given an array nums of distinct integers, return all the possible
 * permutations. You can return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3] Output:
 * [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]] Example 2:
 * 
 * Input: nums = [0,1] Output: [[0,1],[1,0]] Example 3:
 * 
 * Input: nums = [1] Output: [[1]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 6 -10 <= nums[i] <= 10 All the integers of nums are
 * unique.
 *
 */
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new LinkedList<>();
		if (nums != null && nums.length > 0) {
			List<Integer> numsList = new ArrayList<>();
			for (int num : nums) {
				numsList.add(num);
			}

			int n = nums.length;
			backtrack(n, numsList, result, 0);
		}
		return result;
	}

	/*
	 * 
	 * If the first integer to consider has index n that means that the current
	 * permutation is done.
	 * 
	 * Iterate over the integers from index first to index n - 1: 1) Place i-th
	 * integer first in the permutation, i.e. swap(nums[first], nums[i]). 2) Proceed
	 * to create all permutations which starts from i-th integer : 3)
	 * backtrack(first + 1). Now backtrack, i.e. swap(nums[first], nums[i]) back.
	 * 
	 */
	private void backtrack(int length, List<Integer> numsList, List<List<Integer>> result, int current) {
		if (current == length) {
			result.add(new ArrayList<Integer>(numsList));
		}
		for (int i = current; i < length; i++) {
			Collections.swap(numsList, current, i);
			backtrack(length, numsList, result, current + 1);
			// backtrack
			Collections.swap(numsList, current, i);
		}
	}

	public static void main(String[] args) {
		Permutations permutations = new Permutations();
		permutations.run();
	}

	private void run() {
		printResult(permute(new int[] { 1, 2, 3 }));
		printResult(permute(new int[] { 0, 1 }));
		printResult(permute(new int[] { 1 }));
	}

	private void printResult(List<List<Integer>> result) {
		System.out.print("[");

		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
			if (i != result.size() - 1) {
				System.out.print(" , ");
			}
		}

		System.out.print("]");
		System.out.println();
	}
}
