#!/usr/bin/python

'''
Write a function called list_concat_copy( A, B )
that takes two lists and returns a list that is the concatenation of both of them,
'''

def list_concat_copy(A,B):
	a = list(A)
	b = list(B)
	return zip(a,b)

