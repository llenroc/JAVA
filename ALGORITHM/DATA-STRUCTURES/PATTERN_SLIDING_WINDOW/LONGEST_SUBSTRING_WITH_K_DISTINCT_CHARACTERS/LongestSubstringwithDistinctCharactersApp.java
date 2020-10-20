import java.util.HashMap;
import java.util.Map;

/*Oleksii Saiun. 2020-Oct-20. Longest Substring with K Distinct Characters 
 * Pattern Sliding Window. 
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.




 * */
class Calc {
	private Map<Character, Integer> hashmap = new HashMap<>();

	public int findLength(String str, int k) {
		int startWindow = 0;
		int endWindow = 0;
		int maxLengthOfSubArray = Integer.MIN_VALUE;
		for (endWindow = 0; endWindow < str.length(); endWindow++) {
			Character element = str.charAt(endWindow);
			hashmap.put(element, hashmap.getOrDefault(element, 0) + 1);

			while (hashmap.size() > k) {
				Character elementLeft = str.charAt(startWindow);
				int freq = hashmap.get(elementLeft);
				hashmap.put(elementLeft, freq - 1);
				// we delete a character from map if a frequency is 0
				if (hashmap.get(elementLeft) == 0) {
					hashmap.remove(elementLeft);
				}
				maxLengthOfSubArray = Math.max(maxLengthOfSubArray, endWindow - startWindow);
				System.out.println("startWindow=" + startWindow + "; endWindow=" + endWindow + "; maxLengthOfSubArray="
						+ maxLengthOfSubArray + hashmap);
				startWindow = startWindow + 1;
			}
		}		
		return maxLengthOfSubArray;
	}
}

public class LongestSubstringwithDistinctCharactersApp {

	public static void main(String[] args) {
		Calc calc = new Calc();
		String str = "araaci";
		int k = 2;
		System.out.println(calc.findLength(str, k));
/*
 		String str = "araaci";
		int k = 2;
		out =4;
		
 */
	}

}
