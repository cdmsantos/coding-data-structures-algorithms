package com.crystalsantos.coding.dynamic.programming;

/***
 * House Robber
 * 
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security systems
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the
 * police.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1] Output: 4 Explanation: Rob house 1 (money = 1) and
 * then rob house 3 (money = 3). Total amount you can rob = 1 + 3 = 4. Example
 * 2:
 * 
 * Input: nums = [2,7,9,3,1] Output: 12 Explanation: Rob house 1 (money = 2),
 * rob house 3 (money = 9) and rob house 5 (money = 1). Total amount you can rob
 * = 2 + 9 + 1 = 12.
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 100 0 <= nums[i] <= 400
 */
public class HouseRobber {
	public int robDynamicProgramming(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		int[] maxRobbedAmount = new int[nums.length + 1];

		// Base case initializations.
		maxRobbedAmount[nums.length] = 0;
		maxRobbedAmount[nums.length - 1] = nums[nums.length - 1];

		// DP table calculations.
		for (int i = nums.length - 2; i >= 0; --i) {
			// Same as the recursive solution.
			maxRobbedAmount[i] = Math.max(maxRobbedAmount[i + 1], maxRobbedAmount[i + 2] + nums[i]);
		}

		return maxRobbedAmount[0];
	}

	// You can keep track of two values: currMax and prevMax. While prevMax is max
	// money excluding the previous house, currMax is max money considering the
	// previous house. Since prevMax is guaranteed that money from previous house
	// is not included, you can add money from current house to prevMax and compare
	// it with currMax to find total max money up to that point. Here is my solution
	// using dp, O(n) time complexity and O(1) space complexity:
	public int rob(int[] nums) {
		int currmax = 0;
		int prevmax = 0;

		for (int i = 0; i < nums.length; i++) {
			int iSum = prevmax + nums[i];
			prevmax = currmax;
			currmax = Math.max(currmax, iSum);
		}
		return currmax;
	}

	public static void main(String[] args) {
		HouseRobber robber = new HouseRobber();
		System.out.println(robber.rob(new int[] { 1, 2, 3, 1 })); // 4
		System.out.println(robber.rob(new int[] { 2, 7, 9, 3, 1 })); // 12
		System.out.println(robber.rob(new int[] { 1, 1 })); // 1
	}
}
