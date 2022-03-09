package com.crystalsantos.coding.codility;

public class CountingElementsMaxCounters {
	public int[] solution(int N, int[] A) {
		int[] counters = new int[N];
		int maxCounter = 0, updateCounter = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] >= (N + 1)) {
				updateCounter = maxCounter;
			} else {
				if(counters[A[i] - 1] < updateCounter) {
					counters[A[i] - 1] = updateCounter + 1;	
				} else {
					counters[A[i] - 1] += 1;
				}
				
				
				if (counters[A[i] - 1] > maxCounter) {
					maxCounter = counters[A[i] - 1];
				}
			}
		}
		
		if(updateCounter > 0) {
			for(int i = 0; i < counters.length; i++) {
				if(counters[i] < updateCounter) {
					counters[i] = updateCounter;
				}
			}
		}

		return counters;
	}

	public static void main(String[] args) {
		CountingElementsMaxCounters maxCounters = new CountingElementsMaxCounters();
		int[] result1 = maxCounters.solution(5, new int[] { 3, 4, 4, 6, 1, 4, 4 });
		for (int i = 0; i < result1.length; i++) {
			System.out.print(result1[i] + " ");
		}
	}
}
