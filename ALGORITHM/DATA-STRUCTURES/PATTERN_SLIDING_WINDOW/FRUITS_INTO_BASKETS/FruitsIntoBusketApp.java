import java.util.HashMap;

/*Oleksii Saiun. 2020-Oct-20.Fruits into Baskets
 * Sliding Window pattern
 * note of the task: you can start with any tree, but once you have started you can’t skip a tree.
 * 
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']; 
 * Output: 3 [C', 'A', 'C']
 *  
 * Time complexity: O(N+N)=O(N)
 * Space complexity: O(1)
 * The algorithm runs in constant space O(1) as there can be a maximum of three types of fruits stored in the frequency map.
 * */
class Calc {
	private HashMap<Character, Integer> hashmap = new HashMap<>();

	public int findLength(char[] arr) {
		int startIndex = 0;
		int endIndex = 0;
		int maxLength = Integer.MIN_VALUE;

		for (endIndex = 0; endIndex < arr.length; endIndex++) {
			Character elemRight = arr[endIndex];
			int freqOfRightElem = hashmap.getOrDefault(elemRight, 0);
			hashmap.put(elemRight, freqOfRightElem + 1);

			while (hashmap.size() > 2) {
				Character elemLeft = arr[startIndex];
				int freqOfLeftElem = hashmap.getOrDefault(elemLeft, 0);
				hashmap.put(elemLeft, freqOfLeftElem - 1);
				// delete element if 0 frequency
				if (freqOfLeftElem - 1 == 0) {
					hashmap.remove(elemLeft);
				}
				startIndex++;
			}
			maxLength = Math.max(maxLength, endIndex - startIndex + 1);
			System.out.println(hashmap + "; startIndex=" + startIndex + "; endIndex=" + endIndex);
		}

		return maxLength;
	}
}

public class FruitsIntoBusketApp {
	public static void main(String[] args) {
		Calc calc = new Calc();
		char[] arr = new char[] { 'A', 'B', 'C', 'A', 'C' };
		System.out.println("Number of fruits into two buskets: " + calc.findLength(arr));
		/*
		 * Input: Fruit=['A', 'B', 'C', 'A', 'C']; 
		 * Output: 3 - [C', 'A', 'C']
		 */
	}

}
