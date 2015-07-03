package com.java.offer;

public class HasSubTreeTest {

	static class Node{
		int key;
		Node left;
		Node right;
		
		Node(int key){
			this.key = key;
		}
	}
	public static boolean hasSubTree(Node root1, Node root2){
		
		boolean result = false;
		
		if(root1 != null && root2 != null){
			result = doesTreeHaveTree2(root1, root2);
			
			if(!result){
				result = hasSubTree(root1.left, root2);
			}
			if(!result){
				result = hasSubTree(root1.right, root2);
			}
		}
		
		return result;
	}
	private static boolean doesTreeHaveTree2(Node root1, Node root2) {
		if(root2 == null){
			return true; 
		}
		
		if(root1 == null){
			return false;
		}
		
		if(root1.key != root2.key){
			return false;
		}
		
		return doesTreeHaveTree2(root1.left, root2.left) && doesTreeHaveTree2(root1.right, root2.right);
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
		
		
		Node root2 = new Node(8);
		Node node92 = new Node(9);
		Node node22 = new Node(2);
		
		root2.left = node92;
		root2.right = node22;
		
		System.out.println(hasSubTree(root1, root2));

	}

}
