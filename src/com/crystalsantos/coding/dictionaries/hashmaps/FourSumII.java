package com.crystalsantos.coding.dictionaries.hashmaps;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				map.put(nums1[i] + nums2[j], map.getOrDefault(nums1[i] + nums2[j], 0) + 1);
			}
		}

		int ans = 0;

		for (int i = 0; i < nums3.length; i++) {
			for (int j = 0; j < nums4.length; j++) {
				ans += map.getOrDefault(-1 * (nums3[i] + nums4[j]), 0);
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		FourSumII fourSum = new FourSumII();

//		int[] nums1 = new int[] { 1, 2 };
//		int[] nums2 = new int[] { -2, -1 };
//		int[] nums3 = new int[] { -1, 2 };
//		int[] nums4 = new int[] { 0, 2 };
		int[] nums1 = new int[] { 0 };
		int[] nums2 = new int[] { 0 };
		int[] nums3 = new int[] { 0 };
		int[] nums4 = new int[] { 0 };
		System.out.println(fourSum.fourSumCount(nums1, nums2, nums3, nums4));
	}
}
