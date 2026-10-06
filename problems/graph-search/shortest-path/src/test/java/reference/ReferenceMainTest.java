package reference;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ReferenceMainTest {
    @Test
    void findsShortestDistanceWhenSeveralPathsExist() {
        int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {3, 4}, {4, 5}, {2, 6}};

        assertEquals(2, ReferenceMain.solve(6, edges));
    }

    @Test
    void returnsMinusOneWhenTargetIsDisconnected() {
        int[][] edges = {{1, 2}, {3, 4}};

        assertEquals(-1, ReferenceMain.solve(4, edges));
    }

    @Test
    void handlesGraphWithoutEdges() {
        assertEquals(-1, ReferenceMain.solve(2, new int[0][2]));
    }

    @Test
    void handlesCyclesAndDuplicateEdges() {
        int[][] edges = {{1, 2}, {2, 3}, {3, 1}, {2, 3}, {3, 4}};

        assertEquals(2, ReferenceMain.solve(4, edges));
    }
}
