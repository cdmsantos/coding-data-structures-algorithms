package com.crystalsantos.coding.dictionaries.hashmaps;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		if (nums.length == 2) {
			return new int[] { 0, 1 };
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[] {-1, -1};

		for (int i = 0; i < nums.length; i++) {
			map.put(i, nums[i]);
		}

		Map<Integer, Integer> mapTemp = new HashMap<Integer, Integer>();
		mapTemp.putAll(map);

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			mapTemp.remove(entry.getKey());
			if (result[1] != -1) {
				if (entry.getValue() + map.get(result[1]) == target) {
					result[0] = entry.getKey();
					break;
				}
			} else {
				if (mapTemp.containsValue(target - entry.getValue())) {
					result[1] = entry.getKey();
				} else {
					mapTemp.put(entry.getKey(), entry.getValue());
				}
			}
		}

		return result;
	}

	private void printResult(int[] result) {
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		TwoSum sum = new TwoSum();

		int[] nums1 = new int[] { 2, 7, 11, 15 };
		int[] result1 = sum.twoSum(nums1, 9); // [0,1]
		sum.printResult(result1);

		int[] nums2 = new int[] { 3, 2, 4 };
		int[] result2 = sum.twoSum(nums2, 6); // [1,2]
		sum.printResult(result2);

		int[] nums3 = new int[] { 3, 3 };
		int[] result3 = sum.twoSum(nums3, 6); // [0,1]
		sum.printResult(result3);

		int[] nums4 = new int[] { -1, -2, -3, -4, -5 };
		int[] result4 = sum.twoSum(nums4, -8); // [2,4]
		sum.printResult(result4);

		int[] nums5 = new int[] { 1, 3, 4, 2 };
		int[] result5 = sum.twoSum(nums5, 6); // [2,3]
		sum.printResult(result5);
	}
}
