package com.crystalsantos.coding.trees;

import java.io.IOException;
import java.util.Scanner;

public class BalancedForest {

    // Complete the balancedForest function below.
    static int balancedForest(int[] c, int[][] edges) {

    	return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] c = new int[n];

            String[] cItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int cItem = Integer.parseInt(cItems[i]);
                c[i] = cItem;
            }

            int[][] edges = new int[n - 1][2];

            for (int i = 0; i < n - 1; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            System.out.println(balancedForest(c, edges));
        }
        
        scanner.close();
    }
}
