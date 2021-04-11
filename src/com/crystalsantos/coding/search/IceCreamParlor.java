package com.crystalsantos.coding.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class IceCreamParlor {

	static void whatFlavors(int[] flavours, int money) {
		List<Integer> choosedFlavours = new ArrayList<Integer>(2);
        if(flavours.length != 2) {
	        HashMap<Integer,Integer> mapFlavours = new HashMap<Integer,Integer>();
	        
	        mapFlavours.put(flavours[0], 1);
	        for(int i = 1; i < flavours.length; i++) {
	            Integer temp = mapFlavours.get(money - flavours[i]);
	            if(temp == null) {
	                mapFlavours.put(flavours[i], i+1);
	            } else {
	                if(i+1 >= temp) {
	                	choosedFlavours.add(temp);
	                	choosedFlavours.add(i+1);
	                } else {
	                	choosedFlavours.add(i+1);
	                	choosedFlavours.add(temp);
	                }
	            }
	        }
        } else {
        	//there are only two flavours
        	choosedFlavours.add(1);
        	choosedFlavours.add(2);
        }
        
        printFlavours(choosedFlavours);
        
	}
	
	static void printFlavours(List<Integer> flavours) {
		for(int i = 0; i < flavours.size(); i++) {
			System.out.print(flavours.get(i) + " ");
		}
		System.out.println();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int money = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] cost = new int[n];

			String[] costItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int costItem = Integer.parseInt(costItems[i]);
				cost[i] = costItem;
			}

			whatFlavors(cost, money);
		}

		scanner.close();
	}
}
