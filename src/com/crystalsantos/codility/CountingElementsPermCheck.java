package com.crystalsantos.codility;

import java.util.HashSet;
import java.util.Set;

public class CountingElementsPermCheck {

	public int solution(int[] A) {
		int permutation = 0, max = 0;

		Set<Integer> checkPerm = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			if(checkPerm.contains(A[i])) {
				return permutation;
			}
			
			checkPerm.add(A[i]);

			if (A[i] > max) {
				max = A[i];
			}
		}
		
		if (checkPerm.size() == max) {
			permutation = 1;
		}

		return permutation;
	}

	public static void main(String[] args) {
		CountingElementsPermCheck check = new CountingElementsPermCheck();
		System.out.println(check.solution(new int[] { 4, 1, 3, 2 }));
		System.out.println(check.solution(new int[] { 2, 1, 3 }));
		System.out.println(check.solution(new int[] { 1, 1 }));
	}
}
