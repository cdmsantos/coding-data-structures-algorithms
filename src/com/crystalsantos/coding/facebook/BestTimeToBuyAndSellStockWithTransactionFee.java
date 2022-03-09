package com.crystalsantos.coding.facebook;

public class BestTimeToBuyAndSellStockWithTransactionFee {
	public int maxProfit(int[] prices, int fee) {
		int k = prices.length / 2; // maxinum k transactions
		int[] sell = new int[k + 1];
		int[] buy = new int[k + 1];

		for (int i = 0; i < buy.length; i++) {
			buy[i] = Integer.MIN_VALUE;
		}

		for (int p : prices) { // for each day
			for (int i = k; i >= 1; i--) {
				if (p >= fee) {
					sell[i] = Math.max(sell[i], buy[i] + p - fee);
				}
				buy[i] = Math.max(buy[i], sell[i - 1] - p);
			}
		}
		return sell[k];
	}
}
