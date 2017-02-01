#!/usr/bin/python 

graph = {'A': set(['B', 'D','I']),
         'B': set(['A', 'C', 'H']),
         'C': set(['B', 'D','G','E','F']),
         'D': set(['A','C','I']),
         'E': set(['C', 'F']),
         'F': set(['C', 'E','G']),
         'G': set(['C','F','H']),
	 'H': set(['B','G']),
	 'I': set(['A','D'])}
		 
def dfs(graph, startNode):
    visitedNodes, stack = set(), [startNode]
    while stack: # use the stack to keep track of the nodes 
        vertex = stack.pop() # pop visited nodes 
	#print(vertex)
        if vertex not in visitedNodes:
            visitedNodes.add(vertex)
            stack.extend(graph[vertex] - visitedNodes)
	print(visitedNodes)
    return visitedNodes
	
def bfs(graph, startNode):
    visitedNodes, queue = set(), [startNode]
    while queue:
        vertex = queue.pop(0) # use queue to insert or pop vertex
        if vertex not in visitedNodes:
            visitedNodes.add(vertex)
            queue.extend(graph[vertex] - visitedNodes)
	print(visitedNodes)
    return visitedNodes
	
	
if __name__ == "__main__": 
	dfs(graph, 'A') 
	bfs(graph,'A')
