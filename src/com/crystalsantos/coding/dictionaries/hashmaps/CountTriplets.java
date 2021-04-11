package com.crystalsantos.coding.dictionaries.hashmaps;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class CountTriplets {

	// Complete the countTriplets function below.
	static long countTriplets(List<Long> arr, long r) {
		
		HashMap<Long, Long> right = new HashMap<Long, Long>();
		HashMap<Long, Long> left = new HashMap<Long, Long>();
		for (int i = 0; i < arr.size(); i++) {
			right.put(arr.get(i), right.getOrDefault(arr.get(i), 0L) + 1);
		}
		
		long triplets = 0;
		for (int i = 0; i < arr.size(); i++) {

			long midTerm = arr.get(i);
			long c1 = 0, c3 = 0;

			right.put(midTerm, right.getOrDefault(midTerm, 0L) - 1);

			if (left.containsKey(midTerm / r) && midTerm % r == 0) {
				c1 = left.get(midTerm / r);
			}

			if (right.containsKey(midTerm * r)) {
				c3 = right.get(midTerm * r);				
			}

			triplets += c1 * c3;

			left.put(midTerm, left.getOrDefault(midTerm, 0L) + 1);
		}

		return triplets;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		long r = Long.parseLong(nr[1]);

		List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Long::parseLong)
				.collect(toList());

		long ans = countTriplets(arr, r);
		System.out.println(ans);

		bufferedReader.close();
	}
}
