import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class _TestBinaryTree_Height {

	private Node buildTree1() {
		Node root = new Node(4);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);

		root.left = node3;
		node3.left = node2;
		node3.right = node8;
		node8.right = node7;
		node7.left = node9;

		root.right = node5;
		node5.right = node10;
		return root;
		/*
		 * 
		 *            4
		 *          /   \
		 *         3     5
		 *       /  \     \
		 *      2     8    10
		 *             \
		 *              7
		 *            /
		 *           9  
		 * */	
	}

	@Test
	public void testTreeNull() {
		Node root = null;
		Tree tree = new Tree(root);
		int heightIncome = tree.calcHeightOfTreeRecurs(root);
		assertEquals(heightIncome, 0);
	}

	@Test
	public void testTreeHeight5() {
		Node root = buildTree1();
		Tree tree = new Tree(root);
		int heightIncome = tree.calcHeightOfTreeRecurs(root);
		assertEquals(heightIncome, 5);
	}

}
