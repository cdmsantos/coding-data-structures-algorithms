package com.crystalsantos.coding.greedy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LuckBalance {

	// Complete the luckBalance function below.
	static int luckBalance(int k, int[][] contests) {
		int luckBalance = 0;
		ArrayList<Integer> importantContests = new ArrayList<Integer>();
		if(k == 0) {
			for(int i = 0; i < contests.length; i++ ) {
				if(contests[i][1] == 0) {
					luckBalance += contests[i][0];
				} else {
					luckBalance -= contests[i][0];					
				}
			}
		} else {			
			for(int i = 0; i < contests.length; i++ ) {
				if(contests[i][1] == 1) {
					importantContests.add(contests[i][0]);
				}
				luckBalance += contests[i][0];
			}
			
			if (k > 0 && k < importantContests.size()) {
				int loseContests = importantContests.size() - k;
				Collections.sort(importantContests);
				for(int i = 0; i < loseContests; i++) { //index-0 base
					luckBalance -= importantContests.get(i)*2;
				}
			}
		}
		
		return luckBalance;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[][] contests = new int[n][2];

		for (int i = 0; i < n; i++) {
			String[] contestsRowItems = scanner.nextLine().split(" ");

			for (int j = 0; j < 2; j++) {
				int contestsItem = Integer.parseInt(contestsRowItems[j]);
				contests[i][j] = contestsItem;
			}
		}

		System.out.println(luckBalance(k, contests));

		scanner.close();
	}
}
