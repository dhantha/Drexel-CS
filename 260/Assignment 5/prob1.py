#!/usr/bin/python
#from __future__ import print_function
from binaryTree import *
import math
import timeit
import random

list = []
#root = BinaryTree()
def down_heap(h,i):
	level = i
	lastRun = False
	if level == 1:
		lastRun = True
	numNodes = math.pow(2,i-1)
	#print(numNodes)
	arrayLen = len(h)
	firstRun = False
	#print(i)
	if(i == int(math.log((len(h)+1),2))):
		#print("1st run")
		firstRun = True
	nodesInLevel = int(numNodes*2 - 2)
	while(numNodes != 0):
		#print(nodesInLevel)
		root = BinaryTree(h[nodesInLevel])
		h[nodesInLevel] = root
		if not firstRun:
			root.insertLeft(h[(2*nodesInLevel)+1])
			root.insertRight(h[(2*nodesInLevel)+2])
		# always should be 2 elemts in the stack 
		# unless leaf 
		'''
		if(lastRun):
			root.inorder()
			print("\n")
		
		if len(pStack) >= 2:
			y = stack.pop()
			x = stack.pop()
			root.insertLeft(x)
			root.insertRight(y)
			pStack.append(root)
		'''
		#stack.append(node)
		nodesInLevel = nodesInLevel - 1
		numNodes = numNodes - 1
	
	

def make_heap(h):
	#print("heap")
	elements = len(h)
	n = int(math.log((elements+1),2))
	#print(n)
	for i in range(n,0,-1):
		down_heap(h,i)
		#print(i)
	
	#root = BinaryTree(int(stack.pop))
	#for i in range(1,n+1):.
'''
if __name__ == '__main__':
	from binaryTree import *
	import math
	heap = [1,2,3,4,5,6,7]
	make_heap(heap)
	#print("here")
cd '''
	
target = open('mydata.txt','w')
for i in range(1,11):
	randomList =  random.sample(xrange(100),15)
	l = randomList[:]
	t1 = timeit.Timer("make_heap(randomList)","from __main__ import make_heap, randomList")
	delta = t1.timeit(1)
	line  = (" ".join(str(x) for x in l))	
	line = line + " " + str(delta)
	target.write(line)
	target.write("\n")

target.close()
