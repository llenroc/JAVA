/*2020-Jan-11. Oleksii Saiun. Remove Dups with an extra space
 * input:
 *  arr = [1 1 1 2 3 3 3 6 9 9] 
 * out:
 * 
 *  out = [1 2 3 6 9 0 0 0 0 0]
 * */

class Calc {

	public int[] removeDups(int[] arr) {
		int[] out = new int[arr.length];
		// element at [0] index is always unique

		out[0] = arr[0];
		int indexOut = 1;

		for (int j = 1; j < arr.length; j++) {
			if (arr[j] != arr[j - 1]) {
				out[indexOut++] = arr[j];
			}
		}
		return out;
	}

	public void displayArray(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}
}

public class RemoveDupsWithExtraSpaceApp {
	public static void main(String[] args) {
		Calc calc = new Calc();
		int[] arr = new int[] { 1, 1, 1, 2, 3, 3, 3, 6, 9, 9 };
		calc.displayArray(arr);
		int[] out = calc.removeDups(arr);
		calc.displayArray(out);

	}

}
