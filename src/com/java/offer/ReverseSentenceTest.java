package com.java.offer;


public class ReverseSentenceTest {

	public static void reverse(char[] str, int start, int end) {
		int middle = (end - start) / 2;
		for (int i = 0; i <= middle; i++) {

			char tmp = str[start + i];
			str[start + i] = str[end - i];
			
			str[end - i] = tmp;
			
			
			System.out.println(String.valueOf(str));
		}
	}

	public static char[] reverseSentence(char[] str) {
		if (str == null || str.length <= 0) {
			return null;
		}

		reverse(str, 0, str.length - 1);
		System.out.println(String.valueOf(str));
		int start = 0, end = 0;
		int i = 0;
		while (start < str.length - 1) {

			if (str[start] == ' ') {
				start++;
				end++;
			}

			else if (end == str.length ||str[end] == ' ') {
				System.out.println("reverse from " + start + " to " + (end - 1));
				reverse(str, start, --end);
				//System.out.println("reverse from " + start + " to " + end);
				System.out.println(String.valueOf(str));
				start = ++end;
			} else {
				end++;
			}
			i++;
		}
		return str;

	}

	public static void main(String[] args) {

		System.out.println(String.valueOf(reverseSentence("abcdef cd"
				.toCharArray())));

	}

}
