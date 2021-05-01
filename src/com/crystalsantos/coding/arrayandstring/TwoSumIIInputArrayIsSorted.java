package com.crystalsantos.coding.arrayandstring;

public class TwoSumIIInputArrayIsSorted {
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null) {
			return null;
		}

		int[] result = new int[2];
		int forward = 0;
		int backward = numbers.length - 1;

		while (forward < numbers.length) {

			if (backward < 0) {
				backward = numbers.length - 1;
				forward++;
			}

			if (numbers[forward] + numbers[backward] == target) {
				result[0] = forward + 1;
				result[1] = backward + 1;
				break;
			}

			backward--;
		}

		return result;
	}

	public static void main(String[] args) {
		TwoSumIIInputArrayIsSorted twoSum = new TwoSumIIInputArrayIsSorted();

		int[] numbers1 = new int[] { 2, 7, 11, 15 };
		int[] result1 = twoSum.twoSum(numbers1, 9);
		System.out.println("Result = [" + result1[0] + " , " + result1[1] + "]");

		int[] numbers2 = new int[] { 2, 3, 4 };
		int[] result2 = twoSum.twoSum(numbers2, 6);
		System.out.println("Result = [" + result2[0] + " , " + result2[1] + "]");

		int[] numbers3 = new int[] { -1, 0 };
		int[] result3 = twoSum.twoSum(numbers3, -1);
		System.out.println("Result = [" + result3[0] + " , " + result3[1] + "]");
	}
}
