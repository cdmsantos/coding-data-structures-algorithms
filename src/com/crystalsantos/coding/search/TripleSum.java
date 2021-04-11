package com.crystalsantos.coding.search;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TripleSum {

	   // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
    	long triplets = 0;
    	
    	a = Arrays.stream(a).distinct().toArray();
    	Arrays.sort(a);
    	
    	b = Arrays.stream(b).distinct().toArray();
    	Arrays.sort(b);
    	
    	c = Arrays.stream(c).distinct().toArray();
    	Arrays.sort(c);
  
    	for(int k = 0; k < b.length; k++) {
    		long aElements = 0; 
    		long cElements = 0; 
    		
    		for(int i = 0; i < a.length && a[i] <= b[k]; i++) {
    			aElements++;
    		}
    		
       		for(int j = 0; j < c.length && c[j] <= b[k]; j++) {
    			cElements++;
    		}
       		
       		triplets += aElements * cElements;
    	}
    	
    	
    	return triplets;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        System.out.println(triplets(arra, arrb, arrc));
        scanner.close();
    }
}
