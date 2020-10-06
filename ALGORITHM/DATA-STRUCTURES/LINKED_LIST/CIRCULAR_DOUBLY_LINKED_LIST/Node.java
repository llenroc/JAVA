public class Node {
	private int value;
	Node next;
	Node prev;

	public Node(int value) {
		super();
		this.value = value;
	}
	
	public void displayValue()
	{
		System.out.print(value+" ");
	}

}
