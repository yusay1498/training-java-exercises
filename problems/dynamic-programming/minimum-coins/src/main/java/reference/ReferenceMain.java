package reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ReferenceMain {
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
        int unreachable = target + 1;
        int[] minimumCoins = new int[target + 1];
        Arrays.fill(minimumCoins, unreachable);
        minimumCoins[0] = 0;

        for (int amount = 1; amount <= target; amount++) {
            for (int denomination : denominations) {
                if (denomination <= amount && minimumCoins[amount - denomination] != unreachable) {
                    minimumCoins[amount] = Math.min(
                            minimumCoins[amount], minimumCoins[amount - denomination] + 1);
                }
            }
        }

        return minimumCoins[target] == unreachable ? -1 : minimumCoins[target];
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
