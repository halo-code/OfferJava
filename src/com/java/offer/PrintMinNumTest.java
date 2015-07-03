package com.java.offer;

import java.util.Arrays;
import java.util.Comparator;

public class PrintMinNumTest {

	 
	public static String[] printMinNum(int[] numbers){
		String[] str = new String[numbers.length];
		for(int i = 0; i < numbers.length; i++){
			str[i] = String.valueOf(numbers[i]);
		}
		
		Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String str1, String str2) {
				String str3 = str1 + str2;
				String str4 = str2 + str1;
				return str3.compareTo(str4);
			}

		});
		
		return str;
	}                                                                     
	
	public static void main(String[] args) {
		
		int[] numbers = new int[]{3, 32, 321};
		
		for(String str : printMinNum(numbers)){
			System.out.print(str);
		}

	}

}
