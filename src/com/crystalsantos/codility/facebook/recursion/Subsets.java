package com.crystalsantos.codility.facebook.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 
 * Subsets
 * 
 * Given an integer array nums of unique elements, return all possible subsets
 * (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3] Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 * 
 * Input: nums = [0] Output: [[],[0]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 10 -10 <= nums[i] <= 10 All the numbers of nums are
 * unique.
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		if (nums == null) {
			return null;
		}

		Arrays.sort(nums);

		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			List<List<Integer>> temp = new ArrayList<>();

			// get sets that are already in result
			for (List<Integer> a : result) {
				temp.add(new ArrayList<Integer>(a));
			}

			// add S[i] to existing sets
			for (List<Integer> a : temp) {
				a.add(nums[i]);
			}

			// add S[i] only as a set
			List<Integer> single = new ArrayList<>();
			single.add(nums[i]);
			temp.add(single);

			result.addAll(temp);
		}

		// add empty set
		result.add(new ArrayList<>());

		return result;
	}

	public List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		
		if (nums == null || nums.length == 0) {
			return result;
		}
		
		helper(nums, result, new ArrayList<>(), 0);
		
		return result;
	}

	private void helper(int[] nums, List<List<Integer>> result, List<Integer> currentCombination, int index) {
		if (index == nums.length) {
			result.add(new ArrayList<>(currentCombination));
			return;
		}
		
		currentCombination.add(nums[index]);
		helper(nums, result, currentCombination, index + 1);
		currentCombination.remove(currentCombination.size() - 1);
		helper(nums, result, currentCombination, index + 1);
	}

	public static void main(String[] args) {
		Subsets subsets = new Subsets();
		subsets.run();
	}

	private void run() {
		printResult(subsets(new int[] { 1, 2, 3 }));
		printResult(subsets(new int[] { 0 }));
		printResult(subsets2(new int[] { 1, 2, 3 }));
		printResult(subsets2(new int[] { 0 }));
	}

	private void printResult(List<List<Integer>> result) {
		System.out.print("[");

		for (List<Integer> list : result) {
			System.out.print("[");

			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i));
				if (i != list.size() - 1) {
					System.out.print(" , ");
				}
			}
			System.out.print("] ");

		}

		System.out.print("]");
		System.out.println();
	}
}
