package com.java.offer;

import java.util.Stack;

public class IsPopOrderTest {

	public static boolean isPopOrder(int[] pushOrder, int[] popOrder, int length) {
		boolean bPossible = false;

		if (pushOrder != null && popOrder != null && length >= 0) {
			Stack<Integer> stack = new Stack<Integer>();

			int pushId = 0;
			int popId = 0;

			// ���ûpop��
			while (popId < length) {
				while (stack.empty() || stack.peek() != popOrder[popId]) {

					// �Ѿ�û�п���ѹ��ջ��Ԫ�أ� ������в�����
					if (pushId == length) {
						break;
					}

					stack.push(pushOrder[pushId++]);

				}

				// ��ʵ������Ϊ��������һ��ѭ��
				if (stack.peek() != popOrder[popId]) {
					break;
				}

				stack.pop();
				popId++;
			}

			if (stack.empty() && popId == length) {
				bPossible = true;
			}

		}

		return bPossible;
	}

	public static void main(String[] args) {

		int[] push = { 1, 2, 3, 4, 5 };
		int[] pop = { 4, 3, 5, 2, 1 };

		System.out.println(isPopOrder(push, pop, 5));
	}

}
