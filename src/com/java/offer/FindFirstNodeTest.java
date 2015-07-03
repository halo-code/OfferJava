package com.java.offer;

public class FindFirstNodeTest {


	static class Node{
		int value;
		Node next;
		
		Node(int val){
			this.value = val;
		}
	}

	public static Node findFirstNode(Node head1, Node head2){
		if(head1 == null || head2 == null){
			return null;
		}
		int length1 = 0, length2 = 0;
		Node node = head1;
		while(node != null){
			length1++;
			node = node.next;
		}
		node = head2;
		while(node != null){
			length2++;
			node = node.next;
		}
		
		
		int delta = length1 - length2;
		
		Node node1 = head1;
		Node node2 = head2;
		if(delta > 0){
			for(int i = 0 ; i < delta; i++){
				node1 = node1.next;
			}
		}else{
			for(int i = 0 ; i < -delta; i++){
				node2 = node2.next;
			}
		}
		
		while(node1 != null && node2 != null){
			if(node1 == node2){
				break;
			}
			node1 = node1.next;
			node2 = node2.next;
		}
		
		if(node1 == null || node2 == null){
			return null;
		}
		
		return node1;
		
	}
	public static void main(String[] args) {
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		
		node6.next = node7;
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		node1.next = node2;
		node2.next = node3;
		node3.next = node6;
		
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		
		node4.next = node5;
		node5.next = node6;
		
		Node common = findFirstNode(node1, node4);
		if(common == null){
			System.out.println("No Common Node");
		}else{
			System.out.println(common.value);
		}
		

	}

}
