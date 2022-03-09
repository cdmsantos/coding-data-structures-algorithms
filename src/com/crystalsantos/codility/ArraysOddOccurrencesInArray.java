package com.crystalsantos.codility;

import java.util.Arrays;

public class ArraysOddOccurrencesInArray {

	private int solution(int[] A) {
		Arrays.sort(A); // O(n log(n))
		int unpaired = 0, check = 1, element = A[0];
		
		if(A.length == 1) {
			unpaired = A[0];
		} else {
			for (int i = 1; i < A.length; i++) {
				if(A[i] == element) {
					check++;
				} else {
					if(check % 2 != 0) {
						unpaired = element;
						break;
					} else {
						check = 1;
						element = A[i];							
					}
				}
			}
		}
		
		if(check == 1) {
			unpaired = element;
		}

		return unpaired;
	}

	public static void main(String[] args) {
		ArraysOddOccurrencesInArray odd = new ArraysOddOccurrencesInArray();
		System.out.println(odd.solution(new int[] { 9, 3, 9, 3, 9, 7, 9, 7, 11 }));
	}
}
