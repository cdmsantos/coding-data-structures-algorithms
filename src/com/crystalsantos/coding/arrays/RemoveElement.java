package com.crystalsantos.coding.arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int from = 0;
        int to = Integer.MAX_VALUE;
        
        while(from < nums.length) {
           if(nums[from] == val) {
               if(to == Integer.MAX_VALUE) {
                   to = from;
               }
           } else {
               if(to != Integer.MAX_VALUE) {
                   nums[to] = nums[from];
                   to++;
               }
           }
            
            from++;
        }
        
        return to;
    }
    
    public static void main(String[] args) {
		RemoveElement remove = new RemoveElement();
//		int[] nums = new int[] {0,1,2,2,3,0,4,2};
//		System.out.println(remove.removeElement(nums, 2));
		int[] nums = new int[] {3,3};
		System.out.println(remove.removeElement(nums, 3));
		
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
