package com.java.offer;

public class SumSolutionTest1 {

	static int num;
	static int sum;
	
	public SumSolutionTest1() {
		System.out.println("Construct called");
		num ++;
		sum += num;
	}
	
	public static int getSum(int n){
		SumSolutionTest1[] sumSolutionTest1 = new SumSolutionTest1[n];
		return sum;
	}
	public static void main(String[] args) {
		System.out.println(getSum(10));
	}
}
