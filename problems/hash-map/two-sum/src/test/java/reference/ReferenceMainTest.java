package reference;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class ReferenceMainTest {
    @Test
    void findsPairWithTargetSum() {
        assertArrayEquals(new int[]{1, 2}, ReferenceMain.solve(new int[]{2, 7, 11, 15}, 9));
    }

    @Test
    void usesDifferentPositionsForEqualValues() {
        assertArrayEquals(new int[]{1, 2}, ReferenceMain.solve(new int[]{3, 3}, 6));
    }

    @Test
    void returnsNoPairWhenTargetCannotBeFormed() {
        assertArrayEquals(new int[]{-1, -1}, ReferenceMain.solve(new int[]{1, 2, 4}, 8));
    }

    @Test
    void handlesLargeTarget() {
        assertArrayEquals(new int[]{1, 2}, ReferenceMain.solve(new int[]{1_000_000_000, 1_000_000_000}, 2_000_000_000L));
    }
}
