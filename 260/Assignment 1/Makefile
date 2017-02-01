PYTHON = python
VIEWER = less

.PHONY: clean run view

run :  hello.py
	#chmod u+x hello.py 
	$(PYTHON) hello.py

view : hello.py
	   $(VIEWER) hello.py 

clean :
	- \rm $(outFile) > /dev/null 2>&1
	- \rm *.pyc > /dev/null 2>&1

