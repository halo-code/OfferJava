package com.java.offer;

public class LeftRotateStringTest {

    public static char[] rotateLeftString(char[] str, int n){
    	if(str == null){
    		return null;
    	}
    	
    	if(n == 0 || n >= str.length){
    		return str;
    	}
    	
    	int firstStart = 0;
    	int firstEnd = n - 1;
    	
    	int secondStart = n;
    	int secondEnd = str.length - 1;
    	reverse(str, firstStart, firstEnd);
    	reverse(str, secondStart, secondEnd);
    	reverse(str, 0, str.length - 1);
    	return str;
    }
	
	private static void reverse(char[] str, int start, int end) {
		
		int middle = (start + end) / 2;
		while(start <= middle){
			char tmp = str[start];
			str[start] = str[end];
			str[end] = tmp;
			start++;
			end--;
		}
		
	}

	public static void main(String[] args) {

		System.out.println(String.valueOf(rotateLeftString("abcdef".toCharArray(), 2)));
	}

}
