package binarytree.validateBST;

public class Node { 
	private int value;
	Node left;
	Node right;

	public Node(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void displayValue() {
		System.out.print(value + " ");
	}
} 
