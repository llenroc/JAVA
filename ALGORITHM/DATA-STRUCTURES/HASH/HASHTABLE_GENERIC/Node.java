package hash.hashtable_generic;
public class Node<T> {
    private T value;
    //it is for linkedlist handling
    Node<T> next;
    Node<T> prev;
    
    //it is for Tree handling
    Node left;
    Node right;

    Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void displayValue() {
        System.out.print(value.toString() + " ");
    }

    public boolean isEmptyLeft()
    {
    	return (left==null);
    }
    
    public boolean isEmptyRight()
    {
    	return (right==null);
    }
    
	@Override
	public String toString() {
		return "{" + value + "} ";
	}       
}
