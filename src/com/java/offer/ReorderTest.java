package com.java.offer;

import java.util.Arrays;

interface JudgeMent{
	boolean judge(int i);
}

public class ReorderTest {

	public static void reorder(int[] data, JudgeMent judgeMent){
		
		if(data == null || data.length == 0){
			return;
		}
		
		int start = 0;
		int end = data.length - 1;
		
		while(start < end){
			while(start < end && judgeMent.judge(data[start])){
				start++;
			}
			while(start < end && !judgeMent.judge(data[end])){
				end--;
			}
			
			if(start < end){
				int tmp = data[start];
				data[start] = data[end];
				data[end] = tmp;
			}
			
		}
	}
	
	


	public static void main(String[] args) {

		JudgeMent judgeMent = new JudgeMent() {
			
			@Override
			public boolean judge(int i) {

				if((i & 1) == 0){
					return false;
				}
				return true;
			}
		};
		
		int a[] = new int[]{1, 2, 3, 4, 5};
		reorder(a, judgeMent);
		System.out.println(Arrays.toString(a));
		
		int b[] = null;
		reorder(b, judgeMent);
		System.err.println(Arrays.toString(b));
	}

}
