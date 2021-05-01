	package com.crystalsantos.coding.arrays;

public class TwoDSpiralArray {

	public static int[][] genSpiral(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("N must be >0");
		}
		
		int[] dirColumn = new int[] { 1, 0, -1, 0 };
		int[] dirRow = new int[] { 0, 1, 0, -1 };
		int direction = 0, value = 0, row = 0, column = 0, limit = n * n;
		int[][] matrix = new int[n][n];
		
		while (value++ < limit) {
			matrix[row][column] = value;
			
			row += dirRow[direction];
			column += dirColumn[direction];
			
			if (isInvalid(matrix, row, column)) {
				row -= dirRow[direction];
				column -= dirColumn[direction];
				
				direction = (direction + 1) % 4;
				
				row += dirRow[direction];
				column += dirColumn[direction];
			}
		}
		return matrix;
	}

	private static boolean isInvalid(int[][] matrix, int row, int column) {
		return row < 0 || column < 0 || row >= matrix.length || column >= matrix.length || matrix[row][column] != 0;
	}

	public static void printSpiral(int[][] spiral) {
		for (int i = 0; i < spiral.length; i++) {
			for (int j = 0; j < spiral.length; j++) {
				System.out.print(spiral[i][j]);
				if (j != spiral.length - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] spiral3 = genSpiral(3);
		printSpiral(spiral3);

		System.out.println();
		
		int[][] spiral4 = genSpiral(4);
		printSpiral(spiral4);
	}
}
