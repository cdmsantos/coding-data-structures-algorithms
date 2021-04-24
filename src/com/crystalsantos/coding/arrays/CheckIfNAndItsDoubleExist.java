package com.crystalsantos.coding.arrays;

import java.util.Arrays;

public class CheckIfNAndItsDoubleExist {
	public boolean checkIfExist(int[] arr) {
		if (arr == null || arr.length == 0 || arr.length == 1) {
			return false;
		} else {
			Arrays.sort(arr);

			for (int i = 0; i < arr.length; i++) {
				if (binarySearch(arr, 0, arr.length - 1, arr[i] * 2, i)) {
					return true;
				}
			}
			return false;
		}
	}

	public boolean binarySearch(int[] arr, int start, int end, int i, int position) {
		if (end >= start) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == i && mid != position) {
				return true;
			} else {
				if (arr[mid] > i) {
					return binarySearch(arr, start, mid - 1, i, position);
				}

				return binarySearch(arr, mid + 1, end, i, position);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		CheckIfNAndItsDoubleExist exists = new CheckIfNAndItsDoubleExist();
//		int[] nums = new int[] { 10, 2, 5, 3 };
//		int[] nums = new int[] { 7, 1, 14, 11 };
//		int[] nums = new int[] { 3, 1, 7, 11 };
//		int[] nums = new int[] { -2, 0, 10, -19, 4, 6, -8 };
		int[] nums = new int[] { 0, 0 };
		System.out.println(exists.checkIfExist(nums));
	}
}
