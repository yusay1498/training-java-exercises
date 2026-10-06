package reference;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ReferenceMainTest {
    @Test
    void returnsFirstPositionWhenTargetAppearsMoreThanOnce() {
        assertEquals(3, ReferenceMain.solve(new int[]{1, 2, 4, 4, 4, 7, 9, 10}, 4));
    }

    @Test
    void returnsMinusOneWhenTargetIsMissingBetweenValues() {
        assertEquals(-1, ReferenceMain.solve(new int[]{1, 3, 5, 7}, 4));
    }

    @Test
    void findsTargetAtFirstAndLastPositions() {
        int[] values = {-5, -2, 0, 3, 8};

        assertEquals(1, ReferenceMain.solve(values, -5));
        assertEquals(5, ReferenceMain.solve(values, 8));
    }

    @Test
    void returnsMinusOneWhenTargetIsOutsideArrayBounds() {
        int[] values = {2, 4, 6};

        assertEquals(-1, ReferenceMain.solve(values, 1));
        assertEquals(-1, ReferenceMain.solve(values, 7));
    }
}
