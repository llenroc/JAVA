import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class _TestTreeLowestCommonAncestorApp2 {

	
	public Node buildTree()
	{

		Node root = new Node(9);
		Node node3 = new Node(3);
		Node node10 = new Node(10);
		Node node2 = new Node(2);
		Node node1 = new Node(1);
		Node node0 = new Node(0);
		Node node4 = new Node(4);
		Node node6 = new Node(6);
		Node node8 = new Node(8);
		Node node16 = new Node(16);
		Node node17 = new Node(17);
		Node node19 = new Node(19);
		Node node28 = new Node(28);
		Node node49 = new Node(49);

		root.left = node3;
		root.right = node10;
		node3.left = node2;
		node10.left = node8;
		node10.right = node16;
		node2.left = node1;
		node2.right = node6;
		node6.right = node4;
		node16.left = node17;
		node16.right = node0;
		node4.left = node19;
		node4.right = node28;
		/*
         *           9 
         *        3     10 
         *      2     8     16
         *    1   6       17   0
         *          4
         *       19   28 
         *       
         */
		return root;
	}
	
	@Test
	public void testLCA_17_4()
	{
		Node rootInput=buildTree();
		Tree tree = new Tree(rootInput);
		int LCAInput=tree.lowestCommonAncestor(rootInput, new Node(17), new Node(4)).getValue();
		
		assertEquals(LCAInput,9);		
	}
	
	@Test
	public void testLCA_8_0()
	{
		Node rootInput=buildTree();
		Tree tree = new Tree(rootInput);
		int LCAInput=tree.lowestCommonAncestor(rootInput, new Node(8), new Node(0)).getValue();
		
		assertEquals(LCAInput,10);		
	}
	
	@Test
	public void testLCA_2_2()
	{
		Node rootInput=buildTree();
		Tree tree = new Tree(rootInput);
		int LCAInput=tree.lowestCommonAncestor(rootInput, new Node(2), new Node(2)).getValue();
		
		assertEquals(LCAInput,2);		
	}
}
