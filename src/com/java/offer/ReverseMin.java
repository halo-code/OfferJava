package com.java.offer;

public class ReverseMin {

	public static int min(int[] numbers, int length) throws Exception {
		if (numbers == null || length <= 0) {
			throw new Exception("Invalid parameters");
		}

		int index1 = 0;
		int index2 = length - 1;

		// 初始化为index1是为了判断旋转个数为0的情况
		int midIndex = index1;
		while (numbers[index1] >= numbers[index2]) {
			if (index2 - index1 == 1) {
				midIndex = index2;
				break;
			}

			midIndex = (index1 + index2) / 2;

			//如果三个值都相等，就无法判断在那个区间
			if (numbers[index1] == numbers[midIndex]
					&& numbers[midIndex] == numbers[index2]) {
				return minInOrder(numbers, index1, index2);

			}
			if (numbers[midIndex] >= numbers[index1]) {
				index1 = midIndex;
			} else if (numbers[midIndex] < numbers[index2]) {
				index2 = midIndex;
			}
		}
		return numbers[midIndex];
	}

	private static int minInOrder(int[] numbers, int index1, int index2) {
		int result = numbers[index1];
		for (int i = index1 + 1; i <= index2; i++) {
			if (result > numbers[i]) {
				result = numbers[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		
		int[] a = {3, 4, 5, 1, 1, 2};
		int[] b = {1, 0, 1, 1, 1};
		int[] c = {};
		try {
			System.out.println(min(a, a.length));
			System.out.println(min(b, b.length));
			System.out.println(min(c, c.length));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
