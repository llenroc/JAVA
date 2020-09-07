
/*
2020-Sep-06. Oleksii Saiun.
LeetCode_#204.Count Primes
https://leetcode.com/problems/count-primes/

Idea is to use the method [Sieve of Eratosthenes]

 Prime number is a number which is divisible by only two numbers: 1 and itself.\
 Prime number list : 2,3,5,7,9,11
 
*/ 
class Calc {
	boolean[] arr;

	public int countPrimes(int n) {
		int count = 0;
		
		calcPrimes(n);

		for (int j = 2; j < n; j++) {
			if (arr[j]) {
				count = count + 1;
			}
		}

		return count;
	};

	public void displayArray() {
		for (int j = 2; j < arr.length; j++) {
			System.out.println(j + ": " + arr[j]);

		}
	}

	public void calcPrimes(int sizeInput) {
		populateArray(sizeInput);

		for (int j = 2; j * j < sizeInput; j++) {
			
			if (arr[j]==true) {
				for (int k = j*j; k < sizeInput; k++) {
					if (k % j == 0) {
						arr[k] = false; // false = not prime
					}

				}
			}
		}

	}

	private void populateArray(int size) {
		arr = new boolean[size];
		for (int j = 0; j < arr.length; j++) {
			arr[j] = true;
		}
	}
}

public class PrimeNumber_SieveOfEratosthenesApp {

	public static void main(String[] args) {
		int sizeInput = 10;
		Calc calc = new Calc();
		calc.calcPrimes(sizeInput);
		calc.displayArray();
		System.out.println(calc.countPrimes(10));

	}

}
