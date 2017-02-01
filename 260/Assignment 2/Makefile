PYTHON = python
VIEWER = less

.PHONY: clean run 

problem1 : problem1.py
		   $(PYTHON) problem1.py
		 
problem2: problem2.py
		  $(PYTHON) problem2.py
		  
problem3: problem3.py
		  $(PYTHON) problem3.py
		  
run :  problem1 problem2 problem3 view	   

view : cell.py
	   $(VIEWER) cell.py	   

clean :
	- \rm $(outFile) > /dev/null 2>&1
	- \rm *.pyc > /dev/null 2>&1

