import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int steps = Integer.parseInt(reader.readLine().trim());
        System.out.println(solve(steps));
    }

    static int solve(int steps) {
        // TODO: 1段または2段ずつ上ってsteps段目へ到達する方法数を返してください。
        throw new UnsupportedOperationException("Implement solve");
    }
}
