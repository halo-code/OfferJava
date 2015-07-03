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
		
		//����β���
		if(toBeDelete.next != null){
			ListNode node = toBeDelete.next;
			toBeDelete.val = node.val;
			toBeDelete.next = node.next;
			
			node = null;
			
		}
		//ֻ��һ����㣬ɾ��ͷ���
		else if(head == toBeDelete){
			toBeDelete = null;
			head = null;
			return null;
		}
		//�����㣬ɾ��β���
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
		
		//���Դ���
		ListNode head = null;
		print(delete(head, head));
		head = new ListNode(0);
		ListNode p = head;
		
		//(1)ֻ��һ����㣬ɾ��β���(Ҳ��ͷ���)
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
		
		//(2)�����㣬ɾ��β���
		print(delete(head, tail));
		
		//(3)ɾ���Ĳ���β���
		print(delete(head, head.next));
		
		
		
	}

}
