package com.java.offer;

public class GetNumberOfKTest {

	public static int getNumberOfK(int[] numbers, int k){
		
		if(numbers == null || numbers.length <= 0){
			return 0;
		}
		
		int first = getFirstK(numbers, k, 0, numbers.length - 1);
		int last = getLastK(numbers, k, 0, numbers.length - 1);
		
		if(first > -1 && last > -1){
			return last - first + 1;
		}
		return 0;
		
	}
	private static int getFirstK(int[] numbers, int k, int start, int end) {
		
		int middle = (start + end) / 2;
		
		if(numbers[middle] == k){
			if((middle > start && numbers[middle - 1] != k ) || middle == start){
				return middle;
			}
			else{
				end = middle - 1;
			}
			
		}else if(numbers[middle] < k){
			start = middle + 1;
		}else{
			end = middle - 1;
		}
		return getFirstK(numbers, k, start, end);
	}
	private static int getLastK(int[] numbers, int k, int start, int end) {
		
		int middle = (start + end) / 2;
		if(numbers[middle] == k){
			if((middle < end && numbers[middle] != k) || middle == end){
				return middle;
			}else{
				start = middle + 1;
			}
		}else if(numbers[middle] > k){
			end = middle - 1;
		}else{
			start = middle + 1;
		}
		
		return getLastK(numbers, k, start, end);
	}
	public static void main(String[] args) {
		
		int[] numbers = new int[]{1, 2, 3, 3, 3, 3, 4, 5};
		System.out.println(getNumberOfK(numbers, 3));

	}

}
