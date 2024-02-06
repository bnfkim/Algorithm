import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, RESULT;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int tc=1; tc<=10; tc++) {
            N = Integer.parseInt(br.readLine());
            RESULT = 1;

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());

                if(st.countTokens() == 4) {
                    st.nextToken();
                    String op = st.nextToken();
                    if(Character.isDigit(op.charAt(0))) {
                        RESULT = 0;
                    }
                } else {
                    st.nextToken();
                    if(!Character.isDigit(st.nextToken().charAt(0))) {
                        RESULT = 0;
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(RESULT).append("\n");
        }
        System.out.println(sb);
    }
}