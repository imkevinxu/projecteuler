/*
 * File: Problem 1
 * Add all the natural numbers below one thousand that are multiples of 3 or 5.
 * -----------------------
 */

import acm.program.*;

public class Problem001 extends ConsoleProgram {

	public void run() {
		int count = 0;
		println("These are all the natural numbers below ");
		println(LIMIT + " that are multiples of 3 or 5.");
		for (int i = 0; i < LIMIT; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				println(i);
				count += i;
			}
		}
		println("The total sum is " + count);
	}
	
	private static final int LIMIT = 1000;
}