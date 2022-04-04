package com.crystalsantos.coding.amazon.arraysandstring;

/**
 * Container With Most Water
 * 
 * You are given an integer array height of length n. There are n vertical lines
 * drawn such that the two endpoints of the ith line are (i, 0) and (i,
 * height[i]).
 * 
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 * 
 * Notice that you may not slant the container.
 * 
 * Example 1:
 * 
 * 
 * Input: height = [1,8,6,2,5,4,8,3,7] Output: 49 Explanation: The above
 * vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case,
 * the max area of water (blue section) the container can contain is 49. Example
 * 2:
 * 
 * Input: height = [1,1] Output: 1
 * 
 * 
 * Constraints:
 * 
 * n == height.length 2 <= n <= 105 0 <= height[i] <= 104
 */
public class ContainerWithMostWater {

	public int maxArea(int[] height) {

		if (height.length == 2) {
			return height[0] < height[1] ? height[0] : height[1];
		}

		int max = 0;

		// brute force
//		for (int i = 0; i < height.length; i++) {
//			for (int j = i + 1; j < height.length; j++) {
//				int tempArea = height[i] <= height[j] ? (j - i) * height[i] : (j - i) * height[j];
//				max = max < tempArea ? tempArea : max;
//			}
//		}

		int l = 0, r = height.length - 1;
		while (l < r) {
			max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		ContainerWithMostWater water = new ContainerWithMostWater();
		System.out.println(water.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 })); // 49
		System.out.println(water.maxArea(new int[] { 1, 1 })); // 1
	}
}
