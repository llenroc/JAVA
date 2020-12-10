import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/*2020-Aug-20. Oleksii Saiun. Changes_of_priority_queue_depends_on_hashmap
It is a demo

Task to demonstrate:
PriorityQueue depends on HashMap
(1) when i change values in HashMap it automatically changes in PriorityQueue
(2) i found a case when does not work (! SOMEHOW) when I remove key from HashMap. It does not disappear from PriorityQueue
 

 * */

class My {
	HashMap<Character, Integer> map = new HashMap<>();
	PriorityQueue<Entry<Character, Integer>> heap = new PriorityQueue<>(
			(o1,o2) -> o2.getValue()-o1.getValue()

	);

	public void reorganizeString(String s) {
		populateMap(s);
		populateHeap();
	}

	private void populateMap(String s) {
		for (int j = 0; j < s.length(); j++) {
			Character key = s.charAt(j);
			int freq = map.getOrDefault(key, 0);
			map.put(key, freq + 1);

		}
	}

	private void populateHeap() {
		for (Entry<Character, Integer> j : map.entrySet()) {			
			heap.offer(j);
		}
	}

	public void displayMap() {
		for (Entry<Character, Integer> j : map.entrySet()) {
			System.out.println("[" + j.getKey() + "; " + j.getValue() + "]");
		}
		System.out.println();
	}
}

public class ReorganizeStringApp {

	public static void main(String[] args) {
		My my = new My();
		String s = "abcaabdfcaedadaa";
		my.reorganizeString(s);
		System.out.println("map:");
		System.out.println(my.map);
		System.out.println("heap:");
		System.out.println(my.heap);
		
		System.out.println("when we update a value for key='a' in hashmap it is automatically changes in PriorityQueue");
		my.map.put('a', my.map.get('a')-1);
		System.out.println("map:");
		System.out.println(my.map);
		System.out.println("heap:");
		System.out.println(my.heap);
		System.out.println("when we remove key='d' in hashmap it is automatically removes as a whole from PriorityQueue");
		my.map.remove('a');
		System.out.println("map:");
		System.out.println(my.map);
		System.out.println("heap:");
		System.out.println(my.heap);

	}

}
