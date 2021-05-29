import java.util.LinkedHashSet;
import java.util.Set;

/*2021-May-29. Oleksii Saiun. Amazon
 * 
 * find non duplicate numbers in first list and preserve the order of list
    [1,1,3,2,5,6,5] --> [1,3,2,5,6]
 * */

class Calc {
	public int[] removeDups(int[] arr) {
		Set<Integer> set = new LinkedHashSet<>();
		for (int j = 0; j < arr.length; j++) {
			set.add(arr[j]);
		}

		int[] outWithoutDups = new int[set.size()];
		int index = 0;
		for (Integer val : set) {
			outWithoutDups[index++] = val;
		}

		return outWithoutDups;
	}

	public void displayArr(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}
}

public class Find_non_duplicates_and_preserve_orderApp {
	public static void main(String[] args) {
		Calc calc = new Calc();
		int[] arr = new int[] { 1, 1, 3, 2, 5, 6, 5 };
		int[] out = calc.removeDups(arr);

		calc.displayArr(arr);
		calc.displayArr(out);
	}

}
