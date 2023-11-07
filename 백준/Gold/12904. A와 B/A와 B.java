import java.io.*;
import java.util.*;

public class Main {
    public static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        while (S.length() < T.length()) {
            StringBuilder sb = new StringBuilder();
            if (T.endsWith("A")) {
                T = T.substring(0, T.length() - 1);
            } else if (T.endsWith("B")) {
                T = T.substring(0, T.length() - 1);
                T = sb.append(T).reverse().toString();
            }
        }
        if(S.equals(T)) System.out.println(1);
        else System.out.println(0);
    }
}
