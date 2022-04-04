package com.crystalsantos.coding.facebook.random;

public class Cafeteria {

	public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
		if (N / K * 2 == M) {
			return 0L;
		}

		int[] seats = new int[(int) N];
		for (int i = 0; i < S.length; i++) {
			seats[(int) S[i] - 1] = 1;
		}

		int countK = 0, addDiners = 0;
		for (int i = 0; i < seats.length; i++) {
			if (seats[i] == 0) {
				countK++;
			}

			if (countK == K * 2 + 1) {
				addDiners++;
				countK = 0;
			}
			
			if(seats[i] == 1) {
				countK = 0;
			}
		}
		
		if(countK == K) {
			addDiners++;
		}

		return addDiners;
	}

	public static void main(String[] args) {
		Cafeteria cafeteria = new Cafeteria();
		System.out.println(cafeteria.getMaxAdditionalDinersCount(10L, 1L, 2, new long[] { 2, 6 })); //3
		System.out.println(cafeteria.getMaxAdditionalDinersCount(15L, 2L, 3, new long[] { 11, 6, 14 })); //1
	}
}
