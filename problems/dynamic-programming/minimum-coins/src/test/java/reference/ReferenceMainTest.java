package reference;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ReferenceMainTest {
    @Test
    void findsMinimumWhenGreedyChoiceWouldUseMoreCoins() {
        assertEquals(2, ReferenceMain.solve(new int[]{1, 3, 4}, 6));
    }

    @Test
    void returnsMinusOneWhenTargetCannotBeMade() {
        assertEquals(-1, ReferenceMain.solve(new int[]{4, 6}, 5));
    }

    @Test
    void returnsZeroForZeroTarget() {
        assertEquals(0, ReferenceMain.solve(new int[]{2, 5}, 0));
    }

    @Test
    void ignoresDenominationsLargerThanTarget() {
        assertEquals(3, ReferenceMain.solve(new int[]{2, 7, 20}, 6));
    }
}
