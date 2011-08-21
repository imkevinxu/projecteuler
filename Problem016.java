/*
 * File: Problem 16
 * What is the sum of the digits of the number 21000?
 * -----------------------
 */

import acm.program.*;

public class Problem016 extends ConsoleProgram {

	public void run() {
		long start = System.currentTimeMillis();
		//Play
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
}