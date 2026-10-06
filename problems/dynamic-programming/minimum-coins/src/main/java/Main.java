import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();
        int coinTypeCount = scanner.nextInt();
        int target = scanner.nextInt();
        int[] denominations = new int[coinTypeCount];

        for (int index = 0; index < coinTypeCount; index++) {
            denominations[index] = scanner.nextInt();
        }

        System.out.println(solve(denominations, target));
    }

    static int solve(int[] denominations, int target) {
        // TODO: targetを作るために必要な最小の硬貨枚数を返してください。
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
