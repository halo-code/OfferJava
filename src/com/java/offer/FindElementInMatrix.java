package com.java.offer;

import java.util.Scanner;

public class FindElementInMatrix {

	public static boolean find(int[] data, int rows, int columns, int val) {

		if (data != null && rows > 0 && columns > 0) {
			// �����궨λ�����Ͻǣ�Ҳ����ѡΪ���½�
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

		int m = 0;// ����
		int n = 0;// ����

		int value = 0; // �����ҵ�ֵ
		int[] data;
		
		Scanner in = new Scanner(System.in);
		

		while (in.hasNext()) {
			m = in.nextInt();// ����
			n = in.nextInt();// ����

			value = in.nextInt(); // �����ҵ�ֵ
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
