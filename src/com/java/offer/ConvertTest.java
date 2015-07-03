package com.java.offer;

public class ConvertTest {

	static class TreeNode{
		int value;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int v) {
			this.value = v;
		}
	}
	
	public static TreeNode convert(TreeNode root){

		TreeNode lastNodeInList = null;
		
		convertNode(root, lastNodeInList);
		
		if(lastNodeInList == null){
			System.out.println("lastNodeInList == null");
		}
		
		TreeNode listHead = lastNodeInList;
		while(listHead != null && listHead.left != null){
			listHead = listHead.left;
		}
		
		return listHead;
	}
	
	private static void convertNode(TreeNode node, TreeNode lastNodeInList) {
		if(node == null){
			return;
		}
		
		TreeNode currentNode = node;
		if(currentNode.left != null){

			convertNode(currentNode.left, lastNodeInList);
		}
		
		
		currentNode.left = lastNodeInList;
		
		
		
		if(lastNodeInList != null){
			lastNodeInList.right = currentNode;
		}
		
		
		lastNodeInList = currentNode;
		if(lastNodeInList != null){
			System.out.println("Set last = " + lastNodeInList.value);
		}else{
			System.out.println("Set last = null");
		}
		
		
		if(currentNode.right != null){
			convertNode(currentNode.right, lastNodeInList);
		}
		
	}
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(10);
		TreeNode node6 = new TreeNode(6);
		TreeNode node14 = new TreeNode(14);
		TreeNode node4 = new TreeNode(4);
		TreeNode node8 = new TreeNode(8);
		TreeNode node12 = new TreeNode(12);
		TreeNode node16 = new TreeNode(16);
		
		root.left = node6;
		root.right = node14;
		
		node6.left = node4;
		node6.right = node8;
		
		node14.left = node12;
		node14.right = node16;
		
		TreeNode head = convert(root);
		if(head == null){
			System.out.println("head == null");
		}
		TreeNode node = head;
		while(node != null){
			
			System.out.println(node.value);
			node = node.right;
		}

	}

}
