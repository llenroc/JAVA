/*
 * 2020-Jul-17. Oleksii Saiun. Created Queue from custom linkedlist and using Generics
 * */
public class QueueADTGenericApp {

	public static void main(String[] args) {
		QueueADT<String> queue = new QueueADT<>();
		queue.push("A");
		queue.push("B");
		queue.push("C");
		queue.push("D");

		while (!queue.isEmpty()) {
 			queue.pop().displayValue();
		}

	}

}
