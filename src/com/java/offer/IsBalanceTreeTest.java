package com.java.offer;

public class IsBalanceTreeTest {

	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public static boolean isBalance(TreeNode root, int[] depth){
		if(root == null){
			depth[0] = 0;
			return true;
		}
		
		int[] left = new int[1];
		int[] right = new int[1];
		
		if(isBalance(root.left, left) && isBalance(root.right, right)){
			int diff = left[0] - right[0];
			if(diff <= 1 && diff >= -1){
				
				depth[0] = 1 + Math.max(left[0], right[0]);
				
				return true;
			}
			
		}
		
		return false;
		
	}
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		root.left = node1;
		
		TreeNode node2 = new TreeNode(2);
		node1.left = node2;

		int[] depth = new int[1];
		System.out.println(isBalance(root, depth));
	}

}
