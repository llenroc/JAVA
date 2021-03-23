import java.util.Arrays;

class Calc {

	public void displayMatrix(int[][] mt) {
		for (int col = 0; col < mt.length; col++) {
			for (int row = 0; row < mt[col].length; row++) {
				System.out.print(mt[col][row] + " ");
			}
			System.out.println();
		}
	}
}

public class SortMatrixApp {
	public static void main(String[] args) {
		Calc calc = new Calc();
		int[][] arr = new int[][] { { 2, 3,7,4 }, { 1, 5,1,6 }, { 7, 9,2,3 }, { 5, 4,0,3 }, { 0, 2,8,2 } };
		//--0.-----------------------
		System.out.println("---Original:");		
		calc.displayMatrix(arr);

		//--1.-----------------------		
		System.out.println("---Sort by ascending of [0] column:");
		Arrays.sort(arr, (a, b) -> a[0] - b[0]);
		calc.displayMatrix(arr);

		//--2.-----------------------		
		System.out.println("---Sort by descending of [2] column:");
		Arrays.sort(arr, (a, b) -> b[2] - a[2]);
		calc.displayMatrix(arr);		
	}

}
