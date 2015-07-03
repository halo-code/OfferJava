package com.java.offer;

public class FindMoreThanHalfNumTest {

	public static int find(int[] num) {
		if (num == null) {
			return 0;
		}

		int result = num[0];
		int times = 1;
		for (int i = 1; i < num.length; i++) {
			if (times == 0) {
				times = 1;
				result = num[i];
			} else if (result == num[i]) {
				times++;
			} else {
				times--;
			}
		}

		if (!checkMoreThanHalf(num, result)) {
			result = 0;
		}

		return result;
	}

	private static boolean checkMoreThanHalf(int[] num, int result) {
		int times = 0;
		for(int i = 0 ; i < num.length; i++){
			if(num[i] == result){
				times ++;
			}
		}
		
		if(times >= num.length / 2){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		int[] numbers = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
		System.out.println(find(numbers));
		
	}

}
