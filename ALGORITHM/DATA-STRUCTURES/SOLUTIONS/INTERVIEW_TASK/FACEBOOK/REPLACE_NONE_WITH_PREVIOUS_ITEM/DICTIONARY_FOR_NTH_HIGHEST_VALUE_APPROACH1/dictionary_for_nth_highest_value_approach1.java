import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/*2020-May-21. Oleksii Saiun. Facebook. approach1 - minHeap as a pair of Entry<Character,Integer>
 * 
- Given a ´dictionary, print the key for nth highest value present in the dict. 
 If there are more than 1 record present for nth highest value then sort the key and print the first one.

 n=3:
 input map:
 a; 2
 b; 1
 c; 5
 d; 3
 e; 6
 f; 5
 v; 9
 z; 5

out: c,5
 * */

class Calc {

	public void findTopN(Map<Character, Integer> map, int n_boundary)
	{
		PriorityQueue<Entry<Character,Integer>> minHeap = new PriorityQueue<>( (o1,o2) ->  o1.getValue()==o2.getValue()  
				                                                                                                        ? o2.getKey().compareTo(o1.getKey()) : o1.getValue()-o2.getValue());
		
		for(Entry<Character, Integer> j : map.entrySet())
		{
			minHeap.offer(j);
			
			if(minHeap.size()>n_boundary)
			{
				minHeap.poll();
			}
		}
		
		Entry<Character, Integer> elem = minHeap.peek();
		System.out.println(elem.getKey()+"; "+elem.getValue());
	}
	
	public void printMap(Map<Character, Integer> map) {
		for (Entry<Character, Integer> j : map.entrySet()) {
			System.out.println(j.getKey() + "; " + j.getValue());
		}		
		System.out.println();		
	}
}

public class Dictionary_for_nth_highest_valueApp {
	public static void main(String[] args) {
		Calc calc = new Calc();
		Map<Character, Integer> map = new HashMap<>();
		int n_boundary=3;
        map.put('c', 5);
        map.put('e', 6);
        map.put('a', 2);
        map.put('b', 1);
        map.put('d', 3);
        map.put('f', 5);
        map.put('z', 5);
        map.put('v', 9);
        
        calc.printMap(map);
        calc.findTopN(map, n_boundary);
	}

}
