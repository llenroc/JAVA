public class HashTable<T> {

	private int index;
	private int arraySize;
	private LinkedListCustom<T>[] arr;

	public HashTable(int arraySize) {
		this.arraySize = arraySize;
		arr = new LinkedListCustom[arraySize];

		for (int index = 0; index < arraySize; index++) {
			arr[index] = new LinkedListCustom<>();
		}
	}

	
	public void insert(int index, Node<T> newNode)
	{
		arr[index].insertFirst(newNode);
	}
	
	public void displayAll()
	{
		for(int index=0;index<arraySize;index++)
		{
			if (!arr[index].isEmpty())
			{
				System.out.print("["+index+"] ");arr[index].displayForward();
			}
			
		}
	}
}
