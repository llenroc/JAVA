package heap.taskScheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;

class Calc {
	HashMap<Character, Integer> map = new HashMap<>();
	PriorityQueue<Character> heap = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));

	public int leastInterval(char[] tasks, int n) {
		int totalNumberOfSteps = 0;
		populateMap(tasks);
		populateHeap();

		while (!heap.isEmpty()) {
			List<Character> listOfKeysHeap = new ArrayList<>();
			// 1.output from heap
			int stepOfOneCycle = 0;
			for (int k = 0; k <=n; k++) {

				if (!heap.isEmpty() ) {
					totalNumberOfSteps++;
					stepOfOneCycle++;
					Character key = heap.poll();
					int freq = map.get(key) - 1;
					System.out.print(key + "; ");
					listOfKeysHeap.add(key);

					// update map
					map.put(key, freq);
					if (freq <= 0) {
						map.remove(key);
					}
				}
			}
			while(stepOfOneCycle<=n && !map.isEmpty() )
			{
				System.out.print("; IDLE");
				totalNumberOfSteps++;
				stepOfOneCycle++;
			}
			// 2.put back in a heap if frequency of element is >0
			for (Character ch : listOfKeysHeap) {
				int freq = map.getOrDefault(ch, 0);

				if (freq > 0) {
					heap.offer(ch);
				}
			}
			System.out.println();
		}

		return totalNumberOfSteps;
	}

	private void populateMap(char[] tasks) {
		for (int k = 0; k < tasks.length; k++) {
			char key = tasks[k];
			int freq = map.getOrDefault(key, 0);
			map.put(key, freq + 1);
		}
	}

	private void populateHeap() {
		for (Entry<Character, Integer> j : map.entrySet()) {
			heap.offer(j.getKey());
		}
	}
}

public class TaskSchedulerApp {
	public static void main(String[] args) {
		Calc calc = new Calc();
		char[] tasks = new char[] { 'A', 'A', 'A', 'B', 'B', 'B' };
		int n = 0;
		int out = calc.leastInterval(tasks, n);
		System.out.println(out);

	}

}
