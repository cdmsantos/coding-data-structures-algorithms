package com.crystalsantos.coding.arrayandstring;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if (numRows <= 0) {
			return result;
		}

		List<Integer> previous = new ArrayList<Integer>();
		previous.add(1);
		result.add(previous);

		for (int i = 2; i <= numRows; i++) {
			List<Integer> current = new ArrayList<Integer>();

			current.add(1); 
			for (int j = 0; j < previous.size() - 1; j++) {
				current.add(previous.get(j) + previous.get(j + 1));
			}
			current.add(1);

			result.add(current);
			previous = current;
		}

		return result;
	}

}
