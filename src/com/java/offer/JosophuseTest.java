package com.java.offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JosophuseTest {

	public static int lastRemaining(List<Integer> list, int n){
		if(list == null || list.size() <= 0 || n < 1 ){
			return -1;
		}
		
		
		Iterator<Integer> iterator = list.iterator();
		while(list.size() > 1){
			for(int i = 1; i < n; i++){
				int current = iterator.next();
				
				if(current == list.listIterator(list.size() - 1).next()){
					System.out.println("back begin");
					iterator = list.listIterator(0);
					
				}
			}
			
			
			int tmp = iterator.next();
			System.out.println(list.size());
			System.out.println("1 round");
			System.out.println("remove " + tmp);
			Iterator<Integer> next = iterator;
			
			if(tmp == list.listIterator(list.size() - 1).next()){
				next = list.listIterator(0);
			}
			
			
			iterator.remove();
			iterator = next;
		}
		
		return iterator.next();
		
	}
	
	public static void main(String[] args) {
		
		
		List<Integer> list = new ArrayList<Integer>();

		int[] number = new int[]{0, 1, 2, 3, 4};
		for(int i = 0; i < number.length; i++){
			list.add(number[i]);
		}
		lastRemaining(list, 2);
	}

}
