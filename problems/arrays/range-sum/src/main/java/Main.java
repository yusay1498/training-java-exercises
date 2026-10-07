import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();
        int length = scanner.nextInt();
        int queryCount = scanner.nextInt();
        int[] values = new int[length];

        for (int index = 0; index < length; index++) {
            values[index] = scanner.nextInt();
        }

        int[][] queries = new int[queryCount][2];
        for (int index = 0; index < queryCount; index++) {
            queries[index][0] = scanner.nextInt();
            queries[index][1] = scanner.nextInt();
        }

        long[] answers = solve(values, queries);
        StringBuilder output = new StringBuilder();
        for (long answer : answers) {
            output.append(answer).append(System.lineSeparator());
        }
        System.out.print(output);
    }

    static long[] solve(int[] values, int[][] queries) {
        // TODO: 累積和を使い、各1始まり区間[L, R]の合計を返してください。
        throw new UnsupportedOperationException("Implement solve");
    }

    private static class FastScanner {
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer tokenizer;

        int nextInt() throws IOException {
            return Integer.parseInt(next());
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
