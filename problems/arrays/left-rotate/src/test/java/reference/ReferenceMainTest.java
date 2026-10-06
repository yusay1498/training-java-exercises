package reference;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class ReferenceMainTest {
    @Test
    void rotatesBySeveralPositions() {
        int[] values = {1, 2, 3, 4, 5, 6, 7};

        ReferenceMain.rotateLeft(values, 3);

        assertArrayEquals(new int[]{4, 5, 6, 7, 1, 2, 3}, values);
    }

    @Test
    void handlesStepsGreaterThanArrayLength() {
        int[] values = {1, 2, 3, 4, 5, 6, 7};

        ReferenceMain.rotateLeft(values, 10);

        assertArrayEquals(new int[]{4, 5, 6, 7, 1, 2, 3}, values);
    }

    @Test
    void leavesArrayUnchangedWhenStepsAreZero() {
        int[] values = {-3, 0, 8};

        ReferenceMain.rotateLeft(values, 0);

        assertArrayEquals(new int[]{-3, 0, 8}, values);
    }

    @Test
    void handlesSingleElementAndVeryLargeStepCount() {
        int[] values = {42};

        ReferenceMain.rotateLeft(values, 1_000_000_000_000_000_000L);

        assertArrayEquals(new int[]{42}, values);
    }
}