#!/usr/bin/python

import random
import timeit

import problem1
import problem2
import anotherFile

target = open('mydata.txt', 'w')

#A =  random.sample(range(1,100000),1000)
#B =  random.sample(range(1,100000),1000)

mytime = timeit.Timer('list_concat(anotherFile.A,anotherFile.B)', 'from problem1 import list_concat; import anotherFile')
delta1 = mytime.timeit(1)

print "1 run of list_concat took: " + str(delta1) + " seconds."
print ''

mytime = timeit.Timer('list_concat_copy(anotherFile.A,anotherFile.B)', 'from problem2 import list_concat_copy; import anotherFile')
delta2 = mytime.timeit(1)

print "1 run of list_concat_copy took: " + str(delta2) + " seconds."
print ''

line = '15000 ' + str(delta1) + " " + str(delta2)
target.write(line)
target.write("\n")

target.close()
