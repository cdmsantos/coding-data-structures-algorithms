package com.crystalsantos.coding.dictionaries.hashmaps;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums.length == 0 || nums == null)
			return false;

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(nums[i]) == null) {
				map.put(nums[i], i);
			} else {
				int index = map.get(nums[i]);
				if (i - index <= k) {
					return true;
				} else {
					map.put(nums[i], i);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ContainsDuplicateII duplicate = new ContainsDuplicateII();

		int[] nums1 = new int[] { 1, 2, 3, 1 };
		System.out.println(duplicate.containsNearbyDuplicate(nums1, 3));

		int[] nums2 = new int[] { 1, 0, 1, 1 };
		System.out.println(duplicate.containsNearbyDuplicate(nums2, 1));

		int[] nums3 = new int[] { 1, 2, 3, 1, 2, 3 };
		System.out.println(duplicate.containsNearbyDuplicate(nums3, 2));
	}
}
