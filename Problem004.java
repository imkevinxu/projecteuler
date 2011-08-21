/*
 * File: Problem 4
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * -----------------------
 */

import acm.program.*;
import java.util.ArrayList;

public class Problem004 extends ConsoleProgram {

	public void run() {
		int number = 0;
		int largestPalindrome = 0;
		int digit = readInt("How many digits in multipliers? ");
		for (int i = (int) Math.pow(10, digit - 1); i < (int) Math.pow(10, digit); i++) {
			for (int j = (int) Math.pow(10, digit - 1); j < (int) Math.pow(10, digit); j++) {
				number = i * j;
				if (isPalindrome(number)) {
					if (number > largestPalindrome) largestPalindrome = number;
				}
			}
		}
		println();
		println("The largest palindrome from " + digit + "-digit multipliers is " + largestPalindrome);
	}
	
	private boolean isPalindrome(int number) {
		ArrayList<Integer> numArray = parseInteger(number);
		for(int i = 0; i < numArray.size() - 1; i++) {
			if (numArray.get(i) != numArray.get(numArray.size() - (i + 1))) return false;
		}
		return true;
	}
	
	private ArrayList<Integer> parseInteger(int number) {
		ArrayList<Integer> numArray = new ArrayList<Integer>();
		int parseInt = number;
		while (parseInt > 0) {
			int digit = parseInt % 10;
			numArray.add(digit);
			parseInt /= 10;
		}
		ArrayList<Integer> reverseNumArray = new ArrayList<Integer>();
		for (int i = numArray.size() - 1; i >= 0; i--) {
			reverseNumArray.add(numArray.get(i));
		}
		return reverseNumArray;
	}
}