package com.java.offer;

import java.util.Stack;

public class PrintListReversingly {

	static class ListNode{
		int mKey;
		ListNode mNext;
		public  ListNode(){
			this(0);
		}
		
		public ListNode(int key){
			this.mKey = key;
			this.mNext = null;
		}
	}
	public static void print(ListNode node){
		Stack<Integer> stack = new Stack<Integer>();
		while(node != null){
			stack.push(node.mKey);
			node = node.mNext;
			
		}
		Integer value;
		while(!stack.empty()){
			value = stack.pop();
			System.out.println(value);
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//构造一个链表，用于测试
		ListNode p = new ListNode();
		ListNode head = p;
		for(int i = 1; i < 10; i++){
			ListNode node = new ListNode(i);
			p.mNext = node;
			p = p.mNext;
			
		}
		
		print(head);
	}

}
