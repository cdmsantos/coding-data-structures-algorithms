package com.crystalsantos.coding.arrayandstring;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		if(digits == null) {
			return null;
		}
		
		if(digits[digits.length -1] < 9) {
			digits[digits.length -1] = digits[digits.length -1] + 1;
		} else {
			digits[digits.length -1] = 0;
			int left = 1;
			for(int i = digits.length - 2; i >= 0; i--) {
				if(digits[i] + left <= 9) {
					digits[i] = digits[i] + left;
					left = 0;
					break;
				} else {
					digits[i] = 0;
				}
			}
			
			if(left == 1) {
				int[] result = new int[digits.length + 1];
				result[0] = 1;
				for(int i = 1; i < result.length; i++) {
					result[i] = digits[i-1];
				}
				return result;
			}
		}
		return digits;
	}

	public static void main(String[] args) {
		PlusOne plusOneToNumber = new PlusOne();

		int[] nums1 = new int[] { 1, 2, 3 };
		int[] result1 = plusOneToNumber.plusOne(nums1);
		plusOneToNumber.printArray(result1);

		int[] nums2 = new int[] { 4, 3, 2, 1 };
		int[] result2 = plusOneToNumber.plusOne(nums2);
		plusOneToNumber.printArray(result2);

		int[] nums3 = new int[] { 0 };
		int[] result3 = plusOneToNumber.plusOne(nums3);
		plusOneToNumber.printArray(result3);
		
		int[] nums4 = new int[] { 9, 9, 9 };
		int[] result4 = plusOneToNumber.plusOne(nums4);
		plusOneToNumber.printArray(result4);
		
		int[] nums5 = new int[] { 9, 8, 9 };
		int[] result5 = plusOneToNumber.plusOne(nums5);
		plusOneToNumber.printArray(result5);
	}

	private void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
