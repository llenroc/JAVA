/*Oleksii Saiun. 2020-Dec-22.
 * Kth Smallest Number in Sorted LinkedList
 * 
 * Example:
 * 2 6 8 
   3 6 7 
   1 3 4 
   
   result: 5 smallest element is 4

 * 
 * 
 * */
class Node
{
	int value;
	int rowIndex;
	int columnIndex;

	
	public Node(int value, int rowIndex, int columnIndex) {
		super();
		this.value = value;
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
	}


	public void display()
	{
		System.out.println("value: "+value+"; rowIndex: "+rowIndex+"; columnIndex:"+columnIndex);
	}
}

class Calc
{
	 public  int findKthSmallest(List<Integer[]> lists, int k) 
	 {
		 int counter=0;
			PriorityQueue<Node> heap = new PriorityQueue<>(
					(o1,o2)  -> o1.value - o2.value
					);

         for(int j=0; j< lists.size(); j++)
         {
        	 int value = lists.get(j)[0];
        	 int rowIndex = j;
        	 int columnIndex = 0;
        	 Node node = new Node(value,rowIndex,columnIndex);
        	 heap.offer(node);
         }
         
         while(counter<=k)
         {
        	 Node node = heap.poll();
        	 int currValue = node.value;
        	 int currRowIndex = node.rowIndex;
        	 int currColumnIndex = node.columnIndex;
        	 counter=counter+1;
        	 
        	 if(counter==k)
        	 {
                return currValue;
        	 }
        	 else
        	 {
        	   	 int newRowIndex = currRowIndex;
            	 int newColumnIndex = currColumnIndex+1;
            	 int newValue = lists.get(currRowIndex)[newColumnIndex];
                 Node newNode =new Node(newValue,newRowIndex,newColumnIndex);
                 heap.offer(newNode);
        	 }
        	 
         }
         
         return Integer.MIN_VALUE;
	 }
	 
	 public void displayArray(Integer[] arr)
	 {
		 for(Integer j : arr)
		 {
			 System.out.print(j+" ");
		 }
		 System.out.println();
	 }
}
public class KthSmallestNumberInSortedListsApp {
	public static void main(String[] args) {
		   Integer[] l1 = new Integer[] { 2, 6, 8 };
		    Integer[] l2 = new Integer[] { 3, 6, 7 };
		    Integer[] l3 = new Integer[] { 1, 3, 4 };
		    List<Integer[]> lists = new ArrayList<Integer[]>();
		    lists.add(l1);
		    lists.add(l2);
		    lists.add(l3);
		    int k=5;
		    Calc calc = new Calc();
		    
			 for(int j=0; j<lists.size();j++)
			 {
				 calc.displayArray(lists.get(j));
			 }
		    int out = calc.findKthSmallest(lists, k);
		    
		    System.out.println(k+" smallest element is "+out);

		    
	}

}
