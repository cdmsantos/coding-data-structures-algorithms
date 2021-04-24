package com.crystalsantos.coding.arrays;

import java.util.Arrays;

public class HeightChecker {
	public int heightChecker(int[] heights) {
		int checker = 0;

		if (heights.length != 1) {
			int[] expected = Arrays.copyOf(heights, heights.length);
			Arrays.sort(expected);

			for (int i = 0; i < heights.length; i++) {
				if (heights[i] != expected[i]) {
					checker++;
				}
			}

		}
		return checker;
	}

	public static void main(String[] args) {
		HeightChecker heightChecker = new HeightChecker();
//		int[] heights = new int[] { 3, 1, 2, 4 }; // 3
//		int[] heights = new int[] { 1, 1, 4, 2, 1, 3 }; // 3
//		int[] heights = new int[] { 5,1,2,3,4 }; // 5
		int[] heights = new int[] { 1,2,3,4,5 }; // 0

		System.out.println(heightChecker.heightChecker(heights));
	}
}
