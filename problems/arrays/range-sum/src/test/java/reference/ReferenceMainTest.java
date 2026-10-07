package reference;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class ReferenceMainTest {
    @Test
    void answersMultipleRangesIncludingNegativeValues() {
        int[] values = {3, -1, 4, 1, 5};
        int[][] queries = {{1, 3}, {2, 5}, {4, 4}};

        assertArrayEquals(new long[]{6, 9, 1}, ReferenceMain.solve(values, queries));
    }

    @Test
    void handlesSingleElementRangesAtBothEnds() {
        int[] values = {-7, 2, 9};
        int[][] queries = {{1, 1}, {3, 3}};

        assertArrayEquals(new long[]{-7, 9}, ReferenceMain.solve(values, queries));
    }

    @Test
    void usesLongForLargeRangeSums() {
        int[] values = {1_000_000_000, 1_000_000_000, 1_000_000_000};
        int[][] queries = {{1, 3}, {2, 3}};

        assertArrayEquals(new long[]{3_000_000_000L, 2_000_000_000L}, ReferenceMain.solve(values, queries));
    }

    @Test
    void handlesTheWholeArrayAsOneRange() {
        int[] values = {5, -10, 8, 2};
        int[][] queries = {{1, 4}};

        assertArrayEquals(new long[]{5}, ReferenceMain.solve(values, queries));
    }
}
