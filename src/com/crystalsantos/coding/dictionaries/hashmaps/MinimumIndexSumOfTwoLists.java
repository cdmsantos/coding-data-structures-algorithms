package com.crystalsantos.coding.dictionaries.hashmaps;

import java.util.HashMap;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {
	public String[] findRestaurant(String[] list1, String[] list2) {
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		HashMap<String, Integer> mapList1 = new HashMap<String, Integer>();

		for (int i = 0; i < list1.length; i++) {
			mapList1.put(list1[i], i);
		}

		int minimum = -1;
		for (int i = 0; i < list2.length; i++) {
			if (mapList1.containsKey(list2[i])) {
				if (result.isEmpty()) {
					result.put(list2[i], i + mapList1.get(list2[i]));
					minimum = i + mapList1.get(list2[i]);
				} else {
					if (i + mapList1.get(list2[i]) == minimum) {
						result.put(list2[i], i + mapList1.get(list2[i]));
					} else if (i + mapList1.get(list2[i]) < minimum) {
						result.clear();
						result.put(list2[i], i + mapList1.get(list2[i]));
					}
				}
			}
		}

		String[] resultArray = new String[result.size()];
		int i = 0;
		for (Map.Entry<String, Integer> entry : result.entrySet()) {
			resultArray[i] = entry.getKey();
			i++;
		}

		return resultArray;
	}

	private void printResult(String[] result) {
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MinimumIndexSumOfTwoLists minimunIndex = new MinimumIndexSumOfTwoLists();

		String[] list1 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
		String[] list2 = { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" };
		String[] result1 = minimunIndex.findRestaurant(list1, list2); // shogun
		minimunIndex.printResult(result1);

		String[] list3 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
		String[] list4 = { "KFC", "Shogun", "Burger King" };
		String[] result2 = minimunIndex.findRestaurant(list3, list4); // shogun
		minimunIndex.printResult(result2);

		String[] list5 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
		String[] list6 = { "KFC", "Burger King", "Tapioca Express", "Shogun" };
		String[] result3 = minimunIndex.findRestaurant(list5, list6); // shogun
		minimunIndex.printResult(result3);

		String[] list7 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
		String[] list8 = { "KNN", "KFC", "Burger King", "Tapioca Express", "Shogun" };
		String[] result4 = minimunIndex.findRestaurant(list7, list8); // shogun
		minimunIndex.printResult(result4);

		String[] list9 = { "KFC" };
		String[] list10 = { "KFC" };
		String[] result5 = minimunIndex.findRestaurant(list9, list10); // kfc
		minimunIndex.printResult(result5);
	}
}
