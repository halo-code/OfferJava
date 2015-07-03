package com.java.offer;

public class DeleteNode {


	static class ListNode{
		int val;
		ListNode next; 
		
		ListNode(int v){
			this.val = v;
		}
	}
	public static ListNode delete(ListNode head, ListNode toBeDelete){
		if(head == null || toBeDelete == null){
			return null;
		}
		
		//不是尾结点
		if(toBeDelete.next != null){
			ListNode node = toBeDelete.next;
			toBeDelete.val = node.val;
			toBeDelete.next = node.next;
			
			node = null;
			
		}
		//只有一个结点，删除头结点
		else if(head == toBeDelete){
			toBeDelete = null;
			head = null;
			return null;
		}
		//多个结点，删除尾结点
		else{
			ListNode node = head;
			while(node.next != toBeDelete){
				node = node.next;
			}
			
			node.next = null;
			toBeDelete = null;
		}
		return head;
		
	}
	
	public static void print(ListNode head){
		if(head == null){
			System.out.println("list is null");
		}
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
	public static void main(String[] args) {
		
		//测试代码
		ListNode head = null;
		print(delete(head, head));
		head = new ListNode(0);
		ListNode p = head;
		
		//(1)只有一个结点，删除尾结点(也是头结点)
		print(delete(head, head));
		for(int i = 1; i < 5; i++){
			
			ListNode node = new ListNode(i);
			p.next = node;
			p = p.next;
		}
		
		ListNode tail = new ListNode(5);
		p.next = tail;
		
		print(head);
	
		print(delete(head, head));
		
		//(2)多个结点，删除尾结点
		print(delete(head, tail));
		
		//(3)删除的不是尾结点
		print(delete(head, head.next));
		
		
		
	}

}
