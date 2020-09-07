import java.util.LinkedList;
import java.util.Queue;
/*
2020-Sep-07. Oleksii Saiun.
      LeetCode_#1022. Sum of Root To Leaf Binary Numbers
      https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
      this task is based on conversion binary number to decimal

      The formula is use:
      for example, input = [11101]
      = 1*(2^4) + 1*(2^3) + 1*(2^2) + 1*(2^1) + 0*(2^0)
      Binary number:is base-2 numeral system or binary numeral system. This system uses only two symbols: 
      typically 1 (one) and 0 (zero).
      Decimal number: The decimal numeral system is the standard system for denoting integer and non-integer numbers. 
      It is also called base-ten positional numeral system.
*/

/*  
 *          1
 *       /     \
 *      0       1 
 *    /   \    /  \
 *   0     1  0    1
 *    
sum converted from binary to decimal [4]: {100}
sum converted from binary to decimal [5]: {101}
sum converted from binary to decimal [6]: {110}
sum converted from binary to decimal [7]: 111
 *    
 *    		
 */
class Tree {
	LinkedList<Integer> listPath = new LinkedList<>();
	int sumOfAllPath=0;
	Node node;

	public void BFS(Node root) {
		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			Node tmpNode = queue.poll();
			tmpNode.displayValue();

			if (tmpNode.left != null) {
				queue.offer(tmpNode.left);
			}

			if (tmpNode.right != null) {
				queue.offer(tmpNode.right);
			}

		}
		System.out.println();
	}
	
    public int sumRootToLeaf(Node root) {
            findPath(root);
            return sumOfAllPath;
    }
    
	private void printPath(LinkedList<Integer> listPath)
	{
		for(int j=0; j<listPath.size();j++)
		{
			System.out.print(listPath.get(j));			
		}
		System.out.println();
	}
	
	private void findPath(Node root)
    {
        if(root==null)
        {
            return;
        }
        
        listPath.addLast(root.getValue());
        
        if (root.left == null && root.right==null)
        {
        	sumOfAllPath = sumOfAllPath+convertListOfIntToDecimal(listPath);
        	System.out.print("sum converted from binary to decimal ["+convertListOfIntToDecimal(listPath)+"]: ");
        	printPath(listPath);

        }
        
        findPath(root.left);
        findPath(root.right);
        
        listPath.removeLast();
 
    }
    
    private int  convertListOfIntToDecimal(LinkedList<Integer> listPath)
	{
		int n = listPath.size();
		int index=0;
		int sum=0;
		
		for(int j=n-1;j>=0;j--)
		{
			sum=sum+listPath.get(j)*calcPowerOfTwo(index);
			index=index+1;
		}
		return sum;
	}
	
    private int calcPowerOfTwo(int n) {
		if (n == 0) {
			return 1;
		}
		
		return 2*calcPowerOfTwo(n-1);
	}
	
   
}

public class TreeSumOfRootToLeafBinaryNumbersApp {
	public static void main(String[] args) {
		Tree tree = new Tree();
		Node root = new Node(1);
		Node node0_A = new Node(0);
		Node node0_B = new Node(0);
		Node node0_C = new Node(0);
		Node node0_D = new Node(0);
		
		Node node1_A = new Node(1);
		Node node1_B = new Node(1);
		Node node1_C = new Node(1);
		Node node1_D = new Node(1);
		
		root.left=node0_A;
		root.right=node1_A;
		node0_A.left=node0_B;
		node0_A.right=node1_B;
		
		node1_A.left=node0_C;
		node1_A.right=node1_C;
		
		tree.BFS(root);
		System.out.println("total sum="+tree.sumRootToLeaf(root));
/*  
 *          1
 *       /     \
 *      0       1 
 *    /   \    /  \
 *   0     1  0    1
 *    
sum converted from binary to decimal [4]: {100}
sum converted from binary to decimal [5]: {101}
sum converted from binary to decimal [6]: {110}
sum converted from binary to decimal [7]: 111
 *    
 *    		
 */
		
		
		
	}
}
