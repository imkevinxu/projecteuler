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

void fillVector(Vector<string> & vector, string line) {
	int start = 0;
	int finish = 0;
	while (finish <= line.size()) {
		finish++;
		if (line[finish] == '"') {
			vector.add(line.substr(start + 1, finish - start - 1));
			finish = finish + 2;
			start = finish;
		}
	}
}

void LinearSort(Vector<string> & vec);
void MergeSort(Vector<string> & vec);
void Merge(Vector<string> & vec, Vector<string> & v1, Vector<string> & v2);
void Quickysort(Vector<string> & vec);
void Quicksort(Vector<string> & vec, int start, int finish);
int Partition(Vector<string> & vec, int start, int finish);

struct name {
	string name;
	int order;
	int worth;
	int score;
};

/* Main program */

int main() {
	welcome();
	Randomize();
	Vector<string> vector;
	ifstream file;
	file.open("Problem022.txt");
	string line;
	getline(file, line);
	fillVector(vector, line);	
	Quickysort(vector);
	Vector<name> people;
	for (int i = 1; i <= vector.size(); i++) {
		name person;
		person.name = vector[i - 1];
		person.order = i;
		int worth = 0;
		for (int j = 0; j < vector[i - 1].size(); j++) {
			worth += vector[i - 1][j] - 64;
		}
		person.worth = worth;
		person.score = person.order * person.worth;
		people.add(person);
	}
	int totalScore = 0;
	for (int i = 0; i < people.size(); i++) {
		cout << "#" << people[i].order << " - " << people[i].name << " is worth " << people[i].worth << " - Score: " << people[i].score << endl;
		totalScore += people[i].score;
	}
	cout << endl << "Total Score: " << totalScore;
	return 0;
}

void LinearSort(Vector<string> & vec) {
	int n = vec.size();
	for (int lh = 0; lh < n; lh++) {
		int rh = lh;
		for (int i = lh + 1; i < n; i++) {
			if (vec[i] < vec[rh]) rh = i;
		}
		string temp = vec[lh];
		vec[lh] = vec[rh];
		vec[rh] = temp;
	} 
}

void Merge(Vector<string> & vec, Vector<string> & v1, Vector<string> & v2) {
	int n1 = v1.size();
	int n2 = v2.size();
	int p1 = 0;
	int p2 = 0;
	while (p1 < n1 && p2 < n2) {
		if (v1[p1] < v2[p2]) {
			vec.add(v1[p1++]);
		} else {
			vec.add(v2[p2++]);
		}
	}
	while (p1 < n1) vec.add(v1[p1++]);
	while (p2 < n2) vec.add(v2[p2++]);
} 

void MergeSort(Vector<string> & vec) {
	int n = vec.size();
	if (n <= 1) return;
	Vector<string> v1;
	Vector<string> v2;
	for (int i = 0; i < n; i++) {
		if (i < n / 2) {
			v1.add(vec[i]);
		} else {
			v2.add(vec[i]);
		}
	}
 	MergeSort(v1);
	MergeSort(v2);
	vec.clear();
	Merge(vec, v1, v2);
}

int Partition(Vector<string> & vec, int start, int finish) {
	string pivot = vec[start];
	int lh = start + 1;
	int rh = finish;
	while (true) {
		while (lh < rh && vec[rh] >= pivot) rh--;
		while (lh < rh && vec[lh] < pivot) lh++;
		if (lh == rh) break;
		string temp = vec[lh];
		vec[lh] = vec[rh];
		vec[rh] = temp;
	}
	if (vec[lh] >= pivot) return start;
	vec[start] = vec[lh];
	vec[lh] = pivot;
	return lh;
}

void Quicksort(Vector<string> & vec, int start, int finish) {
	if (start >= finish) return;
	int boundary = Partition(vec, start, finish);
	Quicksort(vec, start, boundary - 1);
	Quicksort(vec, boundary + 1, finish);
}

void Quickysort(Vector<string> & vec) {
	Quicksort(vec, 0, vec.size() - 1);
}