package com.crystalsantos.coding.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Find the Running Median
 * 
 * 
 * The median of a set of integers is the midpoint value of the data set for
 * which an equal number of integers are less than and greater than the value.
 * To find the median, you must first sort your set of integers in
 * non-decreasing order, then:
 * 
 * If your set contains an odd number of elements, the median is the middle
 * element of the sorted sample. In the sorted set , is the median. If your set
 * contains an even number of elements, the median is the average of the two
 * middle elements of the sorted sample. In the sorted set , is the median.
 * Given an input stream of integers, perform the following task for each
 * integer:
 * 
 * Add the integer to a running list of integers. Find the median of the updated
 * list (i.e., for the first element through the element). Print the updated
 * median on a new line. The printed value must be a double-precision number
 * scaled to decimal place (i.e., format). Example
 * 
 * Sorted Median [7] 7.0 [3, 7] 5.0 [3, 5, 7] 5.0 [2, 3, 5, 7] 4.0 Each of the
 * median values is stored in an array and the array is returned for the main
 * function to print.
 * 
 * Note: Add formatting to the print statement.
 * 
 * Function Description Complete the runningMedian function in the editor below.
 * 
 * runningMedian has the following parameters: - int a[n]: an array of integers
 * 
 * Returns - float[n]: the median of the array after each insertion, modify the
 * print statement in main to get proper formatting.
 * 
 * Input Format
 * 
 * The first line contains a single integer, , the number of integers in the
 * data stream. Each line of the subsequent lines contains an integer, , to be
 * inserted into the list.
 * 
 * Constraints
 * 
 * Sample Input
 * 
 * STDIN Function ----- -------- 6 a[] size n = 6 12 a = [12, 4, 5, 3, 8, 7] 4 5
 * 3 8 7 Sample Output
 * 
 * 12.0 8.0 5.0 4.5 5.0 6.0
 *
 */
public class FindTheRunningMedian {
	// keeps track of the SMALL numbers
	private static Queue<Integer> maxHeap;
	// keeps track of the LARGE numbers
	private static Queue<Integer> minHeap;

	public static List<Double> runningMedian(List<Integer> a) {
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		minHeap = new PriorityQueue<>();
		List<Double> result = new ArrayList<>();

		if (a != null) {
			for (int i = 0; i < a.size(); i++) {
				addNumber(a.get(i));
				result.add(getMedian());
			}
		}
		return result;
	}

	private static void addNumber(int n) {
		if (maxHeap.isEmpty()) {
			maxHeap.add(n);
		} else if (maxHeap.size() == minHeap.size()) {
			if (n < minHeap.peek()) {
				maxHeap.add(n);
			} else {
				minHeap.add(n);
				maxHeap.add(minHeap.remove());
			}
		} else if (maxHeap.size() > minHeap.size()) {
			if (n > maxHeap.peek()) {
				minHeap.add(n);
			} else {
				maxHeap.add(n);
				minHeap.add(maxHeap.remove());
			}
		}
		// maxHeap will never have fewer elements than minHeap
	}

	private static double getMedian() {
		if (maxHeap.isEmpty()) {
			return 0;
		} else if (maxHeap.size() == minHeap.size()) {
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		} else { // maxHeap must have more elements than minHeap
			return maxHeap.peek();
		}
	}

	public static void main(String[] args) {
		FindTheRunningMedian.printResult(FindTheRunningMedian.runningMedian(Arrays.asList(7, 3, 5, 2)));
	}

	private static void printResult(List<Double> result) {
		System.out.print("[ ");
		for (Double res : result) {
			System.out.print(res + " ");
		}
		System.out.print("]");
		System.out.println();
	}
}
