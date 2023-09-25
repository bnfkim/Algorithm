import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.*;

class Main{
    static int[][] arr;
    static boolean[] visit;
    static int N, M, result;
    public static void main(String[] args) throws IOException {
        /**
         * 가장 적은 종류 -> bfs 사용
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //국가의 수
            M = Integer.parseInt(st.nextToken()); //비행기 종류

            result = 0;
            arr = new int[N+1][N+1]; //방문하는 비행기 배열
            visit = new boolean[N+1]; //방문한 나라 확인하는 배열

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[a][b] = 1;
                arr[b][a] = 1;
            }
            bfs();
            sb.append(result-1).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;

        while(!queue.isEmpty()) {
            result++;
            int country = queue.poll();
            for(int i=1; i<=N; i++){
                if(arr[country][i] != 0 && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}