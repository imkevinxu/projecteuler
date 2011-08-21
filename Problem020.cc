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

void swap(string & n1, string & n2) {
	string temp = n1;
	n1 = n2;
	n2 = temp;
}

string multiply(string n1, string n2) {
	string product;
	if (n2.size() > n1.size()) {
		swap(n1, n2);
	} else if (n2.size() == n1.size()) {
		for (int i = 0; i < n1.size(); i++) {
			if (n2[i] > n1[i]) {
				swap(n1, n2);
				break;
			}
		}
	}
	Vector<int> v1;
	Vector<int> v2;
	Vector<int> answer;
	Vector<Vector<int > > addends;
	int lineCount = 0;
	for (int i = n1.size() - 1; i >= 0 ; i--) {
		v1.add(n1[i] - 48);
	}
	for (int i = n2.size() - 1; i >= 0 ; i--) {
		v2.add(n2[i] - 48);
	}
	for (int i = 0; i < v2.size(); i++) {
		Vector<int> line;
		int carry = 0;
		for (int j = 0; j < lineCount; j++) {
			line.add(0);
		}
		for (int j = 0; j < v1.size(); j++) {
			int n = v1[j] * v2[i] + carry;
			if (n >= 10 && j != (v1.size() - 1)) {
				carry = n / 10;
				n %= 10;
			} else {
				carry = 0;
			}
			if (n >= 10) {
				line.add(n % 10);
				n /= 10;
			}
			line.add(n);
		}
		addends.add(line);
		lineCount++;
	}
	int carry = 0;
	for (int i = 0; i < addends[addends.size() - 1].size() ; i++) {
		int n = 0;
		for (int j = 0; j < addends.size(); j++) {
			if (i < addends[j].size()) n += addends[j][i];
		}
		n += carry;
		if (n >= 10 && i != (addends[addends.size() - 1].size() - 1)) {
			carry = n / 10;
			n %= 10;
		} else {
			carry = 0;
		}
		if (n >= 10) {
			answer.add(n % 10);
			n /= 10;
		}
		answer.add(n);
	}
	for (int i = answer.size() - 1; i >= 0; i--) {
		product += ('0' + answer[i]);
	}
	
	return product;
}

string factorial(string n) {
	if (n == "0") {
		return "1";
	} else {
		string n2 = IntegerToString(StringToInteger(n) - 1);
		return multiply(n, factorial(n2));
	}
}

/* Main program */

int main() {
	welcome();
	string n = "100";
	string digit = factorial(n);
	cout << n << "! = " << digit << endl << endl;
	int digitSum = 0;
	for (int i = 0; i < digit.size(); i++) {
		digitSum += digit[i] - 48;
	}
	cout << "Sum of digits is: " << digitSum;
	return 0;
}