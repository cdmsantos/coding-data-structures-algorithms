package com.crystalsantos.coding.arrays;

import java.io.IOException;
import java.util.Scanner;

public class TwoDArraysDS {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int maxHourglassSum = Integer.MIN_VALUE;
        
        for(int i = 1; i < arr.length - 1; i++) {
            for(int j = 1; j < arr.length - 1; j++) {
                int hourglassSum = 0;
                hourglassSum += arr[i][j]; //middle
                hourglassSum += arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1]; //up
                hourglassSum += arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1]; //bottom
                
                if(hourglassSum > maxHourglassSum ) {
                    maxHourglassSum = hourglassSum;
                }
            }
        }

        return maxHourglassSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[][] arr = new int[6][6];

//        for (int i = 0; i < 6; i++) {
//            String[] arrRowItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int j = 0; j < 6; j++) {
//                int arrItem = Integer.parseInt(arrRowItems[j]);
//                arr[i][j] = arrItem;
//            }
//        }
        
        arr[0][0] = -1;
        arr[0][1] = -1;
        arr[0][2] = 0;
        arr[0][3] = -9;
        arr[0][4] = -2;
        arr[0][5] = -2;
        arr[1][0] = -2;
        arr[1][1] = -1;
        arr[1][2] = -6;
        arr[1][3] = -8;
        arr[1][4] = -2;
        arr[1][5] = -5;
        arr[2][0] = -1;
        arr[2][1] = -1; 
        arr[2][2] = -1;
        arr[2][3] = -2;
        arr[2][4] = -3;
        arr[2][5] = -4;
        arr[3][0] = -1;
        arr[3][1] = -9;
        arr[3][2] = -2;
        arr[3][3] = -4;
        arr[3][4] = -4;
        arr[3][5] = -5;
        arr[4][0] = -7;
        arr[4][1] = -3;
        arr[4][2] = -3;
        arr[4][3] = -2;
        arr[4][4] = -9;
        arr[4][5] = -9;
        arr[5][0] = -1;
        arr[5][1] = -3;
        arr[5][2] = -1;
        arr[5][3] = -2;
        arr[5][4] = -4;
        arr[5][5] = -5;

        int result = hourglassSum(arr);
        
        System.out.println(result);

        scanner.close();
    }
}
