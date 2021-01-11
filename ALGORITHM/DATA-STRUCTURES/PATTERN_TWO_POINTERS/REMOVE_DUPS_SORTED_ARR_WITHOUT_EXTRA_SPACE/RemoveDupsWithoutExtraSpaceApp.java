/*2020-Jan-11. Oleksii Saiun. Remove Dups without(!) an extra space - ideal Leetcode solution
 * input:
 * arr[] = [1 1 1 2 3 3 3 6 9 9] 
 * out:
 * 
 * pointer(length of array witout dups):5
 * out[] = 1 2 3 6 9 3 3 6 9 9 
 * */

class Calc {
    int pointer=1;
	public void removeDups(int[] arr) {

		for (int j = 1; j < arr.length; j++) {
			if (arr[j] != arr[j - 1]) {
				arr[pointer++]=arr[j];
			}
		}

	}

	public void displayArray(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}
}

public class RemoveDupsWithoutExtraSpaceApp {
	public static void main(String[] args) {
		Calc calc = new Calc();
		int[] arr = new int[] { 1, 1, 1, 2, 3, 3, 3, 6, 9, 9 };
		calc.displayArray(arr);
		calc.removeDups(arr);
		System.out.println("pointer(length of array witout dups):"+calc.pointer);
		calc.displayArray(arr);

	}

}
