package com.GL_dsa_lab2_q2;

import java.util.*;

public class FindSumPair {

	static class Node{
		int data; 
		Node leftNode, rightNode;
	};
		
	static Node createNode(int nodeData) {
		Node newNode = new Node();
		newNode.data = nodeData;
		newNode.leftNode = null;
		newNode.rightNode = null;
		return newNode;
	}
	
	public Node insert(Node root, int key) {
		if (root == null)
			return createNode(key);
		if (key < root.data)
			root.leftNode = insert(root.leftNode, key);
		else
			root.rightNode = insert(root.rightNode, key);
		return root;
	}
	
	public boolean findpairUtil(Node root, int sum, HashSet<Integer> set) {
		if (root == null)
			return false;
		
		if (findpairUtil(root.leftNode, sum, set))
			return true;
		if (set.contains(sum - root.data)) {
			System.out.println("Pair is found (" + (sum - root.data)+ ","+ root.data +")");
			return true;
		}
		else set.add(root.data);
		return findpairUtil(root.rightNode, sum , set);
	}
	
	public void findPairWithGivenSum(Node root, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		if (!findpairUtil(root, sum, set))
			System.out.println("Pairs do not exist" + "\n");
	}	
	public static void main(String[] args) {
		Node root = null;
		
		FindSumPair findPS = new FindSumPair();
		root = findPS.insert(root,40);
		root = findPS.insert(root,20);
		root = findPS.insert(root,60);
		root = findPS.insert(root,10);
		root = findPS.insert(root,30);
		root = findPS.insert(root,50);
		root = findPS.insert(root,70);
		//int targetSum = 130;
		Scanner scanner = new Scanner(System.in);
    	System.out.print("enter the sum : ");
         int targetSum = scanner.nextInt();
		findPS.findPairWithGivenSum(root, targetSum);
	}
}
