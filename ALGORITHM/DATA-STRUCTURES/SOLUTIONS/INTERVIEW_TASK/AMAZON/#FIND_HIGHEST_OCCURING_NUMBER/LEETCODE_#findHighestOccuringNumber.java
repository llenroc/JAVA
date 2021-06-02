import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/*2021-June-01. Oleksii Saiun. Amazon
 * 
 * Find the highest occuring number in the list, in case of tie return both numbers.
    [2,4,3,5,2,6,3] this should return 2 and 3 both

 * */
class Calc {
	public List<Integer> findHighestOccuringNumber(int[] arr) {
		Map<Integer, Integer> map = populateMap(arr);
		PriorityQueue<Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
		List<Integer> listOut = new ArrayList<>();
		for (Entry<Integer, Integer> j : map.entrySet()) {
			maxHeap.add(j);
		}
		
		int maxFreq = maxHeap.peek().getValue();
		while (!maxHeap.isEmpty() && maxHeap.peek().getValue() == maxFreq) {
			listOut.add(maxHeap.poll().getKey());
		}

		return listOut;
	}

	private Map<Integer, Integer> populateMap(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int j = 0; j < arr.length; j++) {
			int key = arr[j];
			int freq = map.getOrDefault(key, 0);
			map.put(key, freq + 1);
		}
		return map;
	}

	public void displayArray(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j]+" ");
		}
		System.out.println();
	}
}

public class Find_highest_occuring_valueApp {
	public static void main(String[] args) {
		Calc calc = new Calc();
		int[] arr = new int[] { 2, 4, 3, 5, 2, 6, 3 };
		List<Integer> listOut = calc.findHighestOccuringNumber(arr);

		calc.displayArray(arr);
		System.out.println("value with max frquesncy :"+listOut);

	}

}
