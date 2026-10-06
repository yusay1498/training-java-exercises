package reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ReferenceMain {
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
        List<List<Integer>> graph = new ArrayList<>(vertexCount);
        for (int vertex = 0; vertex < vertexCount; vertex++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int first = edge[0] - 1;
            int second = edge[1] - 1;
            graph.get(first).add(second);
            graph.get(second).add(first);
        }

        int[] distances = new int[vertexCount];
        Arrays.fill(distances, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        distances[0] = 0;
        queue.add(0);

        while (!queue.isEmpty()) {
            int current = queue.remove();
            for (int neighbor : graph.get(current)) {
                if (distances[neighbor] == -1) {
                    distances[neighbor] = distances[current] + 1;
                    queue.add(neighbor);
                }
            }
        }

        return distances[vertexCount - 1];
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
