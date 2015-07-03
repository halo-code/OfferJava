package com.java.offer;

import java.util.Arrays;

public class FindNumberAppearOnceTest {

	public static void findNumberAppearOnce(int[] numbers, int[] result){
		if(numbers == null || numbers.length <= 2 || result == null || result.length < 2){
			return ;
		}
		
		int resultExclusiveOR = 0;
		for(int i = 0; i < numbers.length; i++){
			resultExclusiveOR ^= numbers[i];
		}
		
		//从低位开始第一个1
		int index = findFirstIndexOf1(resultExclusiveOR);
		for(int i = 0; i < numbers.length; i++){
			if(isBit1(numbers[i], index)){
				result[0] ^= numbers[i];
			}else{
				result[1] ^= numbers[i];
			}
		}
		
		
	}
	private static int findFirstIndexOf1(int resultExclusiveOR) {
		int flag = 1;
		int index = 0;
		while(flag != 0){
			if((resultExclusiveOR & flag) != 0){
				break;
			}
			flag = flag << 1;
			index ++;
		}
		System.out.println("index = " + index);
		return index;
	}
	
	private static boolean isBit1(int number, int index){
		return (number & (1 << index)) != 0;
			
		
	}
	public static void main(String[] args) {
		
		int[] numbers = new int[]{2, 4, 3, 6, 3, 2, 5, 5};
		int[] result = new int[2];
		
		findNumberAppearOnce(numbers, result);
		System.out.println(Arrays.toString(result));

	}

}
