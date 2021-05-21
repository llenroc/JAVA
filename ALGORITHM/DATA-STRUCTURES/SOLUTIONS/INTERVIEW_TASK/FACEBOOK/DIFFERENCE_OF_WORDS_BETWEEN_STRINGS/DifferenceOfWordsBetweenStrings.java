package interview.facebook.difference_of_words_between_strings;

import java.util.HashSet;
import java.util.Set;


/*2020-May-21. Oleksii Saiun. Facebook
 * 
 * - Complete a function that returns a list containing all the mismatched words (case sensitive) between two given input strings
        string 1 : "Firstly this is the first string"
        string 2 : "Next is the second string"
        output : ['Firstly', 'this', 'first', 'Next', 'second']

 * 
 * */

class Calc {
	public Set<String> findDifferenceBetweenWords(String str1, String str2) {
		Set<String> set = new HashSet<>();

		String[] listWords1 = str1.split(" ");
		String[] listWords2 = str2.split(" ");

		for (int j = 0; j < listWords1.length; j++) {
			set.add(listWords1[j]);
		}

		for (int j = 0; j < listWords2.length; j++) {
			String word = listWords2[j];
			if (!set.contains(word)) {
				set.add(word);
			} else {
				set.remove(word);
			}
		}
		return set;
	}
}

public class Difference_of_words_between_stringsApp {
	public static void main(String[] args) {
		Calc calc = new Calc();
		String str1 = "Firstly this is the first string";
		String str2 = "Next is the second string";

		Set<String> out = calc.findDifferenceBetweenWords(str1, str2);

		System.out.println(str1);
		System.out.println(str2);
		System.out.println(out);

	}

}
