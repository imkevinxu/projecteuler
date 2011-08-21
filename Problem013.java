/*
 * File: Problem 13
 * Find the first ten digits of the sum of one-hundred 50-digit numbers.
 * -----------------------
 */

import acm.program.*;
import java.io.*;
import java.util.ArrayList;

public class Problem013 extends ConsoleProgram {

	public void run() {
		long start = System.currentTimeMillis();
		try {
			BufferedReader rd = new BufferedReader(new FileReader("Number 013.txt"));
			initFirstLine(rd);
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				arrayLine(line);
				addToSum(adder);
			}
			sum = reverseArray(sum);
			println("The sum of the one-hundred 50-digit numbers is:");
			for (int i = 0; i < sum.size(); i++) {
				print(sum.get(i));
			}
			println();
			println();
			print("And the first ten digits are... ");
			for (int i = 0; i < 10; i++) {
				print(sum.get(i));
			}
			println();
			println();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		long elapsed = System.currentTimeMillis() - start;
		println("Program took " + elapsed + " milliseconds " + convertTime(elapsed));
	}
	
	private void arrayLine(String line) {
		adder.clear();
		for (int i = 0; i < 50; i++) {
			int digit = Integer.parseInt(line.substring(i, i + 1));
			adder.add(digit);
		}
		adder = reverseArray(adder);
	}
	
	private ArrayList<Integer> reverseArray(ArrayList<Integer> array) {
		ArrayList<Integer> reverseNumArray = new ArrayList<Integer>();
		for (int i = array.size() - 1; i >= 0; i--) {
			reverseNumArray.add(array.get(i));
		}
		return reverseNumArray;
	}
	
	private void initFirstLine(BufferedReader rd) throws IOException {
		String firstLine = rd.readLine();
		arrayLine(firstLine);
		addToSum(adder);
	}
	
	private void addToSum(ArrayList<Integer> addingArray) {
		int i = 0;
		int one = 0;
		int ten = 0;
		int addend = 0;
		while (true) {
			if (addingArray.size() <= i) {
				if (ten == 0) break;
				if (sum.size() <= i) {
					sum.add(0);
				}
				addend = 0;
			} else if (sum.size() <= i) {
				sum.add(0);
				addend = addingArray.get(i);
			} else {
				addend = addingArray.get(i);
			}
			int digit = sum.get(i) + addend + ten;
			ten = 0;
			if (digit > 9) {
				one = digit % 10;
				ten = digit / 10;
			} else {
				one = digit;
			}
			sum.set(i, one);
			i++;
		}
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
	
	ArrayList<Integer> sum = new ArrayList<Integer>();
	ArrayList<Integer> adder = new ArrayList<Integer>();
 }