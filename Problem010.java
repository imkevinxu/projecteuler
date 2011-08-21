/*
 * File: Problem 10
 * Calculate the sum of all the primes below two million.
 * -----------------------
 */

import acm.program.*;

public class Problem010 extends ConsoleProgram {

	public void run() {
		long sum = 2;
		long number = 3;
		long start = System.currentTimeMillis();
		println("All the prime numbers under " + LIMIT + " are:");
		println();
		while (true) {
			if (isPrime(number)) {
				sum += number;
				print(number + " ");
			}
			number += 2;
			if (number >= LIMIT) break;
		}
		println();
		println();
		println("The total sum of these prime numbers is " + sum);
		long elapsed = System.currentTimeMillis() - start;
		println("Program took " + elapsed + " milliseconds " + convertTime(elapsed));
	}
	
	private boolean isPrime(long n) {
		for (long i = 3; i <= Math.pow(n, 0.5) + 1; i ++) {
			if (n % i == 0) return false;
		}
		return true;
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
	
	private static final long LIMIT = 2000000;
 }