package com.crystalsantos.codility;

public class ArraysCyclicRotation {

	private int[] solution(int[] A, int K) {
		if (A.length > 0) {
			for (int i = 0; i < K; i++) { // every rotation
				int j, previousElement;

				previousElement = A[0];
				for (j = 0; j < A.length - 1; j++) {
					int tempElement = A[j + 1];
					A[j + 1] = previousElement;
					previousElement = tempElement;
				}
				A[0] = previousElement;
			}
		}

		return A;
	}

	public static void main(String[] args) {
		ArraysCyclicRotation rotation = new ArraysCyclicRotation();
		int[] result = rotation.solution(new int[] { }, 4);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}
