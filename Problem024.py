#!/usr/bin/env python
# -------------------
# Project Euler Problem 25
# What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

import sys
from itertools import permutations

def main():
    perms = permutations(range(10))
    count = 0
    for p in perms:
        count += 1
        if count == 1000000:
            print "".join(str(i) for i in p)


if __name__ == '__main__':
    if len(sys.argv) == 1:
        main()
