package com.java.offer;

public class FindKthToTail {

	static class Node {
		int key;
		Node next;
	}

	public static Node find(Node node, int k) {
		
		if (node == null || k == 0) {
			return null;
		}

		Node headNode = node;
		Node behindNode = null;

		for (int i = 1; i < k; i++) {
			if (headNode.next != null) {
				headNode = headNode.next;
			} else {
				return null;
			}
		}
		
		behindNode = node;
		while(headNode.next != null){
			headNode = headNode.next;
			behindNode = behindNode.next;
		}
		
		return behindNode;
	}

	public static void main(String[] args) {

		//建立一个测试链表
		Node head = new Node();
		head.key = 0;
		Node p = head;
		for(int i = 1; i < 10; i++){
			Node node = new Node();
			node.key = i;
			node.next = null;
			p.next = node;
			p = node;
		}
		
		
		if(find(head, 6) != null){
			System.out.println(find(head, 6).key);
		}else{
			System.out.println("input error");
		}
		
	}

}
