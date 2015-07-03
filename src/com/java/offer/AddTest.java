package com.java.offer;

public class AddTest {

	public static int add(int a, int b){
		int sum = 0, carry = 0;
		
		do{
			sum = a ^ b;
			carry = (a & b) << 1;
			
			a = sum;
			b = carry;
		}while(carry != 0);
		
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(add(5, 17));
	}
	
}
