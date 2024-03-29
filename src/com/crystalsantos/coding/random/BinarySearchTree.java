package com.crystalsantos.coding.random;

public class BinarySearchTree {
	class Node {

		Node left, right;
		int data;

		public Node(int data) {
			this.data = data;
		}

		public void insert(int newData) {
			if (newData <= data) {
				if (left == null) {
					left = new Node(newData);
				} else {
					left.insert(newData);
				}
			} else {
				if (right == null) {
					right = new Node(newData);
				} else {
					right.insert(newData);
				}
			}
		}

		public boolean contains(int searchData) {
			if (searchData == data) {
				return true;
			} else if (searchData < data) {
				if (left == null) {
					return false;
				} else {
					left.contains(searchData);
				}
			} else {
				if (right == null) {
					return false;
				} else {
					right.contains(searchData);
				}
			}
			return false;
		}

		public void printInOrder() {
			if (left != null) {
				left.printInOrder();
			}
			System.out.println(data);
			if (right != null) {
				right.printInOrder();
			}
		}

		public void printPreOrder() {
			System.out.println(data);
			if (left != null) {
				left.printPreOrder();
			}

			if (right != null) {
				right.printPreOrder();
			}
		}
		
		public void printPostOrder() {
			if (left != null) {
				left.printPreOrder();
			}

			if (right != null) {
				right.printPreOrder();
			}
			System.out.println(data);
		}
	}
}
