import java.io.*;
import java.util.*;

public class Main {
    public static int n,k;
    public static int[] visit = new int[100_001];
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //수빈이가 있는 위치
        k = Integer.parseInt(st.nextToken()); //동생이 있는 위치

        if(n==k) System.out.println(0);
        else bfs();

    }
    public static void bfs() {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visit[n] = 1;

        while (!queue.isEmpty()) {
            int pos = queue.poll();

            for(int i=0; i<3; i++) {
                int next;

                if(i==0) next = pos+1;
                else if(i==1) next = pos-1;
                else next = pos*2;

                if(next==k) {
                    System.out.println(visit[pos]);
                    return;
                }

                if(next>=0 && next<visit.length && visit[next] == 0) {
                    queue.add(next);
                    visit[next] = visit[pos] + 1;
                }
            }
        }
    }
}