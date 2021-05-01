package com.crystalsantos.coding.arrayandstring;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();

		if (matrix.length == 0) {
			return result;
		}

		int rowLength = matrix.length, columnLength = matrix[0].length;
		boolean[][] seen = new boolean[rowLength][columnLength];
		int[] directionRow = { 0, 1, 0, -1 };
		int[] directionColumn = { 1, 0, -1, 0 };
		int row = 0, column = 0, direction = 0;

		for (int i = 0; i < rowLength * columnLength; i++) {
			result.add(matrix[row][column]);
			seen[row][column] = true;
			int calculateRow = row + directionRow[direction];
			int calculateColumn = column + directionColumn[direction];

			if (0 <= calculateRow && calculateRow < rowLength && 0 <= calculateColumn && calculateColumn < columnLength && !seen[calculateRow][calculateColumn]) {
				row = calculateRow;
				column = calculateColumn;
			} else {
				direction = (direction + 1) % 4;
				row += directionRow[direction];
				column += directionColumn[direction];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		SpiralMatrix spiral = new SpiralMatrix();
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		List<Integer> result = spiral.spiralOrder(matrix);

		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
	}

}
