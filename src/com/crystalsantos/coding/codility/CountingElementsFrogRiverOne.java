package com.crystalsantos.coding.codility;

import java.util.HashSet;
import java.util.Set;

public class CountingElementsFrogRiverOne {
	public int solution(int X, int[] A) {
		int time = -1;

		Set<Integer> leaves = new HashSet<Integer>();

		for (int i = 0; i < A.length; i++) {
			leaves.add(A[i]);
			
			if (leaves.size() >= X && leaves.contains(X)) {
				time = i;
				break;
			}
		}

		return time;
	}

	public static void main(String[] args) {
		CountingElementsFrogRiverOne jumps = new CountingElementsFrogRiverOne();
		System.out.println(jumps.solution(5, new int[] { 1, 3, 1, 4, 2, 3, 5, 4 }));
		System.out.println(jumps.solution(5, new int[] { 1, 3, 1, 4, 2, 3, 1, 4 }));
	}
}
