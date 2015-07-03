package com.java.offer;

import java.util.ArrayList;
import java.util.List;

public class CombinationRecursivelyTest {

	public static void combination(char[] str){
		if(str == null){
			return ;
		}
		for(int i = 1; i < str.length; i++){
			List<Character> list = new ArrayList<Character>();
			combination(str, 0, str.length, i, list);
			System.out.println();
		}
		
	}
	private static void combination(char[] str, int start, int end, int count, List<Character> list) {
		if(start >= end){
			for(Character c : list){
				System.out.print(c + " ");
			}
			
		}else{
			combination(str, start + 1, end, count, list);
			
			list.add(str[start]);
			combination(str, start + 1, end, count - 1, list);
		}
		
	}
	public static void main(String[] args) {

		char[] a = new char[]{'a', 'b', 'c'};
		combination(a);
	}

}
