package reference;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ReferenceMainTest {
    @Test
    void countsWaysForFiveSteps() {
        assertEquals(8, ReferenceMain.solve(5));
    }

    @Test
    void countsEmptyClimbAsOneWay() {
        assertEquals(1, ReferenceMain.solve(0));
    }

    @Test
    void handlesOneAndTwoSteps() {
        assertEquals(1, ReferenceMain.solve(1));
        assertEquals(2, ReferenceMain.solve(2));
    }

    @Test
    void appliesModuloForLargeStepCount() {
        assertEquals(782204094, ReferenceMain.solve(100));
    }
}
