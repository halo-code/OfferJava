package com.java.offer;

import java.util.ArrayList;
import java.util.List;

public class CombinationTest {

	public static boolean testBit(int num, int position){
		return ((num & (0x01<<position)) != 0 ? true : false);
	}
	
	public static void combination(char[] str){
		if(str == null){
			return ;
		}
		int n = str.length;
		List<Character> result = new ArrayList<Character>();
		
		for(int i = 1; i < Math.pow(2, n); i++){
			result.clear();
			for(int j = 0; j < n; j++){
				if(testBit(i, j)){
					result.add(str[j]);
				}
			}
			
			System.out.println(result);
		}
	}
	public static void main(String[] args) {
		
		char[] str = new char[]{'a', 'b', 'c'};
		
		combination(str);

	}

}
