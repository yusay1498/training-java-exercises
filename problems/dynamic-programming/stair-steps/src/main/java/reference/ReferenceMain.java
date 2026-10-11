package reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReferenceMain {
    private static final int MODULUS = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int steps = Integer.parseInt(reader.readLine().trim());
        System.out.println(solve(steps));
    }

    static int solve(int steps) {
        if (steps == 0) {
            return 1;
        }

        int[] ways = new int[steps + 1];
        ways[0] = 1;
        ways[1] = 1;
        for (int step = 2; step <= steps; step++) {
            ways[step] = (int) (((long) ways[step - 1] + ways[step - 2]) % MODULUS);
        }
        return ways[steps];
    }
}
