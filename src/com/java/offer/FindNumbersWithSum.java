package com.java.offer;

import java.util.Arrays;

public class FindNumbersWithSum {

	
	public static boolean findNumbersWithSum(int[] numbers, int sum, int[] result){
		
		boolean found = false;
		if(numbers == null || result == null){
			return found;
		}
		
		int head = 0;
		int tail = numbers.length - 1;
		
		while(head < tail){
			
			int tempSum = numbers[head] + numbers[tail];
			if(tempSum == sum){
				result[0] = numbers[head];
				result[1] = numbers[tail];
				found = true;
				break;
			}else if(tempSum < sum){
				head ++;
			}else{
				tail -- ;
			}
			
		}
		
		return found;
	}
	public static void main(String[] args) {

		int[] numbers = new int[]{1, 2, 4, 7, 11, 15};
		int[] result = new int[2];
		if(findNumbersWithSum(numbers, 15, result)){
			System.out.println(Arrays.toString(result));
		}
	}

}
