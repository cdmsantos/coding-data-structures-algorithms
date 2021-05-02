package com.crystalsantos.coding.dictionaries.hashmaps;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> result = new HashSet<Integer>();

		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if (nums1[i] == nums2[j]) {
					result.add(nums1[i]);
				}
			}
		}

		return result.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		IntersectionOfTwoArrays intersection = new IntersectionOfTwoArrays();

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
