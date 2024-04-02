import java.io.*;

public class Main {
    static final int pisano = 15 * 100000;
    private static int MOD = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine()) % pisano;
        long[] fibo = new long[(int)N + 1];

        fibo[0] = 0;
        fibo[1] = 1;

        for(int i = 2; i <= N; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % MOD;
        }
        System.out.print(fibo[(int)N]);
    }
}