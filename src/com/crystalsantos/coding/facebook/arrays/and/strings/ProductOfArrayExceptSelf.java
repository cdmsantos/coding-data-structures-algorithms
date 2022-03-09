package com.crystalsantos.coding.facebook.arrays.and.strings;

/***
 * 
 * Editors choice!
 * Product of Array Except Self
 * 
 * 
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4] Output: [24,12,8,6] Example 2:
 * 
 * Input: nums = [-1,1,0,-3,3] Output: [0,0,9,0,0]
 * 
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 105 -30 <= nums[i] <= 30 The product of any prefix or
 * suffix of nums is guaranteed to fit in a 32-bit integer.
 * 
 * 
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The
 * output array does not count as extra space for space complexity analysis.)
 *
 */
public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int product = 1;
		int containsZero = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				containsZero++;
			} else {
				product *= nums[i];
			}
		}

		int[] result = new int[nums.length];
		for (int i = 0; i < result.length; i++) {
			if (containsZero == 0) {
				result[i] = product / nums[i];
			} else {
				if (nums[i] == 0 && containsZero > 1) {
					result[i] = 0;
				} else if (nums[i] == 0 && containsZero == 1) {
					result[i] = product;
				} else if (nums[i] != 0) {
					result[i] = 0;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		ProductOfArrayExceptSelf product = new ProductOfArrayExceptSelf();
		product.printResult(product.productExceptSelf(new int[] { 1, 2, 3, 4 })); // 24, 12, 8, 6
		product.printResult(product.productExceptSelf(new int[] { -1, 1, 0, -3, 3 })); // 0,0,9,0,0
		product.printResult(product.productExceptSelf(new int[] { 0, 0 })); // 0,0
		product.printResult(product.productExceptSelf(new int[] { 0, 4, 0 })); // 0,0,0
	}

	private void printResult(int[] result) {
		System.out.print("[");
		for (int i = 0; i < result.length; i++) {
			if (i != result.length - 1) {
				System.out.print(result[i] + ",");
			} else {
				System.out.print(result[i]);
			}
		}
		System.out.print("]");
		System.out.println();
	}
}
