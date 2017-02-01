PYTHON = python
VIEWER = less


.PHONY: clean run 

prob1 : set.py
		$(PYTHON) set.py
		 
prob2: g.py
	   $(PYTHON) g.py
		  
run :  prob1 prob2 view	   

view : g.py
	   $(VIEWER) g.py	   

clean :
	- \rm $(outFile) > /dev/null 2>&1
	- \rm *.pyc > /dev/null 2>&1

