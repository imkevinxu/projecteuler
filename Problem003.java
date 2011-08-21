/*
 * File: Problem 3
 * Find the largest prime factor of a composite number.
 * -----------------------
 */

import acm.program.*;

public class Problem003 extends ConsoleProgram {

	public void run() {
		long n = Long.parseLong(readLine("Enter number: "));
		println();
		long largestPrime = 0;
		for (long i = 1; i < n / 2; i++) {
			if (n % i == 0) {
				if (isPrime(i)) {
					largestPrime = i;
					println("A prime factor of " + n + " is " + largestPrime);
				}
			}
		}
		println();
		println("The largest prime factor of " + n + " is " + largestPrime);	
	}
	
	private boolean isPrime(long num) {
		double number = (double) num;
		for (long i = 2; i < num - 1; i++) {
			double factor = (double) (number / i);
			if (isWholeNumber(factor)) return false;
		}
		return true;
	}
	
	private boolean isWholeNumber(double num) {
		if (num % 1 == 0) return true;
		return false;
	}
}