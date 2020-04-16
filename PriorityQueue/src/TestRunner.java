import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static int main(String[] args) {
        Result result = JUnitCore.runClasses(PriorityQueueTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
        if(!result.wasSuccessful())
            return 1;
        else
            return 0;
    }
}
