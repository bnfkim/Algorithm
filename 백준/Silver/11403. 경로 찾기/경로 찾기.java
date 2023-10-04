
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static int n;
    static int[][] graph;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        //그래프 입력받기
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)graph[i][j] = Integer.parseInt(st.nextToken());
        }
        floydWarshall();

        print();
    }
    public static void floydWarshall() {
        // (1) i에서 j까지 갈 수 있는가?
        // (2) i에서 k로 가고, k에서 j로 갈 수 있는가?
        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    //단순히 갈 수 있는 경로가 있는지만 체크
                    if(graph[i][k]==1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

    }
    public static void print() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< graph.length; i++){
            for(int j=0; j< graph.length; j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}