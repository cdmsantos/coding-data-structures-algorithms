package com.crystalsantos.codility;

import java.util.ArrayList;
import java.util.List;

public class BinaryGap {
	
	public int solution(int N) {
		List<Integer> binary = getBinaryNumber(N);
		int longest = 0, partial = 0;
		boolean count = false;

		for (int i = 0; i < binary.size(); i++) {
			if (binary.get(i) == 1 && !count) {
				count = true;
			} else if (binary.get(i) == 1 && count) {
				longest = partial > longest ? partial : longest;
				count = checkIfNextNumberIsZero(i, binary);
				partial = 0;
			} else if (binary.get(i) == 0 && count) {
				partial++;
			}
		}

		return longest;
	}
	
	private boolean checkIfNextNumberIsZero(int i, List<Integer> binary) {
		if(binary.size() > i+1) {
			return binary.get(i+1) == 0 ? true : false;
		}
		return false;
	}

	private List<Integer> getBinaryNumber(int N) {
		List<Integer> binary = new ArrayList<>();

		while (N > 0) {
			binary.add(N % 2);
			N = N / 2;
		}
		return binary;
	}

	public static void main(String[] args) {
		BinaryGap binaryGap = new BinaryGap();
		System.out.println(binaryGap.solution(9)); //2
		System.out.println(binaryGap.solution(529)); //4
		System.out.println(binaryGap.solution(20)); //1
		System.out.println(binaryGap.solution(15)); //0
		System.out.println(binaryGap.solution(32)); //0
	}
}
