/*
 * File: Problem 6
 * What is the difference between the sum of the squares and the square of the sums?
 * -----------------------
 */

import acm.program.*;

public class Problem006 extends ConsoleProgram {

	public void run() {
		int min = 1;
		int max = readInt("First how many numbers? ");
		int sum = sumSquare(min, max);
		int square = squareSum(min, max);
		println();
		println("The difference between the sum of the squares of the first");
		println(max + " hundred natural numbers and the square of the sum is " + (square - sum));
	}
	
	private int sumSquare(int min, int max) {
		int sum = 0;
		for (int i = min; i <= max; i++) {
			sum += i * i;
		}
		return sum;
	}
	
	private int squareSum(int min, int max) {
		int sum = 0;
		for (int i = min; i <= max; i++) {
			sum += i;
		}
		int square = sum * sum;
		return square;
	}
}