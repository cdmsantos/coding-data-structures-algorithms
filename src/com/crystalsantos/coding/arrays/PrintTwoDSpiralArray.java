package com.crystalsantos.coding.arrays;

import java.util.ArrayList;
import java.util.List;

public class PrintTwoDSpiralArray {

	public static List<Integer> printSpiral(int[][] matrix) {
		List<Integer> spiralNumbers = new ArrayList<Integer>();

		if (matrix.length == 0) {
			return spiralNumbers;
		}

		int rowLength = matrix.length, columnLength = matrix[0].length;
		boolean[][] seen = new boolean[rowLength][columnLength];
		int[] rowDirection = { 0, 1, 0, -1 };
		int[] columnDirection = { 1, 0, -1, 0 };
		int row = 0, column = 0, direction = 0;

		// Iterate from 0 to R * C - 1
		for (int i = 0; i < rowLength * columnLength; i++) {
			spiralNumbers.add(matrix[row][column]);
			seen[row][column] = true;
			int cr = row + rowDirection[direction];
			int cc = column + columnDirection[direction];

			if (0 <= cr && cr < rowLength && 0 <= cc && cc < columnLength && !seen[cr][cc]) {
				row = cr;
				column = cc;
			} else {
				direction = (direction + 1) % 4;
				row += rowDirection[direction];
				column += columnDirection[direction];
			}
		}
		return spiralNumbers;
	}

	private static void printList(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		printList(printSpiral(a));

		System.out.println();

		int b[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		printList(printSpiral(b));
	}
}
