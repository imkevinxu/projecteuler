/*
 * File: Problem 2
 * Find the sum of all the even-valued terms in the Fibonacci sequence which do not exceed four million.
 * -----------------------
 */

import acm.program.*;

public class Problem002 extends ConsoleProgram {

	public void run() {
		int sum = 0;
		println("All the numbers in the Fibonacci sequence under " + LIMIT + " are:");
		int i = 1; println(i);
		int j = 2; println(j); sum += j;
		int k = 0;
		while (k < LIMIT) {
			k = i + j;
			if (k >= LIMIT) break;
			i = j; j = k;
			if (k % 2 == 0) sum += k;
			println(k);
		}
		println("The sum of all the even-valued terms in the sequence is " + sum);
	}
	
	private static final int LIMIT = 4000000;
}