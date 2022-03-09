package com.crystalsantos.codility;

public class TimeComplexityFrogJmp {

	public int solution(int X, int Y, int D) {
		return ((Y-X)%D) == 0 ? ((Y-X)/D) : ((Y-X)/D)+1;
	}
	
	public static void main(String[] args) {
		TimeComplexityFrogJmp frog = new TimeComplexityFrogJmp();
		System.out.println(frog.solution(10, 15, 30));
	}
}
