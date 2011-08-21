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
#include "map.h"
#include "scanner.h"
#include "set.h"
#include "simpio.h"
#include "strutils.h"
#include "vector.h"

/* Function prototypes */

void welcome() {
	cout << "Hello World!" << endl;
}
string whatDay(int n) {
	string result;
	switch (n) {
		case 1:
			result = "Monday";
			break;
		case 2:
			result = "Tuesday";
			break;
		case 3:
			result = "Wednesday";
			break;
		case 4:
			result = "Thursday";
			break;
		case 5:
			result = "Friday";
			break;
		case 6:
			result = "Saturday";
			break;
		case 7:
			result = "Sunday";
			break;
		default:
			break;
	}
	return result;
}

/* Main program */

int main() {
	welcome();
	int count = 2;
	Vector<Vector<Vector<string> > > calendar;
	for (int i = 1901; i <= 2000; i++) {
		Vector<Vector<string> > year;
		for (int j = 1; j <= 12; j++) {
			Vector<string> month;
			switch (j) {
				case 1:
					for (int k = 1; k <= 31; k++) {
						month.add(whatDay(count++));
						if (count % 8 == 0) count = 1;
					}
					year.add(month);
					break;
				case 2:
					int leap;
					if (i % 4 == 0) {
						leap = 29;
					} else {
						leap = 28;
					}
					for (int k = 1; k <= leap; k++) {
						month.add(whatDay(count++));
						if (count % 8 == 0) count = 1;
					}
					year.add(month);
					break;
				case 3:
					for (int k = 1; k <= 31; k++) {
						month.add(whatDay(count++));
						if (count % 8 == 0) count = 1;
					}
					year.add(month);
					break;
				case 4:
					for (int k = 1; k <= 30; k++) {
						month.add(whatDay(count++));
						if (count % 8 == 0) count = 1;
					}
					year.add(month);
					break;
				case 5:
					for (int k = 1; k <= 31; k++) {
						month.add(whatDay(count++));
						if (count % 8 == 0) count = 1;
					}
					year.add(month);
					break;
				case 6:
					for (int k = 1; k <= 30; k++) {
						month.add(whatDay(count++));
						if (count % 8 == 0) count = 1;
					}
					year.add(month);
					break;
				case 7:
					for (int k = 1; k <= 31; k++) {
						month.add(whatDay(count++));
						if (count % 8 == 0) count = 1;
					}
					year.add(month);
					break;
				case 8:
					for (int k = 1; k <= 31; k++) {
						month.add(whatDay(count++));
						if (count % 8 == 0) count = 1;
					}
					year.add(month);
					break;
				case 9:
					for (int k = 1; k <= 30; k++) {
						month.add(whatDay(count++));
						if (count % 8 == 0) count = 1;
					}
					year.add(month);
					break;
				case 10:
					for (int k = 1; k <= 31; k++) {
						month.add(whatDay(count++));
						if (count % 8 == 0) count = 1;
					}
					year.add(month);
					break;
				case 11:
					for (int k = 1; k <= 30; k++) {
						month.add(whatDay(count++));
						if (count % 8 == 0) count = 1;
					}
					year.add(month);
					break;
				case 12:
					for (int k = 1; k <= 31; k++) {
						month.add(whatDay(count++));
						if (count % 8 == 0) count = 1;
					}
					year.add(month);
					break;
				default:
					break;
			}
		}
		calendar.add(year);
	}
	int answer = 0;
	for (int i = 0; i < calendar.size(); i++) {
		for (int j = 0; j < calendar[i].size(); j++) {
			if (calendar[i][j][0] == "Sunday") answer++;
		}
	}
	cout << "Total # of Sundays: " << answer;
	
	return 0;
}