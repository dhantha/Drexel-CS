PYTHON = python
VIEWER = less
GNU = gnuplot
PLOT = plot-instructions

.PHONY: clean run 

prob1 : probl.py
		$(PYTHON) prob1.py $(arg)
		 
prob2: prob2.py
	   $(PYTHON) prob2.py $(arg)
		  
prob3: prob3.py
	   $(PYTHON) prob3.py
	   $(GNU) < $(PLOT)
		  
run :  prob1 prob2 prob3 view	   

view : prob3.py
	   $(VIEWER) prob3.py	   

clean :
	- \rm $(outFile) > /dev/null 2>&1
	- \rm *.pyc > /dev/null 2>&1

