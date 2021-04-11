package com.crystalsantos.coding.random;

import java.util.Scanner;

public class BinarySearchTreeInsertion {
   
    static class Node {
        Node left;
        Node right;
        int data;
        
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static void preOrder( Node root ) {
      
        if( root == null)
            return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }

    public static Node insert(Node root,int data) {
        if(root == null) {
            root = new Node(data);
        } else {
            if(data <= root.data) {
                if(root.left == null) {
                    root.left = new Node(data);
                } else {
                    insert(root.left, data);
                }
            } else {
                if(root.right == null) {
                    root.right = new Node(data);
                } else {
                    insert(root.right, data);
                }
            }        
        }
        
        return root;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }   
}