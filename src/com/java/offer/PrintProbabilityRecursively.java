package com.java.offer;

public class PrintProbabilityRecursively {

	public static final int maxValue = 6;
	public static void printProbability(int number){
		if(number < 1){
			return;
		}
		
		int maxSum = maxValue * number;
		int[] probabilites = new int[maxSum - number + 1];
		
		probability(number, probabilites);
		
		int total = (int) Math.pow(maxValue, number);
		
		for(int i = number; i <= maxSum; i++){
			double ratio = (double)probabilites[i - number] / total;
			System.out.println("sum = " + i + "probability of appearing is " + ratio);
		}
	}
	private static void probability(int number, int[] probabilites) {
		
		for(int i = 1; i <= maxValue; i++){
			probability(number, number, i, probabilites);
		}
	}
	private static void probability(int original, int current, int sum, int[] probabilities) {
		
		if(current == 1){
			probabilities[sum - original] ++;
		}
		else{
			for(int i = 1; i <= maxValue; i++){
				probability(original, current - 1, sum + i, probabilities);
			}
		}
		
		
	}
	public static void main(String[] args) {
		
		printProbability(2);

	}

}
