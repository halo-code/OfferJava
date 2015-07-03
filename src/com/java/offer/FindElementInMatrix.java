package com.java.offer;

import java.util.Scanner;

public class FindElementInMatrix {

	public static boolean find(int[] data, int rows, int columns, int val) {

		if (data != null && rows > 0 && columns > 0) {
			// 将坐标定位的右上角，也可以选为左下角
			int row = 0;
			int column = columns - 1;
			while (row < rows && column >= 0) {
				int tmp = data[row * columns + column];
				if (tmp == val) {
					return true;
				} else if (tmp > val) {
					column--;
				} else {
					row++;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {

		int m = 0;// 行数
		int n = 0;// 列数

		int value = 0; // 待查找的值
		int[] data;
		
		Scanner in = new Scanner(System.in);
		

		while (in.hasNext()) {
			m = in.nextInt();// 行数
			n = in.nextInt();// 列数

			value = in.nextInt(); // 待查找的值
			data = new int[m * n];
		
			
			for (int i = 0; i < m * n; i++) {
				data[i] = in.nextInt();
			}
			if (find(data, m, n, value)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			data = null;
		}

	}

}
