package reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class ReferenceMain {
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
        if (!answers.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), answers));
        }
    }

    static List<String> solve(int[][] operations) {
        Deque<Integer> incoming = new ArrayDeque<>();
        Deque<Integer> outgoing = new ArrayDeque<>();
        List<String> answers = new ArrayList<>();

        for (int[] operation : operations) {
            int type = operation[0];
            if (type == 1) {
                incoming.push(operation[1]);
                continue;
            }

            moveIfNeeded(incoming, outgoing);
            if (outgoing.isEmpty()) {
                answers.add("EMPTY");
            } else if (type == 2) {
                answers.add(Integer.toString(outgoing.pop()));
            } else {
                answers.add(Integer.toString(outgoing.peek()));
            }
        }

        return answers;
    }

    private static void moveIfNeeded(Deque<Integer> incoming, Deque<Integer> outgoing) {
        if (outgoing.isEmpty()) {
            while (!incoming.isEmpty()) {
                outgoing.push(incoming.pop());
            }
        }
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
