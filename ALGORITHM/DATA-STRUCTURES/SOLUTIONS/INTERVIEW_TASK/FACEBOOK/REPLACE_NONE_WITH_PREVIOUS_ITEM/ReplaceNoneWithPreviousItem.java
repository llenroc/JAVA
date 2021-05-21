/*2020-May-21. Oleksii Saiun. Facebook
 * 
replace None with previous list item
        [None] ==> [None]
        [] ==> []
        [None,1,2] ==> [None,1,2]
        [2,None,3] ==> [2,2,3]
        [2,3,None,None,3] ==> [2,3,3,3]

 * 
 * */

class Calc {
	public String[] replaceByNone(String[] str) {
		String WORD_NONE = "None";
		int counter = 0;

		String wordToReplace = null;

		for (int j = 0; j < str.length; j++) {
			// define word that will be used for a replacement
			if (j > 0 && counter == 0 && str[j].equals(WORD_NONE)) {
				wordToReplace = str[j - 1];
				counter++;
			}

			// replacement
			if (str[j].equals(WORD_NONE) && counter == 1) {
				str[j] = wordToReplace;
			}
		}

		return str;
	}

	public void displayArray(String[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}
}

public class ReplaceNoneWithPreviousItem {
	public static void main(String[] args) {
		Calc calc = new Calc();
		String[] input = new String[] { "2","3","None","None","3" };
		calc.displayArray(input);
		String[] output = calc.replaceByNone(input);
		calc.displayArray(output);
	}

}
