import java.util.LinkedHashSet;
import java.util.Set;

/*2020-Jul-22. Oleksii Saiun. Boundary view
 * 
 * It consists of 3 steps
 * 1) LeftSide
 * 2) RightSide
 * 3) LeafNodes
 * 
 *  LinkedHashSet - we are using to store elements there.
 *  LinkedHashSet - 1) no allows elements and 2) keep them in order they are inserted 
 * 
 * 
 * 
 * */

class Tree {
	Node root;
	Set<Integer> arr = new LinkedHashSet<>();
	public Tree(Node root) {
		this.root = root;
	}

	
	 public void leafNodes(Node root)
	 {
		 if(root==null)
		 {
			 return;
		 }
		 leafNodes(root.left);
		 leafNodes(root.right);
		 if(root.left==null && root.right==null)
		 {
		//	 root.displayValue();
			 arr.add(root.getValue());
		 }
	 }
	 
	 public void leftSide(Node root)
	 {
	 if(root==null)
		 {
			 return;
		 }
			 if(root.left!=null)
			 {
				  //root.displayValue(); 
				  arr.add(root.getValue());
				  leftSide(root.left);
			 }
			 else 
			 {
				// root.displayValue();
				 arr.add(root.getValue());
				  leftSide(root.right);
			 }		
	 }
	 
	 public void rightSide(Node root)
	 {
	 if(root==null)
		 {
			 return;
		 }
			 if(root.right!=null)
			 {
			//	  root.displayValue();
				 arr.add(root.getValue());
				  rightSide(root.right);
			 }
			 else 
			 {
			//	  root.displayValue();
				 arr.add(root.getValue());
				  rightSide(root.left);
			 }		
	 }	 
	 
	 public Set<Integer> calcBoundaryView(Node root)
	 {
		 leftSide(root);
		 rightSide(root);
		 leafNodes(root);
		 return arr;
	 }
}

public class TreeBoundaryViewApp {

	public static void main(String[] args) {
		Node root = new Node(9);
		Node node3 = new Node(3);
		Node node2 = new Node(2);
		Node node1 = new Node(1);
		Node node7 = new Node(7);
		Node node11 = new Node(11);
		Node node10 = new Node(10);
		Node node8 = new Node(8);
		Node node16 = new Node(16);
		Node node17 = new Node(17);
		Node node19 = new Node(19);
		root.left = node3;
		node3.left = node2;
		node2.left = node1;
		node2.right = node11;
		node11.right= node7;

		root.right = node10;
		node10.left = node8;
		node10.right = node16;
		node16.right = node17;
		node17.right = node19;
		Tree tree = new Tree(root);
	//	tree.BSF(root);

     /*    tree.leftSide(root);
         System.out.println();    
         
         tree.rightSide(root);
         
         System.out.println();
        tree.leafNodes(root);*/
		Set<Integer> arr = tree.calcBoundaryView(root);
		for(Integer j : arr)
		{
			System.out.print(j+" ");
		}
        
        

	       /*
   *          9 
   *       3      10  
   *    2        8  16
   *  1  11            17
   *        7            19
   *            
   *  9 3 2 1     - left side
   *  10 16 17 19 - right side
   *  7 8          -leaf nodes
   *        
   * */
	}

}
