package com.java.offer;

public class StrToIntTest {

	public static boolean unValidInput = false;

	public static int strToInt(char[] str) {

		if (str == null || str.length <= 0) {
			unValidInput = true;
			return 0;
		}

		boolean minus = false;
		long num = 0;
		int index = 0;
		if (str[index] == '+') {
			index++;
		}else if(str[index] == '-'){
			minus = true;
			index++;
		}
		
		if(index != str.length){
			num = strToIntCore(str, index, minus);
		}
		
		return (int)(num * (minus ? -1 : 1));
		
	}

	private static long strToIntCore(char[] str, int index, boolean minus) {
		
		long num = 0;
		while(index < str.length){
			if(str[index] > '0' || str[index] < '9'){
				int flag = minus ? -1 : 1;
				
				//num = num * 10 + flag * (str[index] - '0');
				num = num * 10 + (str[index] - '0');
				
				if((!minus && (num > 0x7FFFFFFF)) ||(minus && (num < 0x8FFFFFFF))){
					num = 0;
					break;
				}
				
				index++;
				
			}
			else{
				num = 0;
				break;
			}
		}
		
		if(index == str.length){
			unValidInput = true;
		}
		return num;
	}

	public static void main(String[] args) {
		
		System.out.println(strToInt("+1".toCharArray()));

	}

}
