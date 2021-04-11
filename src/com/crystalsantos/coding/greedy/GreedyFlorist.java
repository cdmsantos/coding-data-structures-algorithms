package com.crystalsantos.coding.greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GreedyFlorist {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int friends, int[] pricesArray) {
    	int minimumCost = 0;
    	Integer[] prices = Arrays.stream(pricesArray).boxed().toArray( Integer[]::new );
    	Arrays.sort(prices, Collections.reverseOrder());

    	int previousPurchase = 1;
    	int friendsInThisPurchase = 0;
    	for(int i = 0; i < prices.length; i++) {
    		if(i < friends) {
    			minimumCost += prices[i];
    		} else {
    			if(friendsInThisPurchase < friends) {
    				friendsInThisPurchase++;
    			} else {
    				previousPurchase++;
    				friendsInThisPurchase = 1;
    			}
    			minimumCost += (previousPurchase + 1) * prices[i];
    		}
    	}
    	return minimumCost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        System.out.println(getMinimumCost(k, c));
        scanner.close();
    }
}
