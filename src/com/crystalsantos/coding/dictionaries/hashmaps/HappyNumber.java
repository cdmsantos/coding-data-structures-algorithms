package com.crystalsantos.coding.dictionaries.hashmaps;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public boolean isHappy(int number) {
		if (number == 0) {
			return false;
		}

		if (number == 1) {
			return true;
		}

		Set<Integer> set = new HashSet<Integer>();

		int result = number;
		while (result != 1) {
			int[] numberArray = String.valueOf(result).chars().map(Character::getNumericValue).toArray();
			result = 0;
			for (int i = 0; i < numberArray.length; i++) {
				result += numberArray[i] * numberArray[i];
			}

			if (set.contains(result)) {
				return false;
			}

			set.add(result);
		}

		return true;
	}

	public static void main(String[] args) {
		HappyNumber happyNumber = new HappyNumber();
		System.out.println(happyNumber.isHappy(19));
		System.out.println(happyNumber.isHappy(2));
	}
}
