#!/usr/bin/python

import sys
import select

INF = 999999999

def printDistanceMatrix(distGraph):

    string = "INF"
    nodes =distGraph.keys()

    for i in nodes:
        #print"%s"%(i),
        for j in nodes:
            if distGraph[i].get(j,INF) == 999999999:
                sys.stdout.write('%4s' % (string))
                print("here")
				#print "%s"%(string),
            else:
				sys.stdout.write('%4s' % (distGraph[i][j]))
                #print "s"%(distGraph[i][j]),
        print" "

def floydWarshall(graph):

    nodes = graph.keys() # get all the keys of the python dic
    distanceMatrix = {} # inizialize the distance matrix

    for n in nodes:
        distanceMatrix[n] = {}
        for k in nodes:
            distanceMatrix[n][k] = graph[n][k]
			
    for k in nodes:
        for i in nodes:
            for j in nodes:
                if distanceMatrix[i].get(k,INF) + distanceMatrix[k].get(j,INF) < distanceMatrix[i][j]:
                    distanceMatrix[i][j] = distanceMatrix[i].get(k,INF)+distanceMatrix[k].get(j,INF)

    printDistanceMatrix(distanceMatrix)

if __name__ == '__main__':
    graph = {}
    f = open('example.input','r')
    for line in f:
        entry = line.split()
        key = entry[0]
        if not graph.has_key(key):
            graph[key] = {}
        graph[key][key] = 0
        for i in range (1,len(entry)):
            s = entry[i].split(',')
            #graph[key][key] = 0
            graph[key][s[0]] = int(s[1])
            if not graph.has_key(s[0]):
#                print "here"
                graph[s[0]] = {}
            graph[s[0]][key] = int(s[1])
    f.close()
    val =  graph['3'].get('1',INF)
    #print val
    for x in graph:
       # print x
        graphLen = len(graph)
        for i in range(0,graphLen):
#            print(y, ':',graph[x][y])
            if not graph[x].has_key(str(i)):
                graph[x][str(i)] = 999999999
           # print (str(i),':',graph[x][str(i)])
        
            
    floydWarshall(graph)
'''
    for line in sys.stdin:
        entry = line.split()
        for e in entry:
            print e
    exit(0)
        #lineLength  = len(line)
        #print lineLength 

    graph = {'0':{'1':28,'3':33},

             '1':{'2':10,'4':44,'0':28},

             '2':{'3':50,'1':10},

             '3':{'4':30,'2':50,'4':33},

             '4':{'1':44,'3':30}

             }
'''
    
	
