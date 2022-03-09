package com.crystalsantos.coding.codility;

import java.util.Arrays;

public class CountingElementsMissingInteger {
	public int solution(int[] A) {
		int missingElement = 1, max = 0;

		Arrays.sort(A);
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				if (A[i] == missingElement) {
					missingElement += 1;
				}

				if (A[i] > max) {
					max = A[i];
				}
			}
		}

		return missingElement;
	}

	public static void main(String[] args) {
		CountingElementsMissingInteger missing = new CountingElementsMissingInteger();
		System.out.println(missing.solution(new int[] { 1, 3, 6, 4, 1, 2 }));
		System.out.println(missing.solution(new int[] { 1, 2, 3 }));
		System.out.println(missing.solution(new int[] { -1, -2, }));
	}
}
