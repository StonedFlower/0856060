all: compileTest

compileTest:
	mkdir -p bin
	javac -classpath /usr/share/java/junit4.jar:./lib/junit-jupiter-api-5.3.2.jar src/PriorityQueueTest.java -d bin
	
run:
	rm bin/*.exec 2> /dev/null || true
	cd bin ; java -javaagent:../lib/jacocoagent.jar -cp .:/usr/share/java/junit4.jar:./lib/junit-jupiter-api-5.3.2.jar PriorityQueueTest

kill:
	killall python3

clean:
	rm -r bin/*.class bin/*.exec bin/reportDir 2> /dev/null || true
