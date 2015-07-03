package com.java.offer;

public class FindContinuousSequences {

	public static void findContinuousSequences(int sum){
		
		int small = 1;
		int big = 2;
		int middle = (sum + 1) / 2;
		int curSum = small + big;
		while(small < middle){
			if(curSum == sum){
				printFromSmallToBig(small, big);
				big++;
				curSum += big;
			}else if(curSum < sum){
				big++;
				curSum += big;
			}else{
				curSum -= small;
				small ++;
			}
		}
	}
	private static void printFromSmallToBig(int small, int big) {
		
		for(int i = small; i <= big; i++){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		
		findContinuousSequences(3);

	}

}
