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

int findMax(Vector<Vector<int> > vector, int currMax, int prevMax, int row, int col, int prevCol, Vector<int> &v) {
	if (row == vector.size()) return currMax;
	if (col < prevCol || col > prevCol + 1) return currMax;
	prevMax += vector[row][col];
	v.add(prevMax);
	if (row < vector.size() - 1) {
		for (int i = 0; i < vector[row + 1].size(); i++) {
			currMax = findMax(vector, currMax, prevMax, row + 1, i, col, v);
			if (prevMax > currMax) currMax = prevMax;
		}
	}
	return currMax;
}

/* Main program */

int main() {
	welcome();
	ifstream file;
	file.open("Problem018.txt");
	Scanner scanner;
	scanner.setSpaceOption(Scanner::IgnoreSpaces);
	scanner.setNumberOption(Scanner::ScanNumbersAsReals);
	string line;
	Vector<Vector<int> > vector;
	while (getline(file, line)) {
		if (line == "") break;
		scanner.setInput(line);
		Vector<int> vec;
		while (scanner.hasMoreTokens()) {
			int n = StringToInteger(scanner.nextToken());
			vec.add(n);
		}
		vector.add(vec);
	}
	Vector<int> v;
	int max = 0;
	findMax(vector, 0, 0, 0, 0, 0, v);
	for (int i = 0; i < v.size(); i++) {
		int temp = v[i];
		if (temp > max) max = temp;
	}
	cout << "Maximum Total: " << max;
	return 0;
}