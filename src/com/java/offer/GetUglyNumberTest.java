package com.java.offer;

public class GetUglyNumberTest {

	public static int getUgly(int k){
		
		if(k < 1){
			return 0;
		}
		int[]  numbers = new int[k];
		int count = 0;
		int t2 = 0;
		int t3 = 0;
		int t5 = 0;
		
		numbers[0] = 1;
		while(count < k - 1){
			int nextUgly = min(numbers[t2] * 2, numbers[t3] * 3, numbers[t5] * 5);
			
			numbers[++count] = nextUgly;
			
			while(numbers[t2] * 2 <= nextUgly){
				t2++;
			}
			
			while(numbers[t3] * 3 <= nextUgly){
				t3++;
			}
			
			while(numbers[t5] * 5 <= nextUgly){
				t5++;
			}
		}
		
		return numbers[k - 1];
		
	}
	
	//求三个数中最小的值
	private static int min(int i, int j, int k) {
		int min = Math.min(i,  j);
		return Math.min(min,  k);
	}
	public static void main(String[] args) {
		
		System.out.println(getUgly(1));

	}

}
