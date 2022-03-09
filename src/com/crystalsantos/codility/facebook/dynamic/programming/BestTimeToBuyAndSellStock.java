package com.crystalsantos.codility.facebook.dynamic.programming;

/***
 * 
 * Best Time to Buy and Sell Stock
 * 
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: prices = [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2 (price = 1)
 * and sell on day 5 (price = 6), profit = 6-1 = 5. Note that buying on day 2
 * and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 * 
 * Input: prices = [7,6,4,3,1] Output: 0 Explanation: In this case, no
 * transactions are done and the max profit = 0.
 * 
 * 
 * Constraints:
 * 
 * 1 <= prices.length <= 105 0 <= prices[i] <= 104
 */
public class BestTimeToBuyAndSellStock {

	// we take the difference with the minimum element found so far.
	// So we need to keep track of 2 things:
	// 1) Maximum difference found so far (max_diff).
	// 2) Minimum number visited so far (min_element).
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}

		int min = prices[0]; // min so far
		int result = 0; // result so far

		for (int i = 1; i < prices.length; i++) {
			result = Math.max(result, prices[i] - min);
			min = Math.min(min, prices[i]);
		}

		return result;
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock stocks = new BestTimeToBuyAndSellStock();
		System.out.println(stocks.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 })); // 5
		System.out.println(stocks.maxProfit(new int[] { 7, 6, 4, 3, 1 })); // 0
	}
}
