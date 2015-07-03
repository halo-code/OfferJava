package com.java.offer;

public class FindGreatestSumOfSubArrayTest {

	public static boolean isValidInput = true;
	public static int findGreatestSum(int[] numbers){
		
		if(numbers == null || numbers.length <= 0){
			isValidInput = false;
			return 0;
		}
		int greatestSum = 0;
		int curSum = 0;
		for(int i = 0; i < numbers.length; i++){
			if(curSum <= 0){
				curSum = numbers[i];
			}else{
				curSum += numbers[i];
			}
			
			if(curSum > greatestSum){
				greatestSum = curSum;
			}
		}
		
		return greatestSum;
	}
	public static void main(String[] args) {
		
		int[] numbers = new int[]{1, -2, 3, 10, -4, 7, 2, -5};

		int result = findGreatestSum(numbers);
		
		if(result == 0 && !isValidInput){
			System.out.println("Invalid Input");
		}
		else{
			System.out.println("result = " + result);
		}
	}

}
