package com.java.offer;

public class PrintMatrixInCircleTest {

	
	public static void printMatrixClockwisely(int[][] numbers, int columns, int rows){
		if(numbers == null || columns <= 0 || columns <= 0){
			return;
		}
		
		int start = 0;
		
		while(columns > start * 2 && rows > start * 2){
			printMatrixIncCircle(numbers, columns, rows, start);
			start ++;
		}
	}
	public static void printMatrixIncCircle(int[][] numbers, int columns,
			int rows, int start) {
		
		int endX = columns - 1 - start;
		int endY = rows - 1 - start;
		
		for(int i = start; i <= endX; i++){
			System.out.println(numbers[start][i]);
		}
		
		if(endY > start){
			for(int i = start + 1; i <= endY; i++){
				System.out.println(numbers[i][endX]);
			}
		}
		
		if(endY > start && endX > start){
			for(int i = endX - 1; i >= start; i--){
				System.out.println(numbers[endY][i]);
			}
		}
		
		if(endY - start > 1 && endX > start){
			for(int i = endY - 1; i >= start + 1; i--){
				System.out.println(numbers[i][start]);
			}
		}
		
	}
	public static void main(String[] args) {

		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		printMatrixClockwisely(matrix, 4,  4);
	}

}
