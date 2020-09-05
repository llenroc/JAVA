/* Oleksii Saiun. 2020-Sep-05. Brute force solution
 * Count the number of prime numbers less than a non-negative number, n
 * 
 * */
class Calc {

	public int countPrimes(int key) {
		int count = 0;
		if (key <= 1) {
			return 0;
		}

		for (int j = 2; j <= key; j++) {
			if (isPrimeNumber(j)) {
				count = count + 1;
				System.out.println(j + " [prime]");
			} else {
				System.out.println(j + " [not prime]");
			}
		}
		return count;
	}

	private boolean isPrimeNumber(int key) {
		if (key <= 1) {
			return false;
		}

		boolean outStatus = true;

		for (int j = 2; j < key; j++) {
			if (key % j == 0) {

				outStatus = false;
				break;
			}

		}
		return outStatus;
	}
}

public class CountPrimeNumberApp {

	public static void main(String[] args) {
		Calc calc = new Calc();
		System.out.println("number of prime numbers: "+calc.countPrimes(30));


	}

}
