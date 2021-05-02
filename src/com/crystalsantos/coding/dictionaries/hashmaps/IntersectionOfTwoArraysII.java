package com.crystalsantos.coding.dictionaries.hashmaps;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArraysII {
	public int[] intersection(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums1) {
			int value = map.getOrDefault(i, 0);
			map.put(i, value + 1);
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i : nums2) {
			if (map.containsKey(i)) {
				if (map.get(i) > 1) {
					map.put(i, map.get(i) - 1);
				} else {
					map.remove(i);
				}
				list.add(i);
			}
		}

		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		IntersectionOfTwoArraysII intersection = new IntersectionOfTwoArraysII();

//		int[] nums1 = new int[] { 1, 2, 2, 1 };
//		int[] nums2 = new int[] { 2, 2 };
		int[] nums1 = new int[] { 4, 9, 5 };
		int[] nums2 = new int[] { 9, 4, 9, 8, 4 };
		int[] result = intersection.intersection(nums1, nums2);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
