package reference;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;

class ReferenceMainTest {
    @Test
    void processesEnqueueFrontAndDequeueInFifoOrder() {
        int[][] operations = {
                {1, 10}, {1, 20}, {3}, {2}, {1, 30}, {2}, {2}, {2}
        };

        assertEquals(List.of("10", "10", "20", "30", "EMPTY"), ReferenceMain.solve(operations));
    }

    @Test
    void reportsEmptyForFrontAndDequeueOnEmptyQueue() {
        int[][] operations = {{3}, {2}, {1, 5}, {2}, {3}};

        assertEquals(List.of("EMPTY", "EMPTY", "5", "EMPTY"), ReferenceMain.solve(operations));
    }

    @Test
    void preservesNegativeValuesAsQueueData() {
        int[][] operations = {{1, -1}, {3}, {2}};

        assertEquals(List.of("-1", "-1"), ReferenceMain.solve(operations));
    }

    @Test
    void transfersElementsOnlyAfterOutgoingStackBecomesEmpty() {
        int[][] operations = {{1, 1}, {1, 2}, {2}, {1, 3}, {2}, {2}};

        assertEquals(List.of("1", "2", "3"), ReferenceMain.solve(operations));
    }

    @Test
    void printsNothingWhenEveryOperationEnqueues() throws Exception {
        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(new ByteArrayInputStream("3\n1 4\n1 5\n1 6\n".getBytes()));
            System.setOut(new PrintStream(output));

            ReferenceMain.main(new String[0]);

            assertEquals("", output.toString());
        } finally {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }
    }
}
