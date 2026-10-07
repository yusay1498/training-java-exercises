package reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReferenceMain {
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
        long[] prefix = new long[values.length + 1];
        for (int index = 0; index < values.length; index++) {
            prefix[index + 1] = prefix[index] + values[index];
        }

        long[] answers = new long[queries.length];
        for (int index = 0; index < queries.length; index++) {
            int left = queries[index][0];
            int right = queries[index][1];
            answers[index] = prefix[right] - prefix[left - 1];
        }
        return answers;
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
