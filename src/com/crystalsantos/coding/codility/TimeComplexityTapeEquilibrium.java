package com.crystalsantos.coding.codility;

public class TimeComplexityTapeEquilibrium {

	public int solution(int[] A) {
		int equilibrium = 0;

		if (A.length == 2) {
			equilibrium = Math.abs(A[0] - A[1]);
		} else if (A.length > 2) {
			int firstPart = A[0], secondPart = 0;
			for (int i = 1; i < A.length; i++) {
				secondPart += A[i];
			}

			equilibrium = Math.abs(firstPart - secondPart);

			for (int i = 1; i < A.length - 1; i++) {
				firstPart += A[i];
				secondPart -= A[i];
				equilibrium = checkEquilibrium(firstPart, secondPart, equilibrium);
			}
		}
		return equilibrium;
	}

	private int checkEquilibrium(int firstPart, int secondPart, int equilibrium) {
		if (Math.abs(firstPart - secondPart) < equilibrium) {
			equilibrium = Math.abs(firstPart - secondPart);
		}

		return equilibrium;
	}

	public static void main(String[] args) {
		TimeComplexityTapeEquilibrium findEquilibrium = new TimeComplexityTapeEquilibrium();
		System.out.println(findEquilibrium.solution(new int[] { 3, 1, 2, 4, 3 }));
		System.out.println(findEquilibrium.solution(new int[] { -1000, 1000 }));
		System.out.println(findEquilibrium.solution(new int[] { -10, -20, -30, -40, 100 }));
	}
}
