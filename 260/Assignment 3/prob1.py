#!/usr/bin/python
import sys

def fib1(n):
	if n == 0 or n == 1:
		return 1
	return fib1(n-1) + fib1(n-2)
		

arg = sys.argv[1]
if (arg.isdigit()):
	print "" 
else:
	sys.exit("Argument is not a digit")

fibm = fib1(int(arg))
print fibm


		
