/*
 * File: Problem 5
 * What is the smallest number divisible by each of the numbers 1 to 20?
 * -----------------------
 */

import acm.program.*;

public class Problem005 extends ConsoleProgram {

	public void run() {
		long number = 1;
		int min = readInt("Smallest divisible number? ");
		int max = readInt("Largest divisible number? ");
		while (true) {
			if (isDivisible(number, min, max)) break;
			number++;
		}
		println();
		println("The smallest divisible number that is evenly divisible");
		println("by all of the numbers from " + min + " and " + max + " is " + number);
	}
	
	private boolean isDivisible(long number, int min, int max) {
		for (int i = min; i <= max; i++) {
			if (number % i != 0) return false;
		}
		return true;
	}
}