package com.crystalsantos.coding.arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {        
        for(int i = 0; i < n; i++) {
            boolean added = false;
            
            for(int j = 0; j < m; j++) {
                if(nums2[i] <= nums1[j]) {
                    added = true;
                    
                    for(int k = nums1.length-1; k > j; k--) {
                    	nums1[k] = nums1[k-1];
                    }
                    
                    nums1[j] = nums2[i];
                    m++;
                    break;
                }
            }
            
            if(!added) {
            	nums1[m] = nums2[i];
                m++;
            }
        }
        
        for(int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
    }
    
    public static void main(String[] args) {
    	MergeSortedArray merge = new MergeSortedArray();
		int[] nums1 = new int[] {4,0,0,0,0,0};
		int[] nums2 = new int[] {1,2,3,5,6};

    	merge.merge(nums1, 1, nums2, 5);
	}
}
