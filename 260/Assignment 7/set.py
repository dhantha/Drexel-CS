#!/usr/bin/python

class Node:
	def __init__(self,value):
		self.parent = self
		self.value = value
		self.rank = 0
		
	def __str__(self):
		return self.value
		

#def MakeSet(x):
#	x.parent = x
#	x.rank = 0
	

def Initialize(Values):
	# values is a list for the set
	l = [Node(val) for val in Values]
	#[MakeSet(node) for node in l]
	
	return l
	 
	'''
	returnSet = []
	lenVal = len(Values)
	#n = 0
	for i in range (0,lenVal):
		temp = set()
		returnSet.append(temp.add(Values[i]))
		#if i not in returnSet:
		#	returnSet.append(set())
			#n = n + 1
	#for i in range(0,len(returnSet)):
	#	print returnSet[i]
	#print len(returnSet)
	return returnSet
	'''

def Find(set, value):

	
	for s in range(len(set)):
		if value != set[s].parent:
			set[s].parent = Find(set[s:],set[s].parent)
		return set[s]
	'''
	setLen = len(list_set)
	temp = set()
	temp.add(value)
	for i in range (0,setLen):
		if(list_set[i] == temp):
			return True
	#if value in 
	return False
	'''
	
def Merge(set, val1, val2):
	setVal1 = Find(set,val1)
	setVal2 = Find(set,val2)
	if setVal1 == setVal2:
		return
	elif setVal1.rank < setVal2.rank:
		setVal1.parent = setVal2
	elif setVal1.rank > setVal2.rank:
			setVal2.parent = setVal1
	else:
			setVal2.parent = setVal1
			setVal1.rank += 1
			#if set_val_1.rank == set_val_2.rank:
                #        set_val_2.rank += 1
