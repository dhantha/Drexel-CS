#!/usr/bin/env python
#
# Create a file, one expression per line
#	 redirect from standard input:
#		test.py < input
#
# Notes:  We are not making our input bullet-proof.  If it looks like a #,
# then it is
#
#		Operands must be integers
#
#		The parser doesn't handle negative operands
#
from __future__ import print_function
import re
import sys
#from pythonds.basic import Stack
from binaryTree import *
from lexer import *


pStack = []
#binTree = BinaryTree('')
#pStack.push(binTree)
#currentTree = binTree

while get_expression():
	t = get_next_token()
	while t:
		#print str(t)
		if str.isdigit( t ) : # we have a (non-negative) number
			#op = 'operand'
			#print str(t)
			node = BinaryTree(int(t))
			pStack.append(node)
			#print "append node"
		else:
			#op = 'operator' #+ - * /
			y = pStack.pop()
			x = pStack.pop()
			root = BinaryTree(str(t))
			root.insertLeft(x)
			root.insertRight(y)
			pStack.append(root)			
			
		#print 'Got token: ' + t + ' (an ' + op + ')'
		t = get_next_token()
	
	binTree = pStack.pop()	
	#inorder(binTree)
	print("Pre: ",end=" ")
	binTree.preorder()
	print(" ")
	print("In : ",end=" ")
	binTree.inorder()
	print(" ")
	print("Post : ",end=" ")
	binTree.postorder()
	print(" ")
	print("Eval: ",end=" ")
	print(postordereval(binTree))
	#binTree.postordereval()
	print(" ")
	



