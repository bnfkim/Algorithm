import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

    static int N,M;
    static LinkedList<Integer> passwords;
    static String[] commands;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for (int tc=1; tc<=10; tc++){
            N = Integer.parseInt(br.readLine()); //원본 암호문의 길이
            passwords = new LinkedList<>();
            st = new StringTokenizer(br.readLine()); //원본 암호문
            for(int i=0; i<N; i++) {
                passwords.add(Integer.parseInt(st.nextToken()));
            }

            M = Integer.parseInt(br.readLine());
            commands = new String[M];
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()) {
                String start = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                for(int i=0; i<y; i++) {
                    Integer newPassword = Integer.parseInt(st.nextToken());
                    passwords.add(x+i, newPassword);
                }
            }

            sb.append("#").append(tc).append(" ");
            for(int i=0; i<10; i++) {
                sb.append(passwords.get(i)).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}