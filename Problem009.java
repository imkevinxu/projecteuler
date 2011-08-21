/*
 * File: Problem 9
 * Find the only Pythagorean triplet, {a, b, c}, for which a + b + c = 1000.
 * -----------------------
 */

import acm.program.*;

public class Problem009 extends ConsoleProgram {

	public void run() {
		Integer[] abc = new Integer[3];
		for (int i = 0; i < abc.length; i++) {
			abc[i] = 1;
		}
		int number = 1;
		int product = 1;
		int sum = 0;
		@SuppressWarnings("unused")
		boolean flag = false;
		while (true) {
			sum = 0;
			abc = createPyth(number, abc[1] + 1);
			if (abc[1] >= LIMIT) {
				abc[1] = 1;
				flag = true;
			}
			for (int i = 0; i < abc.length; i++) {
				sum += abc[i];
			}
			if (sum == LIMIT) break;
			if (flag = true) {
				number++;
				flag = false;
			}
		}
		println("A Pythagorean triplet for which a + b + c = 1000 is: ");
		print("  ");
		for (int i = 0; i < abc.length; i++) {
			print(abc[i] + " ");
		}
		println();
		for (int i = 0; i < abc.length; i++) {
			product *= abc[i];
		}
		println("The product of a, b, and c is " + product);
	}
	
	private Integer[] createPyth(int number, int number2) {
		Integer[] abc = new Integer[3];
		while (true) {
			a = number;
			while (true) {
				b = number2;
				c = (int) Math.pow(a * a + b * b, 0.5);
				if (a * a + b * b == c * c || b > LIMIT) {
					break;
				} else {
					number2++;
				}
			}
			if (a * a + b * b == c * c || b > LIMIT) break;
			number++;
		}
		abc[0] = (int) a;
		abc[1] = (int) b;
		abc[2] = (int) c;
		return abc;
	}
	
	private int a = 0;
	private int b = 0;
	private int c = 0;
	private int LIMIT = 1000;
}