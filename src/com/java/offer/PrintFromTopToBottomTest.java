package com.java.offer;

import java.util.LinkedList;
import java.util.Queue;

public class PrintFromTopToBottomTest {

	static class Node{
		int key;
		Node left;
		Node right;
		
		Node(int key){
			this.key = key;
		}
	}
	
	public static void printFromTopToBottom(Node root){
		
		if(root == null){
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(root);
		
		while(!queue.isEmpty()){
			Node node = queue.peek();
			System.out.println(node.key);
			
			queue.remove();
			
			if(node.left != null){
				queue.add(node.left);
			}
			
			if(node.right != null){
				queue.add(node.right);
			}
		}
		
		
	}
	
	public static void main(String[] args) {

		Node root1 = new Node(8);
		Node node8 = new Node(8);
		Node node7 = new Node(7);
		
		root1.left = node8;
		root1.right = node7;
		
		Node node9 = new Node(9);
		node8.left = node9;
		
		Node node2 = new Node(2);
		node8.right = node2;
		
		Node node4 = new Node(4);
		Node node72 = new Node(7);
		node2.left = node4;
		node2.right = node72;
		
		printFromTopToBottom(root1);
	}

}
