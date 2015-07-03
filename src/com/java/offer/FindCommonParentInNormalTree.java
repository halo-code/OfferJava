package com.java.offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FindCommonParentInNormalTree {

	static class Node{
		int value;
		List<Node> childrens;
		
		Node(int val){
			this.value = val;
		}
		public void setChildrens(List<Node> childrens) {
			this.childrens = childrens;
		}
	}
	public static Node findCommonTree(Node root, Node node1, Node node2){
		if(root == null || node1 == null || node2 == null){
			return null;
		}
		
		List<Node> path1 = new ArrayList<Node>();
		getNodePath(root, node1, path1);
		
		
		List<Node> path2 = new ArrayList<Node>();
		getNodePath(root, node2, path2);
		
		return getLastCommonNode(path1, path2);
		
	}
	
	private static Node getLastCommonNode(List<Node> path1, List<Node> path2) {
		
		
		System.out.println("path1.size = " + path1.size());
		System.out.println("path2.size = " + path2.size());
		
		Iterator<Node> iterator1 = path1.iterator();
		Iterator<Node> iterator2 = path2.iterator();
		
		Node lastCommon = null;
		Node node1;
		Node node2;
		
		while(iterator1.hasNext() && iterator2.hasNext()){
			
			 node1 = iterator1.next();
			 node2 = iterator2.next();
			
			if(node1.value == node2.value){
				lastCommon = node1;
			}
		}
		return lastCommon;
	}

	private static boolean getNodePath(Node root, Node node, List<Node> path) {

		if(root == node){
			return true;
		}
		
		path.add(root);
		
		System.out.println("add");
		boolean found = false;
		if(root.childrens != null){
			
			for(Node pNode : root.childrens){
				found = getNodePath(pNode, node, path);
				
				if(found){
					break;
				}
			}
		}
		
		
		if(!found){
			System.out.println("remove");
			path.remove(root);
		}
		
		return found;
		
	}

	public static void main(String[] args) {

		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		
		
		List<Node> rootChildren = new ArrayList<>();
		rootChildren.add(node2);
		rootChildren.add(node3);
		
		List<Node> node2Children = new ArrayList<>();
		node2Children.add(node4);
		node2Children.add(node5);
		
		
		root.setChildrens(rootChildren);
		node2.setChildrens(node2Children);
		
		Node common = findCommonTree(root, node5, node3);
		if(common != null){
			System.out.println(common.value);
		}else{
			System.out.println("null");
		}
	}

}
