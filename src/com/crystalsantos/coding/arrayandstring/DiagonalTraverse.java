package com.crystalsantos.coding.arrayandstring;

public class DiagonalTraverse {
	public int[] findDiagonalOrder(int[][] mat) {
		if (mat == null) {
			return null;
		}
		int row = mat.length;
		int column = mat[0].length;

		int[] result = new int[row * column];

		boolean up = true;
		boolean down = false;

		int resultIndex = 0;
		int i = 0;
		int j = 0;
		while (resultIndex < row * column) {

			result[resultIndex] = mat[i][j];
			resultIndex++;

			if (up && !invalidIndexes(i - 1, j + 1, row, column)) {
				i--;
				j++;
			} else if (up && invalidIndexes(i - 1, j + 1, row, column)) {
				if (j + 1 >= column) {
					i++;
				} else {
					j++;
				}
				up = false;
				down = true;
			} else if (down && !invalidIndexes(i + 1, j - 1, row, column)) {
				i++;
				j--;
			} else if (down && invalidIndexes(i + 1, j - 1, row, column)) {
				if (i + 1 >= row) {
					j++;
				} else {
					i++;
				}
				down = false;
				up = true;
			}

		}

		return result;
	}

	private boolean invalidIndexes(int i, int j, int row, int column) {
		return i >= row || j >= column || i < 0 || j < 0;
	}

	public static void main(String[] args) {
		DiagonalTraverse diagonalTraverse = new DiagonalTraverse();
		int[][] mat1 = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int[] result1 = diagonalTraverse.findDiagonalOrder(mat1);
		diagonalTraverse.printArray(result1);
	}

	private void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
