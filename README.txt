Brian Rhee
CS251 PROJECT 2
1 Slip Day Used

compile:
javac -classpath .:stdlib.jar Brute.java
javac -classpath .:stdlib.jar Fast.java
javac -classpath .:stdlib.jar Point.java

run:
java -classpath .:stdlib.jar Brute < (file name)
java -classpath .:stdlib.jar Fast < (file name)

Brute uses quadruple nested while loop.

Fast has 3 extra functions:
	sort: uses insert sort to lexographically sort the points being outputted
	recorded: checks to see if the set of points have already been recorded and 
		outputted previously
	printArr: prints the array of points
	*When Fast is compiled in Vocareum the following is noted:
		"Note: Fast.java uses unchecked or unsafe operations.
		Note: Recompile with -Xlint:unchecked for details."
	I believe this is because I use the function call to .clone() in the 
	java.util.Arraylist library. However, there are no problems when the program is run.
	As far as my tests have shown. The program works as intended despite these notes.
