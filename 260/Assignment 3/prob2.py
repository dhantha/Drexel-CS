#!/usr/bin/python
import sys
import timeit
from memoize import memoize

@memoize	
def fib2(n):
	if n == 0 or n == 1:
		return 1
	else:
		return fib2(n-1) + fib2(n-2)
		

	
arg = sys.argv[1]
if (arg.isdigit()):
	print "" 
else:
	sys.exit("Argument is not a digit")

fibm = fib2(int(arg))
print fibm