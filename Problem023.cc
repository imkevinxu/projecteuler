/**
 * File: Blank.cpp
 * --------------------
 * Play around with everything
 */

#include <iostream>
#include <iomanip>
#include <cstdio>
#include <cmath>
#include <ctime>
#include <string>
#include <stdlib.h>
#include "genlib.h"
#include "map.h"
#include "random.h"
#include "scanner.h"
#include "set.h"
#include "simpio.h"
#include "strutils.h"
#include "vector.h"

/* Function prototypes */

void welcome() {
	cout << "Hello World!" << endl;
}

bool isAbundant(int n) {
	Vector<int> propDivisors;
	for (int i = 1; i <= n / 2; i++) {
		if (n % i == 0) propDivisors.add(i);
	}
	int sum = 0;
	for (int i = 1; i < propDivisors.size(); i++) {
		sum += propDivisors[i];
	}
	if (sum > n) return true;
	return false;
}

void FillAbundants(Vector<int> & abundants) {
	int n = 0;
	while (n < 28123) {
		n++;
		if (isAbundant(n)) abundants.add(n);
	}
}

/* Main program */

int main() {
	welcome();
	Vector<int> abundants;
	FillAbundants(abundants);
	Set<int> v;
	for (int i = 1; i <= 28123; i++) {
		v.add(i);
	}
	for (int i = 0; i < abundants.size(); i++) {
		for (int j = 0; j < abundants.size(); j++) {
			v.remove(abundants[i] + abundants[j]);
		}
	}
	int total = 0;
	foreach (int n in v) {
		cout << n << endl;
		total += n;
	}
	cout << "Sum of all the positive integers which cannot be written as the sum of two abundant numbers: ";
	cout << total;
	return 0;
}