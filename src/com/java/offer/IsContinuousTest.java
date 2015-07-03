package com.java.offer;

import java.util.Arrays;

public class IsContinuousTest {


	public static boolean isContinuous(int[] numbers){
		if(numbers == null || numbers.length <= 0){
			return false;
		}
		
		Arrays.sort(numbers);
		
		int numberGap = 0;
		int zeroCount = 0;
		for(int i = 0; i < numbers.length; i++){
			if(numbers[i] == 0){
				zeroCount ++;
			}
		}
		
		int small = zeroCount;
		int big = zeroCount + 1;
		
		while(big < numbers.length){
			if(numbers[small] == numbers[big]){
				return false;
			}
			
			else{
				numberGap += (numbers[big] - numbers[small] - 1);
				small ++;
				big ++;
			}
			
		}
		
		if(zeroCount < numberGap){
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {

		System.out.println(isContinuous(new int[]{0, 1, 3, 4, 6}));
	} 

}
