import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N; //편의점 갯수
    public static boolean[][] cost;
    static ArrayList<Node> nodeList;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++) {
            input();
            solve();
            sb.append(cost[0][N+1] ? "happy" : "sad").append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        cost = new boolean[N + 2][N + 2]; //집 + 편의점 + 락 페스티벌 까지의 이동 가능한 여부 판별 배열
        nodeList = new ArrayList<>();

        for(int i = 0; i < N + 2; i++) {
            st = new StringTokenizer(br.readLine());
            nodeList.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        //집 - 편의점 사이 거리 구하기 + 편의점 - 집 사이 거리 구하기
        for(int i = 0; i < N + 2; i++) {
            Node n1 = nodeList.get(i);
            for(int j = 0; j < N + 2; j++) {
                if(i == j) continue;
                Node n2 = nodeList.get(j);
                //갖고 있는 맥주로 해당 위치를 갈 수 있는지 여부
                if(getDistance(n1.x, n1.y, n2.x, n2.y) <= 1_000) cost[i][j] = true;
            }
        }
    }

    public static void solve() {
        for (int k = 1; k <= N; k++) {                      //경유지 = 편의점
            for(int i = 0; i <= N; i++) {                   //출발지 = (집 + 편의점)
                for(int j = 1; j <= N + 1; j++) {            //도착지 = (편의점 + 페스티벌)
                    //출발지에서 도착지로 모두 갈 수 있는지 확인
                    if(cost[i][k] && cost[k][j]) cost[i][j] = true;
                }
            }
        }
    }

    public static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1- x2) + Math.abs(y1 - y2);
    }
}