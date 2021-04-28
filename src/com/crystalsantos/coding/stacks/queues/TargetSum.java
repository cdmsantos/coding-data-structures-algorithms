package com.crystalsantos.coding.stacks.queues;

public class TargetSum {
	int count;
	public int findTargetSumWays(int[] nums, int S) {
		count = 0;
		calculateWaysDfs(nums, 0, S);
		return count;
	}

    private void calculateWaysDfs(int[] nums, int idx, int S) {
        if (idx == nums.length) {
            if (S == 0) {
                count++;   
            }
            return;
        }
        calculateWaysDfs(nums, idx + 1, S - nums[idx]);
        calculateWaysDfs(nums, idx + 1, S + nums[idx]);
    }
}
