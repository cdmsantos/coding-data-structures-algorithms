package com.crystalsantos.coding.random;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfQueries = scanner.nextInt();

        Stack<Integer> one = new Stack<Integer>();
        Stack<Integer> two = new Stack<Integer>();

        for (int i = 0; i < numberOfQueries; i++) {
            int option = scanner.nextInt();
            if (option == 1) {
                one.push(scanner.nextInt());
            } else if (option == 2) {
                if (two.isEmpty()) {
                    while(!one.isEmpty()) {
                        two.push(one.pop());
                    }
                }
                
                if(!two.isEmpty()) {
                    two.pop();
                }
            } else {
                if(two.isEmpty()) {
                    while(!one.isEmpty()) {
                        two.push(one.pop());
                    }
                    
                    System.out.println(two.peek());
                } else {
                    System.out.println(two.peek());
                }
            }

        }

        scanner.close();
    }
}