package com.crystalsantos.coding.sorting;

public class MergeSort {
	
	void mergeSort(int arr[], int left, int middle, int right) {
		
		//size of left and right array to be merged
		int leftArraySize = middle - left + 1;
		int rightArraySize = right - middle;
		
		//temp arrays
		int[] leftArray = new int[leftArraySize];
		int[] rightArray = new int[rightArraySize];
		
		//copy data to temp arrays
		for(int i = 0; i < leftArraySize; i++) {
			leftArray[i] = arr[left + i];
		}
		
		for(int j = 0; j < rightArraySize; j++) {
			rightArray[j] = arr[middle + 1 + j];
		}
		
		//merge temp arrays
		int i = 0;
		int j = 0;
		
		int k = left; //initial index of merged sub array
		while(i < leftArraySize && j < rightArraySize) {
			if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            }
            else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
		}
		
		//copy remaining elements from leftArray and rightArray to array
		
		while(i < leftArraySize) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}
		
		while(j < rightArraySize) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}
	
    void sort(int arr[], int left, int right)
    {
        if (left < right) {
            // Find the middle point
            int m =left+ (right-left)/2;
 
            // Sort first and second halves
            sort(arr, left, m);
            sort(arr, m + 1, right);
 
            // Merge the sorted halves
            mergeSort(arr, left, m, right);
        }
    }
	
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
        	System.out.print(arr[i] + " ");        	
        }
        System.out.println();
    }
    
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
 
        System.out.println("Given Array");
        printArray(arr);
 
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);
 
        System.out.println("\nSorted array");
        printArray(arr);
    }

}
