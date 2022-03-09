package com.crystalsantos.coding.facebook.sorting.and.searching;

import java.util.Arrays;
import java.util.LinkedList;

/***
 * 
 * Merge Intervals
 * 
 * 
 * Given an array of intervals where intervals[i] = [starti, endi], merge all
 * overlapping intervals, and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]] Output:
 * [[1,6],[8,10],[15,18]] Explanation: Since intervals [1,3] and [2,6] overlaps,
 * merge them into [1,6]. Example 2:
 * 
 * Input: intervals = [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4]
 * and [4,5] are considered overlapping.
 * 
 * 
 * Constraints:
 * 
 * 1 <= intervals.length <= 104 intervals[i].length == 2 0 <= starti <= endi <=
 * 104
 * 
 */
public class MergeIntervals {
	public int[][] merge(int[][] intervals) {

		if (intervals == null) {
			return new int[0][0];
		}

		if (intervals != null && intervals.length == 1) {
			return intervals;
		}

		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		LinkedList<int[]> merged = new LinkedList<>();

		for (int[] interval : intervals) {
			if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
				merged.add(interval);
			} else {
				merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
			}
		}

		return merged.toArray(new int[merged.size()][]);
	}

	public static void main(String[] args) {
		MergeIntervals merge = new MergeIntervals();
		merge.run();
	}

	private void run() {
		printResult(merge(new int[][] { { 1, 3 }, { 2, 6 }, { 5, 8 }, { 8, 10 }, { 10, 18 }, { 15, 18 } })); // [[1,18]]
		printResult(merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } })); // [[1,6],[8,10],[15,18]]
		printResult(merge(new int[][] { { 1, 4 }, { 4, 5 } })); // [[1,5]]
	}

	private void printResult(int[][] result) {
		System.out.print("[");
		for (int i = 0; i < result.length; i++) {
			System.out.print("[");
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]);
				if (j != result[i].length - 1) {
					System.out.print(",");
				}
			}
			System.out.print("]");
			if (i != result.length - 1) {
				System.out.print(",");
			}
		}
		System.out.print("]");
		System.out.println();
	}
}
