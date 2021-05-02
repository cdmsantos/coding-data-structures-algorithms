package com.crystalsantos.coding.dictionaries.hashmaps;

import java.util.HashSet;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		
		boolean row = checkRow(board);
		boolean column = checkColumn(board);
		boolean box1 = notInBox(board, 0, 0);
		boolean box2 = notInBox(board, 0, 3);
		boolean box3 = notInBox(board, 0, 6);
		boolean box4 = notInBox(board, 3, 0);
		boolean box5 = notInBox(board, 3, 3);
		boolean box6 = notInBox(board, 3, 6);
		boolean box7 = notInBox(board, 6, 0);
		boolean box8 = notInBox(board, 6, 3);
		boolean box9 = notInBox(board, 6, 6);

		return row && column && box1 && box2 && box3 && box4 && box5 && box6 && box7 && box8 && box9;
	}

	private boolean checkRow(char[][] board) {
		for (int i = 0; i < 9; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			for (int j = 0; j < 9; j++) {
				if (Character.isDigit(board[i][j])) {
					if (set.contains(Character.getNumericValue(board[i][j]))) {
						return false;
					} else {
						set.add(Character.getNumericValue(board[i][j]));
					}
				}
			}
		}

		return true;
	}

	private boolean checkColumn(char[][] board) {
		for (int i = 0; i < 9; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			for (int j = 0; j < 9; j++) {
				if (Character.isDigit(board[j][i])) {
					if (set.contains(Character.getNumericValue(board[j][i]))) {
						return false;
					} else {
						set.add(Character.getNumericValue(board[j][i]));
					}
				}
			}
		}

		return true;
	}

	private boolean notInBox(char arr[][], int startRow, int startCol) {
		HashSet<Character> box = new HashSet<>();

		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				char curr = arr[row + startRow][col + startCol];

				if (box.contains(curr)) {
					return false;
				}

				if (curr != '.') {
					box.add(curr);
				}
			}
		}
		return true;
	}
    
    public static void main(String[] args) {
    	ValidSudoku sudoku = new ValidSudoku();
    	
    	char[][] board1 = 
    			{{'5','3','.','.','7','.','.','.','.'}
				,{'6','.','.','1','9','5','.','.','.'}
				,{'.','9','8','.','.','.','.','6','.'}
				,{'8','.','.','.','6','.','.','.','3'}
				,{'4','.','.','8','.','3','.','.','1'}
				,{'7','.','.','.','2','.','.','.','6'}
				,{'.','6','.','.','.','.','2','8','.'}
				,{'.','.','.','4','1','9','.','.','5'}
				,{'.','.','.','.','8','.','.','7','9'}};
    	System.out.println(sudoku.isValidSudoku(board1));
    	
    	char[][] board2 = 
    		{{'8','3','.','.','7','.','.','.','.'}
    		,{'6','.','.','1','9','5','.','.','.'}
    		,{'.','9','8','.','.','.','.','6','.'}
    		,{'8','.','.','.','6','.','.','.','3'}
    		,{'4','.','.','8','.','3','.','.','1'}
    		,{'7','.','.','.','2','.','.','.','6'}
    		,{'.','6','.','.','.','.','2','8','.'}
    		,{'.','.','.','4','1','9','.','.','5'}
    		,{'.','.','.','.','8','.','.','7','9'}};
    	System.out.println(sudoku.isValidSudoku(board2));
	}
}
