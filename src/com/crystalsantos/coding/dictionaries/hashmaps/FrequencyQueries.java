package com.crystalsantos.coding.dictionaries.hashmaps;

import static java.util.stream.Collectors.joining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FrequencyQueries {

	// Complete the freqQuery function below.
	static List<Integer> freqQuery(BufferedReader bufferedReader, int numberOfqueries) throws IOException {
		List<Integer> output = new ArrayList<Integer>();

		HashMap<Integer, Integer> mapQueries = new HashMap<Integer, Integer>();
		HashMap<Integer, Set<Integer>> countsToValues = new HashMap<>();

		Pattern p = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");

		for (int i = 0; i < numberOfqueries; i++) {
			Matcher m = p.matcher(bufferedReader.readLine());
			if (m.matches()) {
				int action = Integer.parseInt(m.group(1));
				int number = Integer.parseInt(m.group(2));

				int oldCount = mapQueries.getOrDefault(number, 0);
				int newCount;

				if (action == 1) { // add
					newCount = oldCount + 1;
					mapQueries.put(number, newCount);

					updateCountsToValues(countsToValues, oldCount, newCount, number);
				} else if (action == 2) { // remove
					newCount = (oldCount > 1) ? oldCount - 1 : 0;
					mapQueries.put(number, newCount);

					updateCountsToValues(countsToValues, oldCount, newCount, number);
				} else { // check if present
					if (number > numberOfqueries) {
						output.add(0);
					} else {
						output.add(
								(number == 0 || countsToValues.getOrDefault(number, Collections.emptySet()).size() > 0)
										? 1
										: 0);
					}
				}
			}
		}

		return output;
	}

	private static void updateCountsToValues(HashMap<Integer, Set<Integer>> countsToValues, int oldCount, int newCount,
			int number) {
		if (countsToValues.containsKey(oldCount)) {
			countsToValues.get(oldCount).remove(number);
		}

		countsToValues.putIfAbsent(newCount, new HashSet<>());
		countsToValues.get(newCount).add(number);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> ans = freqQuery(bufferedReader, q);

		System.out.println(ans.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();

	}
}
