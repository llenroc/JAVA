/*
2020-Oct-04. Oleksii Saiun. Single Circular Linked List
*/

class MyLinkedList
{
	Node head;
	Node tail;
	int size=0;
	
	public void insertNode(int key)
	{
		Node newNode = new Node(key);
		if (head==null)
		{
			head=newNode;
			tail=newNode;
			
		}
		else
		{
			newNode.next=head;
			head=newNode;
			tail.next=head;
		}
		size++;
	}
	
	public void displayAll()
	{
		Node curr=head;
		int counter=0;
		while(counter!=size)
		{
			curr.displayValue();
			curr=curr.next;
			counter++;
		}		
		System.out.println();
	}
}
public class AppSingleCircular {
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.insertNode(1);
		list.insertNode(2);
		list.insertNode(3);
		list.displayAll();
		list.head.displayValue();
		list.head.next.displayValue();
		list.head.next.next.displayValue();
		list.head.next.next.next.displayValue();

	}

}
