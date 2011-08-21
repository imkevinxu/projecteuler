/*
 * File: Problem 14
 * Find the longest sequence using a starting number under one million.
 * -----------------------
 */

import acm.program.*;

public class Problem014 extends ConsoleProgram {

	public void run() {
		long start = System.currentTimeMillis();
		long answer = 0;
		int count = 1;
		int longestCount = count;
		for (int i = 1; i <= LIMIT; i++) {
			long n = i;
			while (n > 1) {
				n = collatz(n);
				count++;
			}
			if (count > longestCount) {
				longestCount = count;
				answer = i;
			}
			count = 1;
		}
		println("The number " + answer + " has the longest chain with " + longestCount + " terms.");
		println();
		print("The sequence is: " + answer + " -> ");
		while (answer > 1) {
			answer = collatz(answer);
			if (answer == 1) {
				print(answer + ".");
			} else {				
				print(answer + " -> ");
			}
		}
		println();
		println();
		long elapsed = System.currentTimeMillis() - start;
		println("Program took " + elapsed + " milliseconds " + convertTime(elapsed));
	}
	
	private long collatz(long n) {
		if (n % 2 == 0) {
			n /= 2;
		} else {
			n = 3 * n + 1;
		}
		return n;
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
	
	private static final int LIMIT = 1000000;
 }