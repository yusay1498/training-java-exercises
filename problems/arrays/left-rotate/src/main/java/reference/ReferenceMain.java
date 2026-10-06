package reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReferenceMain {
    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();
        int length = scanner.nextInt();
        long steps = scanner.nextLong();
        int[] values = new int[length];

        for (int index = 0; index < length; index++) {
            values[index] = scanner.nextInt();
        }

        rotateLeft(values, steps);

        StringBuilder output = new StringBuilder();
        for (int index = 0; index < length; index++) {
            if (index > 0) {
                output.append(' ');
            }
            output.append(values[index]);
        }
        System.out.println(output);
    }

    static void rotateLeft(int[] values, long steps) {
        int shift = (int) (steps % values.length);
        reverse(values, 0, shift - 1);
        reverse(values, shift, values.length - 1);
        reverse(values, 0, values.length - 1);
    }

    private static void reverse(int[] values, int left, int right) {
        while (left < right) {
            int temporary = values[left];
            values[left] = values[right];
            values[right] = temporary;
            left++;
            right--;
        }
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
