package com.crystalsantos.coding.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		boolean arr[] = new boolean[nums.length + 1];

		for (int i = 0; i < nums.length; i++) {
			arr[nums[i]] = true;
		}
		for (int i = 1; i <= nums.length; i++) {
			if (arr[i] == false) {
				result.add(i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		FindAllNumbersDisappearedInAnArray disappearedNumbers = new FindAllNumbersDisappearedInAnArray();
		int[] nums = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };
		List<Integer> result = disappearedNumbers.findDisappearedNumbers(nums);

		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
	}
}
