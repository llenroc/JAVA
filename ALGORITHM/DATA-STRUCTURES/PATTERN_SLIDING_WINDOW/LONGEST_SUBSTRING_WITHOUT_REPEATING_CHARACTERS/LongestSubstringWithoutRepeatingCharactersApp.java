import java.util.HashMap;

/*
 * 2020-Oct-20. Oleksii Saiun. longest substring without any repeating characters
 * Sliding window pattern
 * 
 * Given a string, find the length of the longest substring which has no repeating characters.
 * 
 * */
class Calc {
	HashMap<Character, Integer> hashmap = new HashMap<>();

	public int findLength(String str) {
		int startIndex = 0;
		int endIndex = 0;
		int maxLength = Integer.MIN_VALUE;
		for (endIndex = 0; endIndex < str.length(); endIndex++) {
			Character elemRight = str.charAt(endIndex);
			int freq = hashmap.getOrDefault(elemRight, 0);
			hashmap.put(elemRight, freq + 1);
			if (hashmap.getOrDefault(elemRight, 0) == 1) {
				System.out.println("A: " + hashmap + "; startIndex=" + startIndex + "; endIndex=" + endIndex);
				int currentLength = endIndex - startIndex + 1;
				maxLength = Math.max(currentLength, maxLength);
			}
			while (hashmap.getOrDefault(elemRight, 0) > 1) {
				System.out.println("B: " + hashmap + "; startIndex=" + startIndex + "; endIndex=" + endIndex);
				// move left:
				Character elemLeft = str.charAt(startIndex);
				int currentFreqOfLeftElement = hashmap.getOrDefault(elemLeft, 0);
				hashmap.put(elemLeft, currentFreqOfLeftElement - 1);
				// delete if 0
				if (hashmap.getOrDefault(elemLeft, 0) <= 0) {
					hashmap.remove(elemLeft);
				}

				startIndex = startIndex + 1;
			}
		}

		return maxLength;
	}

}

public class LongestSubstringWithoutRepeatingCharactersApp {
	public static void main(String[] args) {
		String str = "aabccbb";
		Calc calc = new Calc();
		System.out.println("Longest substring: " + calc.findLength(str));
		/*
		 * Input: String="aabccbb"; 
		 * Output: 3 [abc]
		 */

	}

}
