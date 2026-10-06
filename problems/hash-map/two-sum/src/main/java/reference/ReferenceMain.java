package reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ReferenceMain {
    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();
        int length = scanner.nextInt();
        long target = scanner.nextLong();
        int[] values = new int[length];

        for (int index = 0; index < length; index++) {
            values[index] = scanner.nextInt();
        }

        int[] answer = solve(values, target);
        System.out.println(answer[0] + " " + answer[1]);
    }

    static int[] solve(int[] values, long target) {
        Map<Long, Integer> earlierPositions = new HashMap<>();

        for (int right = 0; right < values.length; right++) {
            long complement = target - values[right];
            Integer left = earlierPositions.get(complement);
            if (left != null) {
                return new int[]{left + 1, right + 1};
            }
            earlierPositions.putIfAbsent((long) values[right], right);
        }

        return new int[]{-1, -1};
    }

    private static class FastScanner {
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer tokenizer;

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        private String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String line = reader.readLine();
                if (line == null) {
                    throw new IOException("Unexpected end of input");
                }
                tokenizer = new StringTokenizer(line);
            }
            return tokenizer.nextToken();
        }
    }
}
