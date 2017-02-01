#!/usr/bin/env python
# python class for the binary tree and eval 
from __future__ import print_function
import operator

class BinaryTree:
    
    def __init__(self,rootObj): # set up the initial node with root 
        self.key = rootObj
        self.leftChild = None
        self.rightChild = None

    def insertLeft(self,newNode): # set the left child 
        if self.leftChild == None:
            self.leftChild = newNode
        else:
            t = newNode
            t.left = self.leftChild
            self.leftChild = t
    
    def insertRight(self,newNode): # set the right child 
        if self.rightChild == None:
            self.rightChild = newNode
        else:
            t = newNode
            t.right = self.rightChild
            self.rightChild = t
	# getters for the children
    def getRightChild(self):
        return self.rightChild

    def getLeftChild(self):
        return self.leftChild

    def getRootVal(self):
        return self.key
	# tree traversal 
    def inorder(self):
        if self.leftChild:
            self.leftChild.inorder()
        print(self.key, end=" ")
		#result = str(self.key)
        if self.rightChild:
            self.rightChild.inorder()
		#return result

    def postorder(self):
        if self.leftChild:
            self.leftChild.postorder()
        if self.rightChild:
            self.rightChild.postorder()
        print(self.key,end=" ")


    def preorder(self):
        print(self.key,end=" ")
        if self.leftChild:
            self.leftChild.preorder()
        if self.rightChild:
            self.rightChild.preorder()

    

# eval function outside the class
def postordereval(tree):
    opers = {'+':operator.add, '-':operator.sub, '*':operator.mul, '/':operator.truediv}
    res1 = None
    res2 = None
    if tree:
        res1 = postordereval(tree.getLeftChild())  
        res2 = postordereval(tree.getRightChild()) 
        if res1 and res2:
            return opers[tree.getRootVal()](res1,res2) 
        else:
            return tree.getRootVal()



		
