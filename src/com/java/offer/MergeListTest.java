package com.java.offer;

public class MergeListTest {

	static class Node {
		int key;
		Node next;
	}

	public static Node merge(Node node1, Node node2) {

		if (node1 == null) {
			return node2;
		} else if (node2 == null) {
			return node1;
		}

		Node mergeHead = null;

		if (node1.key < node2.key) {
			mergeHead = node1;
			mergeHead.next = merge(node1.next, node2);
		} else {
			mergeHead = node2;
			mergeHead.next = merge(node1, node2.next);
		}
		return mergeHead;
	}

	public static void main(String[] args) {

		// 建立一个测试链表
		Node node1 = new Node();
		node1.key = 0;
		Node p = node1;
		for (int i = 2; i < 10; i += 2) {
			Node node = new Node();
			node.key = i;
			node.next = null;
			p.next = node;
			p = node;
		}

		Node node2 = new Node();
		node2.key = 1;
		Node p2 = node2;
		for (int i = 3; i < 10; i += 2) {
			Node node = new Node();
			node.key = i;
			node.next = null;
			p2.next = node;
			p2 = node;
		}

		Node head = merge(node1, node2);
		while (head != null) {
			System.out.println(head.key);
			head = head.next;
		}

	}

}
