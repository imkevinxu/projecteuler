/*
 * File: Problem 15
 * Starting in the top left corner in a 20 by 20 grid, how many routes are there to the bottom right corner?
 * -----------------------
 */

import acm.program.*;

public class Problem015 extends ConsoleProgram {

	public void run() {
		long start = System.currentTimeMillis();
		
		Integer[][] triangle = new Integer[LIMIT + 1][LIMIT + 1];
		int i, j;
		for (i = 0; i <= LIMIT; i++) {
			for (j = 0; j <= i; j++) {
				triangle[i][j] = 0;
				if (i == j || j == 0) {
					triangle[i][j] = 1;
				} else {
					triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
				}
				print(triangle[i][j] + " ");
			}
			println();
		}
		long count = 0;
		for (i = 0; i <= LIMIT; i++) {
			count += (Math.pow(triangle[LIMIT][i], 2));
		}
		println();
		println("There are " + count + " ways to navigate a " + LIMIT + " x " + LIMIT + " grid.");
		println();
		
		long elapsed = System.currentTimeMillis() - start;
		println("Program took " + elapsed + " milliseconds " + convertTime(elapsed));
	}
	
	private String convertTime(long elapsed) {
		String time = "(";
		int milliseconds = (int) elapsed % 1000;
		int seconds = (int) elapsed / 1000;
		int minutes = seconds / 60;
		int hours = minutes / 60;
		minutes -= hours * 60;
		seconds -= hours * 60 * 60 + minutes * 60;
		time += hours + " hours, ";
		time += minutes + " minutes, ";
		time += seconds + " seconds, and ";
		time += milliseconds + " milliseconds)";
		return time;		
	}
	
	private static final int LIMIT = 20;
}