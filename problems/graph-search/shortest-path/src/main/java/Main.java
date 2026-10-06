import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();
        int vertexCount = scanner.nextInt();
        int edgeCount = scanner.nextInt();
        int[][] edges = new int[edgeCount][2];

        for (int index = 0; index < edgeCount; index++) {
            edges[index][0] = scanner.nextInt();
            edges[index][1] = scanner.nextInt();
        }

        System.out.println(solve(vertexCount, edges));
    }

    static int solve(int vertexCount, int[][] edges) {
        // TODO: 頂点1から頂点vertexCountまでの最短距離を返してください。
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
