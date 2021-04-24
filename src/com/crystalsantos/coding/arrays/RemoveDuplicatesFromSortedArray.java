package com.crystalsantos.coding.arrays;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int changePosition = Integer.MAX_VALUE;
        
        if(nums.length == 1) {
        	return 1; 
        } else {
        	for(int i = 1; i < nums.length; i++) {
        		if(nums[i] == nums[i-1]) {
        			if(changePosition == Integer.MAX_VALUE) {
        				changePosition = i;
        			}
        		} else {
        			if(changePosition != Integer.MAX_VALUE) {
        				nums[changePosition] = nums[i];
        				changePosition++;
        			}
        		}
        	}
        }
        
        return changePosition;
    }
    
    public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray remove = new RemoveDuplicatesFromSortedArray();
//		int[] nums = new int[] {0,1,2,2,3,0,4,2};
//		System.out.println(remove.removeElement(nums, 2));
		int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
		System.out.println(remove.removeDuplicates(nums));
		
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
