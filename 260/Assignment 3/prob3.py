#!/usr/bin/python

import timeit
from memoize import memoize 

def fib1(n):
	if n == 0 or n == 1:
		return 1
	return fib1(n-1) + fib1(n-2)

@memoize	
def fib2(n):
	if n == 0 or n == 1:
		return 1
	else:
		return fib2(n-1) + fib2(n-2)


for i in range(1,41):
	t1 = timeit.Timer("fib1(" + str(i) + ")", "from  __main__ import fib1")	
	delta1 = t1.timeit(1)
	#fibm1 = fib1(int(arg)) 
	#print fibm1

	t2 = timeit.Timer("fib2(" + str(i) + ")", "from __main__ import fib2")	
	delta2 = t2.timeit(1)
	#fibm2 = fib2(int(arg))
	#print fibm2
	line = str(i) + " | " + str(delta1) + " | " + str(delta2) 
	print line
	


target = open('mydata.txt','w')

for i in range(1,41):
	#t1 = timeit.Timer("fib1(" + str(i) + ")", "from  prob1 import fib1")	
	#delta1 = t1.timeit(1)
	#fibm1 = fib1(int(arg)) 
	#print fibm1

	t2 = timeit.Timer("fib2(" + str(i) + ")", "from  __main__ import fib2")	
	delta2 = t2.timeit(1)
	#fibm2 = fib2(int(arg))
	#print fibm2
	line = str(i) + " " + str(delta2) 
	target.write(line)
	target.write("\n")

target.close()
