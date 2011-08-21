/*
 * File: Problem 7
 * Find the 10001st prime.
 * -----------------------
 */

import acm.program.*;

public class Problem007 extends ConsoleProgram {

	public void run() {
		long number = 1;
		int count = 1;
		int limit = readInt("Which number-th prime number? ");
		while (count <= limit) {
			number++;
			if (isPrime(number)) {
				count++;
			}
		}
		println("The " + limit + "-th prime number is " + number);
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