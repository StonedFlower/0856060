all: compileTest

compileTest:
	mkdir -p bin
	javac -classpath /usr/share/java/junit4.jar src/PriorityQueueTest.java -d bin

compileTestANS:
	mkdir -p bin
	javac -classpath /usr/share/java/junit4.jar src/PriorityQueueTest.java -d bin

runCov:
	rm bin/*.exec 2> /dev/null || true
	cd bin ; java -cp .:/usr/share/java/junit4.jar PriorityQueueTest

kill:
	killall python3

clean:
	rm -r bin/*.class bin/*.exec bin/reportDir 2> /dev/null || true
