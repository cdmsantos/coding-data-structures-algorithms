package com.crystalsantos.coding.amazon.arraysandstring;

import java.util.Stack;

/**
 * Trapping Rain Water
 * 
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it can trap after raining.
 * 
 * Example 1:
 * 
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6 Explanation: The above
 * elevation map (black section) is represented by array
 * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section)
 * are being trapped. Example 2:
 * 
 * Input: height = [4,2,0,3,2,5] Output: 9
 * 
 * 
 * Constraints:
 * 
 * n == height.length 1 <= n <= 2 * 104 0 <= height[i] <= 105
 */
public class TrappingRainWater {
	public int trap(int[] height) {
		int trappedWater = 0, currentHeight = 0;

		Stack<Integer> stack = new Stack<>();
		while (currentHeight < height.length) {
			while (!stack.empty() && height[currentHeight] > height[stack.peek()]) {
				int top = stack.pop();
				if (stack.empty()) {
					break;
				}
				int distance = currentHeight - stack.peek() - 1;
				int boundedHeight = Math.min(height[currentHeight], height[stack.peek()]) - height[top];
				trappedWater += distance * boundedHeight;
			}
			stack.push(currentHeight++);
		}
		return trappedWater;

	}

	public int trap2(int[] height) {
		int leftMax = 0, rightMax = 0, left = 0, right = height.length - 1;
		int ans = 0;

		while (left < right) {
			if (height[left] < height[right]) {
				if (height[left] > leftMax) {
					leftMax = height[left];

				} else {
					ans += leftMax - height[left];
				}

				left++;
			} else {
				if (height[right] > rightMax) {
					rightMax = height[right];

				} else {
					ans += rightMax - height[right];
				}
				right--;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		TrappingRainWater trappingRain = new TrappingRainWater();
		System.out.println(trappingRain.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 })); // 6
		System.out.println(trappingRain.trap(new int[] { 4, 2, 0, 3, 2, 5 }));// 9
		System.out.println(trappingRain.trap2(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 })); // 6
		System.out.println(trappingRain.trap2(new int[] { 4, 2, 0, 3, 2, 5 }));// 9
	}
}
