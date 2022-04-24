package com.greatlearning.lab3dsa;

import java.util.ArrayList;

class FindLongestPath {

	
	static class Node {
		Node leftNode;
		Node rightNode;
		int nodeData;
	};

	
	static Node newNode(int nodeData) {
		Node temp = new Node();

		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;

		return temp;
	}

	
	public  ArrayList<Integer> findLongestPath(Node root) {

		if (root == null) {
			ArrayList<Integer> result = new ArrayList<>();
			return result;
		}

		ArrayList<Integer> rightNode = findLongestPath(root.rightNode);

		ArrayList<Integer> leftNode = findLongestPath(root.leftNode);

		if (rightNode.size() < leftNode.size()) {
			leftNode.add(root.nodeData);
		} else {
			rightNode.add(root.nodeData);
		}
		
		if(leftNode.size() > rightNode.size())
			return leftNode;
		else
			return rightNode;
	}

	public static void main(String[] args) {
		FindLongestPath obj = new FindLongestPath();
		
		Node root = newNode(100);
		root.leftNode = newNode(20);
		root.rightNode = newNode(130);
		root.leftNode.leftNode = newNode(10);
		root.leftNode.rightNode = newNode(50);
		root.rightNode.leftNode = newNode(110);
		root.rightNode.rightNode = newNode(140);
		root.leftNode.leftNode.leftNode = newNode(5);
		

		ArrayList<Integer> result= obj.findLongestPath(root);
		int size = result.size();

		System.out.print(result.get(size - 1));
		for (int i = size - 2; i >= 0; i--) {
			System.out.print(" -> " + result.get(i));
		}
	}
}