package com.java.offer;

public class FirstNotRepeatingCharTest {

	public static char findFirstNotRepeating(char[] str){
		if(str == null || str.length <= 0){
			return '\0';
		}
		int[] hash = new int[256];
		for(int i = 0; i < str.length; i++){
			hash[str[i]]++;
		}
		
		for(int i = 0; i < str.length; i++){
			if(hash[str[i]] == 1){
				return str[i];
			}
		}
		return '\0';
	}
	
	public static void main(String[] args) {

		String string = "abbaccddeff";
		System.out.println(findFirstNotRepeating(string.toCharArray()));
	}

}
