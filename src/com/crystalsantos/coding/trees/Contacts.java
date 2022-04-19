package com.crystalsantos.coding.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/***
 * Contacts
 * 
 * 
 * We're going to make our own Contacts application! The application must
 * perform two types of operations:
 * 
 * add name, where is a string denoting a contact name. This must store as a new
 * contact in the application. find partial, where is a string denoting a
 * partial name to search the application for. It must count the number of
 * contacts starting with and print the count on a new line. Given sequential
 * add and find operations, perform each operation in order.
 * 
 * Example Operations are requested as follows:
 * 
 * add ed add eddie add edward find ed add edwina find edw find a Three
 * operations include the names 'ed', 'eddie', and 'edward'. Next, matches all
 * names. Note that it matches and counts the entire name 'ed'. Next, add
 * 'edwina' and then find 'edw'. names match: 'edward' and 'edwina'. In the
 * final operation, there are names that start with 'a'. Return the array .
 * 
 */
public class Contacts {

	public static List<Integer> contacts(List<List<String>> queries) {
		List<Integer> result = new ArrayList<>();

		if (queries == null) {
			return result;
		}

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < queries.size(); i++) {
			String action = queries.get(i).get(0);
			String query = queries.get(i).get(1);

			if (action.equals("add")) {
				for (int j = 1; j <= query.length(); j++) {
					String sub = query.substring(0, j);
					map.put(sub, map.getOrDefault(sub, 0) + 1);
				}
			} else {
				int quantity = map.get(query) == null ? 0 : map.get(query);
				result.add(quantity);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		List<List<String>> queries1 = Arrays.asList(Arrays.asList("add", "hack"), Arrays.asList("add", "hackerrank"),
				Arrays.asList("find", "hac"), Arrays.asList("find", "hak"));
		Contacts.printResult(Contacts.contacts(queries1));
	}

	public static void printResult(List<Integer> result) {
		System.out.print("[ ");
		for (Integer res : result) {
			System.out.print(res + " ");
		}
		System.out.print("]");
		System.out.println();
	}
}
