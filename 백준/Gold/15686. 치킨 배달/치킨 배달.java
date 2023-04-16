import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main{
    static int n,m;
    static boolean[] visit;
    static int[][] map;
    static ArrayList<Node> house;
    static ArrayList<Node> chicken;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //도시크기
        m = Integer.parseInt(st.nextToken()); //살아남는 치킨의 수
        map = new int[n][n];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) house.add(new Node(j,i));
                else if(map[i][j] == 2) chicken.add(new Node(j,i));
            }
        }
        visit = new boolean[chicken.size()];
        dfs(0,0);
        System.out.println(result);
    }

    /**
     * DFS와 백트래킹 알고리즘 활용
     * 1) 집과 치킨 집의 좌표를 각각 저장
     * 2) 치킨집이 visit 한 개수가 m과 같다면, 모든 집에 대하여 m개의 치킨 집 중 최단 거리 계산
     * 3) 탐색을 시작하는 시점이 치킨집 list 사이즈를 벗어나게 되면 탐색 종료
     */

    public static void dfs(int start, int cnt){
        if(cnt == m) {
            int sum = 0;
            for(int i=0; i<house.size(); i++){
                int min = Integer.MAX_VALUE;
                for(int j=0; j<chicken.size(); j++){
                    if(visit[j]){ //m 개 만큼 선택한 치킨집만 거리를 구함
                        int distance = Math.abs(house.get(i).x - chicken.get(j).x)
                                + Math.abs(house.get(i).y - chicken.get(j).y);
                        min = Math.min(distance, min);
                    }
                }
                sum += min;
            }
            result = Math.min(result, sum);
            return;
        }
        for(int i=start; i<chicken.size(); i++){
            visit[i] = true;
            dfs(i+1, cnt+1);
            visit[i] = false;
        }
    }
}