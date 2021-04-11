package com.crystalsantos.coding.sorting;

// Add any extra import statements you may need here
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CoutingTriangles {

	static class Sides {
		int a;
		int b;
		int c;

		Sides(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	static int countDistinctTriangles(ArrayList<Sides> arr) {
		if (arr.size() == 1) {
			return 1;
		}

		Set<String> setTriangles = new HashSet<String>();

		for (int i = 0; i < arr.size(); i++) {
			Sides triangle = arr.get(i);
			int[] sides = new int[] {triangle.a, triangle.b, triangle.c};
			Arrays.sort(sides);
			setTriangles.add(sides[0] + ":" + sides[1] + ":" + sides[2]);
		}

		return setTriangles.size();
	}

	static int test_case_number = 1;

	static void check(int expected, int output) {
		boolean result = (expected == output);
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printInteger(expected);
			System.out.print(" Your output: ");
			printInteger(output);
			System.out.println();
		}
		test_case_number++;
	}

	static void printInteger(int n) {
		System.out.print("[" + n + "]");
	}

	static public void run() {
		ArrayList<Sides> arr_1 = new ArrayList<>();
		arr_1.add(new Sides(7, 6, 5));
		arr_1.add(new Sides(5, 7, 6));
		arr_1.add(new Sides(8, 2, 9));
		arr_1.add(new Sides(2, 3, 4));
		arr_1.add(new Sides(2, 4, 3));
		int expected_1 = 3;
		int output_1 = countDistinctTriangles(arr_1);
		check(expected_1, output_1);

		ArrayList<Sides> arr_2 = new ArrayList<>();
		arr_2.add(new Sides(3, 4, 5));
		arr_2.add(new Sides(8, 8, 9));
		arr_2.add(new Sides(7, 7, 7));
		int expected_2 = 3;
		int output_2 = countDistinctTriangles(arr_2);
		check(expected_2, output_2);
	}

	public static void main(String[] args) {
		run();
	}
}