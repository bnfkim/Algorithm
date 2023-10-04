
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static final int INF = 10000;
    static int n;
    static int[][] graph;
    static int[] scores;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n+1][n+1];
        scores = new int[n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++) {
                if(i != j) graph[i][j] = INF;
            }
        }

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());

            if(f1==-1 && f2==-1) break;

            graph[f1][f2] = graph[f2][f1] = 1; //친구 사이는 양방향
        }
        floydWarshall();
        findCandidateByNum(calMinScore());
    }
    public static void floydWarshall() {
        // (1) i에서 j까지 갈 수 있는가?
        // (2) i에서 k로 가고, k에서 j로 갈 수 있는가?
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    //단순히 갈 수 있는 경로가 있는지만 체크
                    if(graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }
    public static int calMinScore() {
        int result = INF;
        for(int i=1; i<=n; i++) {
            int score = 0;
            for(int j=1; j<=n; j++){
                if(graph[i][j] != INF) score = Math.max(score, graph[i][j]);
            }
            scores[i] = score;
            result = Math.min(result, score);
        }
        return result;
    }
    public static void findCandidateByNum(int num){
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            if(scores[i]==num) {
                cnt++;
                sb.append(i).append(" ");
            }
        }
        System.out.println(num + " " + cnt);
        System.out.println(sb);
    }
}