package com.crystalsantos.coding.arrays;

/***
 * 
 * Rotate Image
 * 
 * 
 * You are given an n x n 2D matrix representing an image, rotate the image by
 * 90 degrees (clockwise).
 * 
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]] Output: [[7,4,1],[8,5,2],[9,6,3]]
 * Example 2:
 * 
 * 
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]] Output:
 * [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * 
 * 
 * Constraints:
 * 
 * n == matrix.length == matrix[i].length 1 <= n <= 20 -1000 <= matrix[i][j] <=
 * 1000
 */
public class RotateImage {
	public void rotate(int[][] matrix) {
		int[][] temp = new int[matrix.length][matrix[0].length];

		int tempX = 0;
		for (int y = 0; y < matrix.length; y++) {
			int tempY = 0;
			for (int x = matrix[y].length - 1; x >= 0; x--) {
				temp[tempX][tempY] = matrix[x][y];
				tempY++;
			}
			tempX++;
		}

		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				matrix[i][j] = temp[i][j];
			}
		}
	}

	public static void main(String[] args) {
		RotateImage rotate = new RotateImage();
		int[][] matrix1 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] matrix2 = new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };

		rotate.rotate(matrix1);
		rotate.rotate(matrix2);

		rotate.printResult(matrix1);
		rotate.printResult(matrix2);
	}

	private void printResult(int[][] result) {
		System.out.print("[");

		for (int i = 0; i < result.length; i++) {
			System.out.print("[");
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]);
				if (j != result[i].length - 1) {
					System.out.print(",");
				}
			}
			System.out.print("]");
			if (i != result.length - 1) {
				System.out.print(" , ");
			}
		}

		System.out.print("]");
		System.out.println();
	}
}
