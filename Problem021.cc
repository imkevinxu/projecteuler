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

int d(int n) {
	int sum = 1;
	int digit = 2;
	while (true) {
		if (digit > sqrt(n)) break;
		if (n % digit == 0) {
			sum += digit;
			sum += (n / digit);
		}
		digit++;
	}
	return sum;
}

bool amicable(int n1) {
	if (n1 == d(d(n1)) && n1 != d(n1)) return true;
	return false;
}

/* Main program */

int main() {
	welcome();
	int answer = 0;
	for (int i = 1; i < 10000; i++) {
		if (amicable(i)) answer += i;
	}
	cout << "Sum of all the amicable numbers under 10000 is " << answer;
	
	return 0;
}