package com.crystalsantos.coding.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * Input: list1 = [5, 1, 2, 4], list2 = [4, 6, 3], list3 = [9, 0, 7] Output:
 * next(); // 0 next(); // 1 next(); // 2 next(); // 3 next(); // 4 next(); // 4
 * next(); // 5 next(); // 6 next(); // 7 next(); // 7
 */
public class SortedIterator {
	private final List<List<Integer>> lists;
	private final PriorityQueue<int[]> queue;

	public SortedIterator(List<List<Integer>> lists) {
		this.lists = lists;
		this.queue = new PriorityQueue<>((x, y) -> lists.get(x[0]).get(x[1]) - lists.get(y[0]).get(y[1]));

		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i).isEmpty()) {
				continue;
			}
			Collections.sort(lists.get(i));
			queue.offer(new int[] { i, 0 });
		}
	}

	public int next() {
		if (!hasNext()) {
			return -1;
		}

		int[] cur = queue.poll();
		int ans = lists.get(cur[0]).get(cur[1]);
		if (cur[1] + 1 < lists.get(cur[0]).size()) {
			queue.offer(new int[] { cur[0], cur[1] + 1 });
		}
		return ans;
	}

	public boolean hasNext() {
		return !queue.isEmpty();
	}

	public static void main(String[] args) {
		List<List<Integer>> lists = new ArrayList<>();
		lists.add(Arrays.asList(new Integer[] { 5, 1, 2, 4 }));
		lists.add(Arrays.asList(new Integer[] { 4, 6, 3 }));
		lists.add(Arrays.asList(new Integer[] { 9, 0, 7 }));
		SortedIterator sol = new SortedIterator(lists);

		while (sol.hasNext()) {
			System.out.println(sol.next());
		}
	}
}
