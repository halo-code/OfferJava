package com.java.offer;

import java.math.BigInteger;

public class Print1ToMaxOfDigits {

	public static void printWithBigInteger(int n) {
		if (n <= 0) {
			return;
		}

		BigInteger number = BigInteger.ONE;
		int i = 0;
		while (i++ < n) {
			number = number.multiply(BigInteger.TEN);
		}

		for (BigInteger j = BigInteger.ZERO; j.compareTo(number) < 0; j = j
				.add(BigInteger.ONE)) {
			System.out.println(j);
		}
	}

	public static void printWithoutBigInteger(int n) {
		if (n <= 0) {
			return;
		}

		char[] number = new char[n];

		// ��ʼ��Ϊ0
		for (int i = 0; i < n; i++) {
			number[i] = '0';
		}

		// һֱ��number��+1,ֱ�����������
		while (!increment(number)) {

			printNumber(number);
		}
	}

	/**
	 * number++�������ж��Ƿ��Ѿ��ﵽ��������
	 * 
	 * @param number
	 *            ��ǰ��
	 * @return �Ƿ񻹿��Լ�������
	 */
	private static boolean increment(char[] number) {

		// �Ƿ��������ʾ�Ƿ�ﵽ�����
		boolean isOverFlow = false;
		// ��λ
		int nTakeOver = 0;

		int nLength = number.length;

		for (int i = nLength - 1; i >= 0; i--) {

			int nSum = number[i] - '0' + nTakeOver;
			if (i == nLength - 1) {
				nSum++;
			}
			if (nSum >= 10) {
				if (i == 0)
					isOverFlow = true;
				else {
					nSum -= 10;
					nTakeOver = 1;
					number[i] = (char) ('0' + nSum);
				}
			} else {
				number[i] = (char) ('0' + nSum);
				break;
			}

		}

		return isOverFlow;
	}

	/**
	 * ��ӡ��ǰ��
	 * 
	 * @param number
	 *            ��ǰ��
	 */
	private static void printNumber(char[] number) {

		boolean isBegining0 = true;
		int nLength = number.length;

		for (int i = 0; i < nLength; i++) {
			if (isBegining0 && number[i] != '0') {
				isBegining0 = false;
			}

			if (!isBegining0) {
				System.out.print(number[i]);
			}
		}
		System.out.println(); 
	}

	public static void main(String[] args) {

		printWithoutBigInteger(2);
	}

}
