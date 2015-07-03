package com.java.offer;

import java.util.Stack;


public class MirrorRecursivelyTest {

	static class Node{
		int key;
		Node left;
		Node right;
		
		Node(int key){
			this.key = key;
		}
	}
	
	public static void mirrorRecursively(Node root){
		if(root == null){
			return;
		}
		if(root.left == null && root.right == null){
			return;
		}
		
		Node node = root.left;
		root.left = root.right;
		root.right = node;
		
		if(root.left != null){
			mirrorRecursively(root.left);
		}
		if(root.right != null){
			mirrorRecursively(root.right);
		}
		
		
		
	}
	
	//非递归实现，要借助栈
	public static void mirrorNoneRecurvisely(Node root){
		Stack<Node> stack = new Stack<Node>();
		stack.add(root);
		while(!stack.isEmpty()){
			Node node = stack.pop();
			
			if(node.left != null || node.right != null){
				Node tmp = node.left;
				node.left = node.right;
				node.right = tmp;
			}
			
			if(node.left != null){
				stack.push(node.left);
			}
			if(node.right != null){
				stack.push(node.right);
			}
			
		}
		
	}
	
	//打印树
	public static void printTree(Node node){
		if(node == null){
			return;
		}
		System.out.println(node.key);
		printTree(node.left);
		printTree(node.right);
	}
	
	public static void main(String[] args) {

		Node root = new Node(8);
		Node node8 = new Node(8);
		Node node7 = new Node(7);
		
		root.left = node8;
		root.right = node7;
		
		Node node9 = new Node(9);
		node8.left = node9;
		
		Node node2 = new Node(2);
		node8.right = node2;
		
		Node node4 = new Node(4);
		Node node72 = new Node(7);
		node2.left = node4;
		node2.right = node72;
		
		//mirrorRecursively(root);
		mirrorNoneRecurvisely(root);
		printTree(root);
		
	}

}
