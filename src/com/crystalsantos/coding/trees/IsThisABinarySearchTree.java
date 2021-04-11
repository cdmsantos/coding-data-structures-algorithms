package com.crystalsantos.coding.trees;

import java.util.ArrayList;
import java.util.Scanner;

public class IsThisABinarySearchTree {

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
	
    static boolean checkBST(Node root) {
    	ArrayList<Integer> datas = new ArrayList<Integer>();
        boolean check = true;
        if(datas.contains(root.data)) {
            check= false;
        } else {
            datas.add(root.data);
            if(root.left != null) {
                check = checkBST(root.left, root.data, datas, true);
            } if(root.right != null) {
                check = checkBST(root.right, root.data, datas, false);
            }
        }
        
        return check;
    }

    static boolean checkBST(Node root, int lastData, ArrayList<Integer> datas, boolean left) {
        boolean check = true;
        if(datas.contains(root.data)) {
            check = false;
        } else {
        	datas.add(root.data);
            if(left) {
                if(root.data > lastData) {
                    check = false;
                } else {
                    if(root.left != null) {
                        check = checkBST(root.left, root.data, datas, true);
                    } if(root.right != null) {
                        check = checkBST(root.right, root.data, datas, false);
                    }
                }
            } else {
                if(root.data < lastData) {
                    return false;
                } else {
                    if(root.left != null) {
                        check = checkBST(root.left, root.data, datas, true);
                    } if(root.right != null) {
                        check = checkBST(root.right, root.data, datas, false);
                    }
                }
            }
        }
        
        return check;
    }
    
	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		
		System.out.println(checkBST(root));
		scan.close();
	}
}
