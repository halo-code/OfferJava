package com.java.offer;

import java.util.Stack;

public class CQueue<T> {

	
	private Stack<T> stack1;
	private Stack<T> stack2;
	
	public CQueue(){
		this.stack1 = new Stack<T>();
		this.stack2 = new Stack<T>();
	}
	public void appendTail(T element){
		stack1.push(element);
	}
	
	public T deleteTail() throws Exception{
		if(stack2.size() <= 0){
			//如果stack2为空，将stack1中的全部弹出，放入stack2中
			while(stack1.size() > 0){
				T data = stack1.pop();
				stack2.push(data);
			}
		}
		
		if(stack2.size() == 0){
			throw new Exception("Queue is Empty");
		}
		T head = stack2.pop();
		return head;
	}
	
	public boolean isEmpty(){
		if(stack1.size() == 0 && stack2.size() == 0){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {

		CQueue<Integer> queue = new CQueue<Integer>();
		for(int i = 0; i < 10; i++){
			queue.appendTail(i);
		}
		
		try {
			while(!queue.isEmpty())
			System.out.println(queue.deleteTail());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
