import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.println(combination(n, m));
    }
    public static BigInteger combination(int n, int m) {

        m = Math.min(n - m, m);

        BigInteger n1 = BigInteger.ONE;
        BigInteger n2 = BigInteger.ONE;

        while(m != 0) {
            n1 = n1.multiply(new BigInteger(String.valueOf(n)));
            n2 = n2.multiply(new BigInteger(String.valueOf(m)));

            n--;
            m--;
        }

        return n1.divide(n2);
    }
}