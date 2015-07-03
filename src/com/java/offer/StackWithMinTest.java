package com.java.offer;

import java.util.Stack;

public class StackWithMinTest {

	private static Stack<Integer> mStack = new Stack<Integer>();
	private static Stack<Integer> minStack = new Stack<Integer>();
	
	public static void push(Integer i){
		mStack.push(i);
		if(minStack.size() == 0 || i < minStack.peek()){
			minStack.push(i);
		}else{
			minStack.push(minStack.peek());
		}
	}
	
	public static void pop(){
		assert(mStack.size() > 0 && minStack.size() > 0);
		minStack.pop();
		mStack.pop();
	}
	
	public static Integer min(){
		assert(mStack.size() > 0 && minStack.size() > 0);
		return minStack.peek();
	}
	
	public static void main(String[] args) {
		
		push(3);
		System.out.println(min());
		push(4);
		System.out.println(min());
		push(2);
		System.out.println(min());
		push(1);
		System.out.println(min());
		pop();
		System.out.println(min());
		pop();
		System.out.println(min());
		push(0);
		System.out.println(min());
		

	}

}
