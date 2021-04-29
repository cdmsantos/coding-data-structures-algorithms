package com.crystalsantos.coding.recursion;

public class PowXN {
	public double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}

		if (n == 1) {
			return x;
		}

		double half = myPow(x, n / 2);
		
		if (n % 2 == 0) {
			return half * half;
		} else if (n > 0) {
			return half * half * x;
		} else {
			return half * half / x;
		}
	}

	public static void main(String[] args) {
		PowXN pow = new PowXN();
		System.out.println(pow.myPow(0.00001, 2147483647));
	}
}
