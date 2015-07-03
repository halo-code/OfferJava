package com.java.offer;

public class PowerTest {

	private static boolean inValidInput;

	public static double power(double base, int exponent) {

		if (equal(base, 0) && exponent < 0) {
			inValidInput = true;
			return 0;
		}

		int absExponent = exponent;
		if (exponent < 0) {
			absExponent = -exponent;
		}

		double result = powerWithUnsignedExponentEfficent(base, absExponent);
		if (exponent < 0) {
			result = 1.0 / result;
		}
		return result;
	}

	private static double powerWithUnsignedExponent(double base, int absExponent) {
		double result = 1.0;
		for (int i = 1; i <= absExponent; i++) {
			result *= base;
		}
		return result;
	}

	private static double powerWithUnsignedExponentEfficent(double base,
			int absExponent) {
		if (absExponent == 0) {
			return 1;
		}
		if (absExponent == 1) {
			return base;
		}

		double result = powerWithUnsignedExponentEfficent(base,
				absExponent >> 1);
		result *= result;
		if ((absExponent & 0x01) == 1) {
			result *= base;
		}

		return result;
	}

	public static boolean equal(double a, double b) {
		if (a - b > -0.0000001 && a - b < 0.0000001) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		double result = power(0.1, -2);
		if (inValidInput) {
			System.out.println("ÊäÈëÓÐÎó");
		} else {
			System.out.println("result = " + result);
		}
	}

}
