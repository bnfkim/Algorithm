import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

    static Deque<Integer> deque;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        while(T-->0) {
            int tc = Integer.parseInt(br.readLine());

            deque = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<8; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            int idx = 1;
            while(true) {
                int first = deque.pollFirst();
                //System.out.println("first = " + first);
                if(first - idx <= 0) break;

                deque.addLast(first-idx);
                idx++;

                if(idx == 6) idx = 1;
            }
            deque.addLast(0);
            sb.append("#").append(tc).append(" ");
            while(!deque.isEmpty()) sb.append(deque.pollFirst() + " ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}