package com.crystalsantos.coding.stacks.queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Moving Average from Data Stream
 * 
 * Given a stream of integers and a window size, calculate the moving average of
 * all integers in the sliding window.
 * 
 * Implement the MovingAverage class:
 * 
 * MovingAverage(int size) Initializes the object with the size of the window
 * size. double next(int val) Returns the moving average of the last size values
 * of the stream.
 * 
 * 
 * Example 1:
 * 
 * Input ["MovingAverage", "next", "next", "next", "next"] [[3], [1], [10], [3],
 * [5]] Output [null, 1.0, 5.5, 4.66667, 6.0]
 * 
 * Explanation MovingAverage movingAverage = new MovingAverage(3);
 * movingAverage.next(1); // return 1.0 = 1 / 1 movingAverage.next(10); //
 * return 5.5 = (1 + 10) / 2 movingAverage.next(3); // return 4.66667 = (1 + 10
 * + 3) / 3 movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
 * 
 * 
 * Constraints:
 * 
 * 1 <= size <= 1000 -105 <= val <= 105 At most 104 calls will be made to next.
 */
public class MovingAverage {
	Queue<Integer> queue;
	int size;
	double sum;

	public MovingAverage(int size) {
		queue = new LinkedList<>();
		sum = 0;
		this.size = size;
	}

	public double next(int val) {
		if (queue.size() == size) {
			int removed = queue.poll();
			sum -= removed;
		}

		queue.add(val);
		sum += val;
		return sum / queue.size();
	}

	public static void main(String[] args) {
		MovingAverage average = new MovingAverage(3);
		System.out.println(average.next(1));
		System.out.println(average.next(10));
		System.out.println(average.next(3));
		System.out.println(average.next(5));
	}
}
