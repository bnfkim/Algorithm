import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc < testCase; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            char[] chars = st.nextToken().toCharArray();

            for(Character ch : chars){
                sb.append(ch.toString().repeat(cnt));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
