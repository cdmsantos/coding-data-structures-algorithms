package com.crystalsantos.coding.amazon.sortingandsearching;

/**
 * Median of Two Sorted Arrays
 * 
 * 
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 * 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,3], nums2 = [2] Output: 2.00000 Explanation: merged array =
 * [1,2,3] and median is 2. Example 2:
 * 
 * Input: nums1 = [1,2], nums2 = [3,4] Output: 2.50000 Explanation: merged array
 * = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * 
 * 
 * Constraints:
 * 
 * nums1.length == m nums2.length == n 0 <= m <= 1000 0 <= n <= 1000 1 <= m + n
 * <= 2000 -106 <= nums1[i], nums2[i] <= 106
 */
public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		if (nums1.length == 0 && nums2.length == 0) {
			return 0;
		}

		if (nums1.length == 0 && nums2.length != 0) {
			if (nums2.length % 2 == 0) {
				return (double) (nums2[nums2.length / 2] + nums2[(nums2.length / 2) - 1]) / 2.0;
			}
			return nums2[nums2.length / 2];
		}

		if (nums1.length != 0 && nums2.length == 0) {
			if (nums1.length % 2 == 0) {
				return (double) (nums1[nums1.length / 2] + nums1[(nums1.length / 2) - 1]) / 2.0;
			}
			return nums1[nums1.length / 2];
		}

		double median = 0;

		int length = nums1.length + nums2.length;
		int current = 0;
		int nums1Index = 0;
		int nums2Index = 0;
		int[] result = new int[length];
		while (current < length) {

			if ((length % 2 == 0 && current == (length / 2) + 1)) {
				return (double) (result[length / 2] + result[(length / 2) - 1]) / 2.0;
			} else if (length % 2 != 0 && current == (length / 2) + 1) {
				return result[(length / 2)];
			}

			if (nums1Index < nums1.length && nums2Index < nums2.length) {
				if (nums1[nums1Index] <= nums2[nums2Index]) {
					result[current] = nums1[nums1Index];
					nums1Index++;
				} else {
					result[current] = nums2[nums2Index];
					nums2Index++;
				}
				current++;
			} else if (nums1Index < nums1.length) {
				for (int i = nums1Index; i < nums1.length; i++, current++) {
					result[current] = nums1[i];
				}
			} else {
				for (int i = nums2Index; i < nums2.length; i++, current++) {
					result[current] = nums2[i];
				}
			}

		}

		if (length % 2 == 0) {
			median = (double) (result[length / 2] + result[(length / 2) - 1]) / 2.0;
		} else if (length % 2 != 0) {
			median = result[(length / 2)];
		}

		return median;
	}

	public static void main(String[] args) {
		MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
		System.out.println(median.findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 })); // 2
		System.out.println(median.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 })); // 2.5
		System.out.println(median.findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2, 7 })); // 2.5
		System.out.println(median.findMedianSortedArrays(new int[] {}, new int[] { 2, 3 })); // 2.5
	}
}
