package com.crystalsantos.coding.others;

/**
 * Hamming Distance
 * 
 * 
 * The Hamming distance between two integers is the number of positions at which
 * the corresponding bits are different.
 * 
 * Given two integers x and y, return the Hamming distance between them.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: x = 1, y = 4 Output: 2 Explanation: 1 (0 0 0 1) 4 (0 1 0 0) ↑ ↑ The
 * above arrows point to positions where the corresponding bits are different.
 * Example 2:
 * 
 * Input: x = 3, y = 1 Output: 1
 * 
 * 
 * Constraints:
 * 
 * 0 <= x, y <= 231 - 1
 */
public class HammingDistance {
	public int hammingDistance(int x, int y) {
		int diff = 0;
		int mask = 1;
		for (int i = 0; i < 32; i++) {
			if ((x & mask) != (y & mask)) {
				diff++;
			}
			mask <<= 1;
		}
		return diff;
	}

	public static void main(String[] args) {
		HammingDistance hd = new HammingDistance();
		System.out.println(hd.hammingDistance(3, 1)); // 1
		System.out.println(hd.hammingDistance(1, 4)); // 2
	}
}
