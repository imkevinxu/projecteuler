/*
 * File: Problem 12
 * What is the value of the first triangle number to have over five hundred divisors?
 * -----------------------
 */

import acm.program.*;
import java.util.ArrayList;

public class Problem012 extends ConsoleProgram {

	public void run() {
		int n = 1;
		long start = System.currentTimeMillis();
		println("Here is a list of triangle numbers and their number of divisors:");
		println();
		while (true) {
			ArrayList<Integer> factors = new ArrayList<Integer>();
			print(createNaturalNumber(n) + ": ");
			print(numberOfFactors(createNaturalNumber(n), factors) + " with factors ");
			for (int i = 0; i < factors.size(); i++) {
				print(factors.get(i) + ", ");
			}
			print(createNaturalNumber(n));
			println();
			println();
			if (numberOfFactors(createNaturalNumber(n), factors) >= LIMIT) break;
			n++;
		}
		println();
		println(createNaturalNumber(n) + ", the " + n + "th triangle number is the first triangle number with over " + LIMIT + " divisors");
		long elapsed = System.currentTimeMillis() - start;
		println("Program took " + elapsed + " milliseconds " + convertTime(elapsed));
	}
	
	private long createNaturalNumber(int n) {
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		return sum;
	}
	
	private int numberOfFactors(long number, ArrayList<Integer> factors) {
		int count = 1;
		for (int i = 1; i < number / 2 + 1; i++) {
			if (number % i == 0) {
				count++;
				factors.add(i);
			}
		}
		return count;
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
	
	private int LIMIT = 5;
 }