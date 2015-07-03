package com.java.offer;

import java.util.Set;
import java.util.TreeSet;

public class GetLeastNumbersTest {

	public static Set<Integer> getLeastNumbers(int[] numbers, int k){
		if(numbers == null || numbers.length < k){
			return null;
		}
		TreeSet<Integer> result = new TreeSet<Integer>();
		for(int i = 0; i < numbers.length; i++){
			if(result.size() < k){
				result.add(numbers[i]);
			}else if(result.last() > numbers[i]){
				result.pollLast();
				result.add(numbers[i]);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		
		int[] numbers = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
		for(Integer i :getLeastNumbers(numbers, 4)){
			System.out.println(i);
		}
		

	}

}
