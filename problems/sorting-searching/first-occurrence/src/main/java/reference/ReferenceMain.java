package reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReferenceMain {
    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();
        int length = scanner.nextInt();
        int target = scanner.nextInt();
        int[] values = new int[length];

        for (int index = 0; index < length; index++) {
            values[index] = scanner.nextInt();
        }

        System.out.println(solve(values, target));
    }

    static int solve(int[] values, int target) {
        int left = 0;
        int right = values.length;

        while (left < right) {
            int middle = left + (right - left) / 2;
            if (values[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        if (left == values.length || values[left] != target) {
            return -1;
        }
        return left + 1;
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
