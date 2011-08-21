/*
 * File: Problem 8
 * Discover the largest product of five consecutive digits in the 1000-digit number.
 * -----------------------
 */

import acm.program.*;
import java.io.*;
import java.util.ArrayList;

public class Problem008 extends ConsoleProgram {

	public void run() {
		try {
			BufferedReader rd = new BufferedReader(new FileReader("Number 008.txt"));
			ArrayList<Integer> numArray = parseInteger(rd);
			int largestProduct = 1;
			for (int i = 0; i < numArray.size() - 5; i++) {
				int product = 1;
				for (int j = i; j < i + 5; j++) {
					product *= numArray.get(j);
				}
				if (product > largestProduct) {
					largestProduct = product;
				}
			}
			println("The greatest product of five consecutive digits in the 1000-digit number is " + largestProduct);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private ArrayList<Integer> parseInteger(BufferedReader rd) throws IOException {
		ArrayList<Integer> numArray = new ArrayList<Integer>();
		while (true) {
			String line = rd.readLine();
			if (line == null) break;
			int digit = 0;
			for (int i = 0; i < line.length() - 1; i++) {
				digit = Integer.parseInt(line.substring(i, i + 1));
				numArray.add(digit);
			}
			digit = Integer.parseInt(line.substring(line.length() - 1));
			numArray.add(digit);
		}
		return numArray;
	}
}