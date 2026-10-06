import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();
        int queryCount = scanner.nextInt();
        int[][] operations = new int[queryCount][];

        for (int index = 0; index < queryCount; index++) {
            int type = scanner.nextInt();
            operations[index] = type == 1
                    ? new int[]{type, scanner.nextInt()}
                    : new int[]{type};
        }

        List<String> answers = solve(operations);
        System.out.println(String.join(System.lineSeparator(), answers));
    }

    static List<String> solve(int[][] operations) {
        // TODO: 2つのスタックを使ってキュー操作を処理してください。
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
