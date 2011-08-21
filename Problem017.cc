/**
 * File: Blank.cpp
 * --------------------
 * Play around with everything
 */

#include <iostream>
#include <iomanip>
#include <cstdio>
#include <cmath>
#include <string>
#include <stdlib.h>
#include "genlib.h"
#include "strutils.h"
#include "simpio.h"
#include "vector.h"
#include "set.h"

/* Function prototypes */

void welcome() {
	cout << "Hello World!" << endl;
}
string convertWithPref(int i, string pre) {
	if (i < 10) {
		switch (i) {
			case 1:
				pre += "one";
				break;
			case 2:
				pre += "two";
				break;
			case 3:
				pre += "three";
				break;
			case 4:
				pre += "four";
				break;
			case 5:
				pre += "five";
				break;
			case 6:
				pre += "six";
				break;
			case 7:
				pre += "seven";
				break;
			case 8:
				pre += "eight";
				break;
			case 9:
				pre += "nine";
				break;
			default:
				break;
		}
		return pre;
	}
	if (i < 20) {
		switch (i) {
			case 10:
				pre += "ten";
				break;
			case 11:
				pre += "eleven";
				break;
			case 12:
				pre += "twelve";
				break;
			case 13:
				pre += "thirteen";
				break;
			case 14:
				pre += "fourteen";
				break;
			case 15:
				pre += "fifteen";
				break;
			case 16:
				pre += "sixteen";
				break;
			case 17:
				pre += "seventeen";
				break;
			case 18:
				pre += "eighteen";
				break;
			case 19:
				pre += "nineteen";
				break;
			default:
				break;
		}
		return pre;
	}
	if (i < 100) {
		int tens = i / 10;
		switch (tens) {
			case 2:
				pre += "twenty";
				break;
			case 3:
				pre += "thirty";
				break;
			case 4:
				pre += "forty";
				break;
			case 5:
				pre += "fifty";
				break;
			case 6:
				pre += "sixty";
				break;
			case 7:
				pre += "seventy";
				break;
			case 8:
				pre += "eighty";
				break;
			case 9:
				pre += "ninety";
				break;
			default:
				break;
		}
		return convertWithPref(i % 10, pre);
	}
	if (i < 1000) {
		int hundreds = i / 100;
		switch (hundreds) {
			case 1:
				pre += "one";
				break;
			case 2:
				pre += "two";
				break;
			case 3:
				pre += "three";
				break;
			case 4:
				pre += "four";
				break;
			case 5:
				pre += "five";
				break;
			case 6:
				pre += "six";
				break;
			case 7:
				pre += "seven";
				break;
			case 8:
				pre += "eight";
				break;
			case 9:
				pre += "nine";
				break;
			default:
				break;
		}
		if (i % 100 == 0) {
			pre += "hundred";
		} else {
			pre += "hundredand";
		}
		return convertWithPref(i % 100, pre);
	}
	if (i == 1000) pre = "onethousand";	
	return pre;
}
string convert(int i) {
	return convertWithPref(i, "");
}

/* Main program */

int main() {
	welcome();
	int count = 0;
	for (int i = 1; i <= 1000; i++) {
		string str = convert(i);
		count += str.length();
		cout << str << endl;
	}
	cout << "Total length: " << count;
	return 0;
}