import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();
        int length = scanner.nextInt();
        long steps = scanner.nextLong();
        int[] values = new int[length];

        for (int index = 0; index < length; index++) {
            values[index] = scanner.nextInt();
        }

        int[] answer = solve(values, steps);

        StringBuilder output = new StringBuilder();
        for (int index = 0; index < answer.length; index++) {
            if (index > 0) {
                output.append(' ');
            }
            output.append(answer[index]);
        }
        System.out.println(output);
    }

    static int[] solve(int[] values, long steps) {
        // TODO: 配列を左にsteps回巡回シフトした結果を返してください。
        throw new UnsupportedOperationException("Implement solve");
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
