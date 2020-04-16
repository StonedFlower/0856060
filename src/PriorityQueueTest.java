import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

@RunWith(Parameterized.class)
public class PriorityQueueTest {

    private PriorityQueue pq;
    private int ans[];

    
    public PriorityQueueTest(int input[], int output[]){
        //Print(input);
        //System.out.print(input.length);

        pq = new PriorityQueue();
        for(int i=0;i < input.length;++i)
            pq.add(input[i]);
        ans = Arrays.copyOf(output, output.length);
    }

    private static int[] random_int_array(){
        return (new Random().ints(300, 0,10000)).toArray();
    }

    @Parameterized.Parameters
    public static Collection addNumbers(){
        int testcase[] = random_int_array();
        int sorted[] = Arrays.copyOf(testcase, testcase.length);
        Arrays.sort(sorted);

        //for(int i=0;i<testcase.length;++i)
        //    System.out.println(testcase[i]);

        return Arrays.asList( new int[][][]{
                {{}, {}},
                {{1,1,1,1,1},{1,1,1,1,1}},
                {{2, 4, 1, 3, 5}, {1, 2, 3, 4, 5}},
                {{50,40,30,10,20}, {10,20,30,40,50}},
                {testcase, sorted},
        });
    }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void Init_pq_with_zero_capacity() {
        pq = new PriorityQueue(0);
    }
    @Test(expected = java.lang.ClassCastException.class)
    public void More_than_one_datatype_in_pq() {
        pq.add(123);
        pq.add('a');
    }
    @Test(expected = java.lang.NullPointerException.class)
    public void Null_insertion_on_pg(){
        pq.add(null);
    }

    @Test
    public void Same_as_answer(){
        int index=0;
        while(pq.peek() != null) {
            assertTrue(index<ans.length);
            assertEquals((int) pq.poll(), ans[index++]);
        }
        assertEquals(index, ans.length);
    }

}
