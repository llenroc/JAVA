public class Node<T> {
    private T value;
    Node next;
    Node prev;

    Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void displayValue() {
        System.out.print(value + " ");
    }
}
