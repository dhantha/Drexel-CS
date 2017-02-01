#!/usr/bin/env python
#
# pfCalc.python
#
# Dhantha Gunarathna
# 10/27
#

import sys
import re

argc = len(sys.argv)
stack = []
pattern = re.compile("\d+")

''' 
Please note that for some reason the '*' gives the name of the program 
for example: python pfCalc.py 2 3.2 *
will add 
(2 3.2 pfCalc.py )
to the stack. 
Therefore i had to check for the name of the program and if its the program that operator is multiplication
However, the name of the program is hard code into the conditionals so dont change the name of the program, it will error out
this issue is only with the '*' operator 
'''
	
# post fix arithmetic reader
# start with the first token
for i in range(1,argc):
	if (sys.argv[i] != '+' and sys.argv[i] != '-' and sys.argv[i] != 'pfCalc.py' and sys.argv[i] != '/' and sys.argv[i] != '^' ):
		# if it's a operand, push it to the stack
		if(pattern.match(sys.argv[i])):
			stack.append(sys.argv[i])		
		
	elif (sys.argv[i] == '+' or sys.argv[i] == '-' or sys.argv[i] == '*' or sys.argv[i] == '/' or sys.argv[i] == 'pfCalc.py' or sys.argv[i] == '^'):
		# its an operator
		
		# not suffecient operands 
		stackLength = len(stack)
		if stackLength < 2:
			print '-E-'			
			exit()
		
		# pop top value into y
		y = float(stack.pop())

                x = float(stack.pop())
		oper = sys.argv[i]
		
		if oper == '+':
			result = str(x + y)
		elif oper == '-':
			result = str(x - y)							
		elif oper == '/':
			result = str(x / y)	
		elif (sys.argv[i] == 'pfCalc.py'):
			result = str(x * y)
		elif oper == '^':
			result = str(pow(x,y))
		
		stack.append(result)			
			
# more than one operand in the stack
finalStackLength = len(stack)
if finalStackLength > 1:
		print '-E-'
		#print finalStackLength
		exit()

fianlResult = stack.pop()
print fianlResult

	

