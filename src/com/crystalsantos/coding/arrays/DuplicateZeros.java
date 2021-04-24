package com.crystalsantos.coding.arrays;

public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                for(int j = arr.length-1; j >= i+2; j--) {
                    arr[j] = arr[j-1];
                }

                if(i+1 < arr.length) {
                	arr[i+1] = 0;
                }
                i++;
            }
        }
        
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
	public static void main(String[] args) {
		DuplicateZeros zeros = new DuplicateZeros();
		int[] arr = new int[] {0,0,0,0,0,0,0};
		zeros.duplicateZeros(arr);		
	}
}
