#!/usr/bin/env python
# -------------------
# Project Euler Problem 25
# What is the first term in the Fibonacci sequence to contain 1000 digits?

import sys

def sum(a, b):
    result = [0]
    a = a[::-1]
    b = b[::-1]
    if len(b) > len(a):
        a, b = b, a
    for i in range(len(a)):
        if i >= len(b):
            r = a[i]
        else:
            r = a[i] + b[i]
        if r >= 10:
            result[i] += r - 10
            result.append(1)
        else:
            result[i] += r
            result.append(0)
    
    result = result[::-1]
    if result[0] == 0:
        result.pop(0)
    return result

def main():
    digits = [1]
    prev = digits
    current = digits
    result = sum(prev, current)
    count = 2
    
    while True:
        prev = current
        current = result
        result = sum(prev, current)
        count += 1
        if len(result) >= 1000:
            print "Fibbonaci Number %d is the first number to contain 1000 digits" % count
            break

if __name__ == '__main__':
    if len(sys.argv) == 1:
        main()
