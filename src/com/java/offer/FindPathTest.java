package com.java.offer;

import java.util.LinkedList;
import java.util.List;



public class FindPathTest {

	static class Node{
		int key;
		Node left;
		Node right;
		
		Node(int key){
			this.key = key;
		}
	}
	
	public static void findPath(Node root, int expect){
		
		if(root == null){
			return;
		}
		
		List<Node> path = new LinkedList<Node>();
		int currentSum = 0;
		findPath(root, expect, path, currentSum);
		
	}
	private static void findPath(Node node, int expect, List<Node> path,
			int currentSum) {
		
		currentSum += node.key;
		path.add(node);
		
		if(node.left == null && node.right == null && currentSum == expect){
			System.out.println("A path is found : ");
			for(Node n : path){
				System.out.print(n.key + "  ");
			}
			System.out.println("");
		}
		
		if(node.left != null){
			findPath(node.left, expect, path, currentSum);
		}
		if(node.right != null){
			findPath(node.right, expect, path, currentSum);
		}
		
		path.remove(path.size() - 1);
		
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
		
		findPath(root, 15);

	}

}
