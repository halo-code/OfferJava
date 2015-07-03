package com.java.offer;

public class ReplcaceSapce {

	public static void replace(char[] str, int allLength){
		
		if(str == null && allLength <= 0){
			return;
		}
		
		//str中有效字符的个数，要减去最后一个'\0'
		System.out.println(str.length);
		int originalLength = 0;
		int i = 0;
		int blankCount = 0;
		while(str[i] != '\0'){
			originalLength++; 
			if(str[i] == ' '){
				blankCount++;
			}
			i++;
		}
		
		System.out.println("originalLength = " + originalLength);
		System.out.println("blankCount = " + blankCount);
		
		
		//从后往前复制
		int desLength = originalLength + blankCount * 2;
		if(desLength > allLength){
			return;
		}
		int indexOfOriginal = originalLength;
		int indexOfDes = desLength;
		
		while(indexOfOriginal >= 0 && indexOfDes > indexOfOriginal){
			if(str[indexOfOriginal] == ' '){
				str[indexOfDes--] = '0';
				str[indexOfDes--] = '2';
				str[indexOfDes--] = '%';
			}
			else{
				str[indexOfDes--] = str[indexOfOriginal];
			}
			indexOfOriginal--;
		}
		
		
	}
	
	public static void main(String[] args) {
		char[] string = new char[1024];
		//System.out.println("length = " + string);
		String s = "We are happy";
		for(int i = 0; i < s.length(); i ++){
			string[i] = s.charAt(i);
			
		}
		string[s.length()] = '\0';
		
		replace(string, 1024);
		for(int i = 0 ; i < 1024; i++){
			System.out.print(string[i]);
		}
		

	}

}
