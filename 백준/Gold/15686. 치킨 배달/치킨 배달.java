import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Position {
    int x;
    int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[] visited;
    static ArrayList<Position> chickenList, houseList, selected;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        map = new int[N][N];

        selected = new ArrayList<>();
        chickenList = new ArrayList<>();
        houseList = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2) chickenList.add(new Position(j, i));
                if(map[i][j] == 1) houseList.add(new Position(j, i));
            }
        }
        combination(0, 0);
        System.out.println(result);
    }

    public static void combination(int dep, int start) {
        if(dep == M) { //도착했을 때
            result = Math.min(result, getDistance());
            return;
        }

        for(int i=start; i<chickenList.size(); i++) {

            selected.add(chickenList.get(i));
            combination(dep+1, i+1);
            selected.remove(dep);
        }
    }

    public static int getDistance() {
        int distance = 0;
        for (Position house : houseList) { //집은 5개
            int sum = Integer.MAX_VALUE;

            for (Position chicken : selected) { //치킨 2개 선택
                int tmp = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                sum = Math.min(tmp , sum);
            }

            distance += sum;
        }
        return distance;
    }
}