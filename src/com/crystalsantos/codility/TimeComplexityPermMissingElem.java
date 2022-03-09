package com.crystalsantos.codility;

import java.util.Arrays;

public class TimeComplexityPermMissingElem {
	public int solution(int[] A) {
		int missingElement = 1;

		if (A.length != 0) {
			Arrays.sort(A);
			boolean ended = false;
			for (int i = 0; i < A.length; i++) {
				if (i == 0 && A[i] != 1) {
					ended = true;
					break;
				} else if (i == 0 && A[i] == 1 && A.length == 1) {
					missingElement = 2;
				} else {
					if (i != 0 && A[i] != (A[i - 1] + 1)) {
						missingElement = A[i - 1] + 1;
						ended = true;
						break;
					}
				}
			}

			if (!ended && missingElement == 1) {
				missingElement = A[A.length - 1] + 1;
			}

		}
		return missingElement;
	}

	public static void main(String[] args) {
		TimeComplexityPermMissingElem missing = new TimeComplexityPermMissingElem();
		System.out.println(missing.solution(new int[] {})); // 1
		System.out.println(missing.solution(new int[] { 1 })); // 2
		System.out.println(missing.solution(new int[] { 2, 3, 5, 1 })); // 4
		System.out.println(missing.solution(new int[] { 2, 3, 5, 1, 4 })); // 6
	}
}
