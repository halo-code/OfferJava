package com.java.offer;

import java.math.BigInteger;

public class Fibonacci {
	
	//µ›πÈÀ„∑®
	public  static BigInteger fibonacci(int n){
		if(n == 1){
			return BigInteger.valueOf(1);
		}
		if(n <= 0){
			return BigInteger.valueOf(0);
		}
		
		return fibonacci(n - 1).add(fibonacci(n - 2));
	}
	//∑«µ›πÈÀ„∑®
	public static BigInteger fibonacciAdvance(int n){
		int[] result = {0, 1};
		if(n < 2){
			return BigInteger.valueOf(result[n]);
		}
		
		BigInteger fibNMinusOne = BigInteger.ONE;
		BigInteger fibNMinusTwo = BigInteger.ZERO;
		BigInteger fibN = BigInteger.ZERO;
		
		for (int i = 2; i <= n; i++) {
			//f[i] = f[i-1] + f[i-2]
			fibN = fibNMinusOne .add(fibNMinusTwo);
			//f[i-2] = f[i-1]
			fibNMinusTwo = fibNMinusOne;
			//f[i-1] = f[i]
			fibNMinusOne = fibN;
		}
		return fibN;
		
	}
	public static void main(String[] args) {
		
		System.out.println(fibonacci(20));
		System.out.println(fibonacciAdvance(20));

	}

}
