all: compileTest

compileTest:
	mkdir -p bin
	javac -classpath /usr/share/java/junit4.jar:/usr/share/java/junit5.jar src/PriorityQueueTest.java -d bin
	
run:
	rm bin/*.exec 2> /dev/null || true
	cd bin ; java -cp .:/usr/share/java/junit4.jar:/usr/share/java/junit5.jar PriorityQueueTest

kill:
	killall python3

clean:
	rm -r bin/*.class bin/*.exec bin/reportDir 2> /dev/null || true
