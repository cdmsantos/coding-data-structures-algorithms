package com.crystalsantos.coding.math;

/**
 * 
 * Count Primes
 * 
 * Given an integer n, return the number of prime numbers that are strictly less
 * than n.
 * 
 * Example 1:
 * 
 * Input: n = 10 Output: 4 Explanation: There are 4 prime numbers less than 10,
 * they are 2, 3, 5, 7. Example 2:
 * 
 * Input: n = 0 Output: 0 Example 3:
 * 
 * Input: n = 1 Output: 0
 * 
 * 
 * Constraints:
 * 
 * 0 <= n <= 5 * 106
 */
public class CountPrimes {
	public int countPrimes(int n) {
		if (n == 0 || n == 1) {
			return 0;
		}

		int count = n / 2;

		boolean[] notPrime = new boolean[n];

		for (int i = 3; i * i < n; i += 2) {
			if (notPrime[i]) {
				continue;
			}
			for (int j = i * i; j < n; j += 2 * i) {
				if (!notPrime[j]) {
					count--;
					notPrime[j] = true;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		CountPrimes primes = new CountPrimes();
		System.out.println(primes.countPrimes(10)); // 4
		System.out.println(primes.countPrimes(0)); // 0
		System.out.println(primes.countPrimes(1)); // 0
	}
}
