package com.java.offer;

public class Test10 {

	static int NumberOf1VersionError(int n){
		int count = 0;
		while(n != 0){
			if( (n & 1) != 0){
				count++;
			}
			n = n >> 1;
		}
		
		return count;
	}
	
	static int NumberOf1Version1(int n) {
		int flag = 1;
		int count = 0;
		while (flag != 0) {
			if ((n & flag) != 0) {
				count++;
			}
			flag = flag << 1;
		}

		return count;
	}

	static int NumberOf1Version2(int n) {
		int count = 0;

		while (n != 0) {
			count++;
			// 消除掉最右侧的1,能消除几次就表示有几个1
			n = n & (n - 1);
		}
		return count;
	}

	public static void main(String[] args) {

		System.out.println(NumberOf1VersionError(-127));
		System.out.println(NumberOf1Version1(-127));
		System.out.println(NumberOf1Version2(-127));

	}

}
