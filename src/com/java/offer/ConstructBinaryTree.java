package com.java.offer;

public class ConstructBinaryTree {

	static class BinaryTreeNode {
		int mVal;
		BinaryTreeNode mLeft;
		BinaryTreeNode mRight;

		public BinaryTreeNode() {
			this(0);
		}

		public BinaryTreeNode(int val) {
			this.mVal = val;
			this.mLeft = null;
			this.mRight = null;
		}

	}

	/**
	 * 
	 * @param preOrder 前序遍历数组
	 * @param inOrder 中序遍历数组
	 * @param length 数组长度
	 * @return 根结点
	 */
	public static BinaryTreeNode Construct(int[] preOrder, int[] inOrder,
			int length) {
		if (preOrder == null || inOrder == null || length <= 0) {
			return null;
		}
		try {
			return ConstructCore(preOrder, 0, preOrder.length - 1, inOrder, 0,
					inOrder.length - 1);
		} catch (InvalidPutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @param PreOrder
	 *            前序遍历序列
	 * @param startPreIndex
	 *            前序序列开始位置
	 * @param endPreIndex
	 *            前序序列结束位置
	 * @param InOrder
	 *            中序遍历序列
	 * @param startInIndex
	 *            中序序列开始位置
	 * @param endInIndex
	 *            中序序列结束位置
	 * @return 根结点
	 * @throws InvalidPutException
	 */
	public static BinaryTreeNode ConstructCore(int[] preOrder,
			int startPreIndex, int endPreIndex, int[] inOrder,
			int startInIndex, int endInIndex) throws InvalidPutException {

		int rootValue = preOrder[startPreIndex];
		System.out.println("rootValue = " + rootValue);
		BinaryTreeNode root = new BinaryTreeNode(rootValue);

		// 只有一个元素
		if (startPreIndex == endPreIndex) {
			if (startInIndex == endInIndex
					&& preOrder[startPreIndex] == inOrder[startInIndex]) {
				System.out.println("only one element");
				return root;
			} else {
				throw new InvalidPutException();
				// System.out.println("invalid put");

			}
		}

		// 在中序遍历中找到根结点的索引
		int rootInIndex = startInIndex;

		while (rootInIndex <= endInIndex && inOrder[rootInIndex] != rootValue) {
			++rootInIndex;
		}

		if (rootInIndex == endInIndex && inOrder[rootInIndex] != rootValue) {
			throw new InvalidPutException();

		}

		int leftLength = rootInIndex - startInIndex;

		int leftPreOrderEndIndex = startPreIndex + leftLength;

		if (leftLength > 0) {
			// 构建左子树
			root.mLeft = ConstructCore(preOrder, startPreIndex + 1,
					leftPreOrderEndIndex, inOrder, startInIndex,
					rootInIndex - 1);
		}

		if (leftLength < endPreIndex - startPreIndex) {
			// 右子树有元素,构建右子树
			root.mRight = ConstructCore(preOrder, leftPreOrderEndIndex + 1,
					endPreIndex, inOrder, rootInIndex + 1, endInIndex);
		}
		return root;

	}

	static class InvalidPutException extends Exception {

		private static final long serialVersionUID = 1L;

	}

	public static void printPreOrder(BinaryTreeNode root) {
		if (root == null) {
			return;
		} else {
			System.out.print(root.mVal + " ");
		}

		if (root.mLeft != null) {
			printPreOrder(root.mLeft);
		}

		if (root.mRight != null) {
			printPreOrder(root.mRight);
		}
	}

	public static void main(String[] args) {

		int[] preOrder = new int[] { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] inOrder = new int[] { 4, 7, 2, 1, 5, 3, 8, 6 };

		printPreOrder(Construct(preOrder, inOrder, preOrder.length));

	}

}
