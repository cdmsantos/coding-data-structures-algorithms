package com.crystalsantos.coding.amazon.dynamicprogramming;

/**
 * Coin Change
 * 
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 * 
 * Return the fewest number of coins that you need to make up that amount. If
 * that amount of money cannot be made up by any combination of the coins,
 * return -1.
 * 
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * Example 1:
 * 
 * Input: coins = [1,2,5], amount = 11 Output: 3 Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * 
 * Input: coins = [2], amount = 3 Output: -1 Example 3:
 * 
 * Input: coins = [1], amount = 0 Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= coins.length <= 12 1 <= coins[i] <= 231 - 1 0 <= amount <= 104
 */
public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		if (amount < 1) {
			return 0;
		}
		return coinChange(coins, amount, new int[amount]);
	}

	private int coinChange(int[] coins, int rem, int[] count) {
		if (rem < 0) {
			return -1;
		}
		if (rem == 0) {
			return 0;
		}
		if (count[rem - 1] != 0) {
			return count[rem - 1];
		}
		int min = Integer.MAX_VALUE;

		for (int coin : coins) {
			int res = coinChange(coins, rem - coin, count);
			if (res >= 0 && res < min) {
				min = 1 + res;
			}
		}
		count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
		return count[rem - 1];
	}

	public static void main(String[] args) {
		CoinChange coin = new CoinChange();
		System.out.println(coin.coinChange(new int[] { 1, 2, 5 }, 11)); // 3
		System.out.println(coin.coinChange(new int[] { 2 }, 3)); // -1
		System.out.println(coin.coinChange(new int[] { 1 }, 0)); // 0
	}
}
