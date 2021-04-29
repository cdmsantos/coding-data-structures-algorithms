package com.crystalsantos.coding.recursion;

public class KthSymbolInGrammar {
	public int kthGrammar(int N, int K) {
		if (N == 1 && K == 1) {
			return 0;
		}
		
		int midIndex = (int) Math.pow(2, N - 1) / 2;
		
		if (K <= midIndex) {
			return kthGrammar(N - 1, K);
		} else {
			if (kthGrammar(N - 1, K - midIndex) == 1) {
				return 0;
			}
			return 1;
		}
	}

	public static void main(String[] args) {
		KthSymbolInGrammar grammar = new KthSymbolInGrammar();
//		System.out.println(grammar.kthGrammar(1, 1));
		System.out.println(grammar.kthGrammar(2, 1));
		System.out.println(grammar.kthGrammar(2, 2));
		System.out.println(grammar.kthGrammar(4, 5));
	}
}
