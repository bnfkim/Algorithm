import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * X 주변에 . 이 3개이상 있을 시 . 로 변함
 * [주의] 지도에 없는 곳, 지도의 범위를 벗어나는 칸은 모두 바다이다.
 *
 * 1) 섬으로 잠기는 곳 위치 미리 체크
 * 2) for문 돌면서 잠기는 섬 . 로 바꾸기
 * 3) for문 돌면서 minX, maxX, minY, maxY 저장
 * 4) minX, maxX, minY, maxY 만큼만 출력
 */
class Node {
    int x;
    int y;
    Node (int y, int x){
        this.y = y;
        this.x = x;
    }
}
class Main{
    static int R, C;
    static String[][] arr;
    static ArrayList<Node> list;
    static int[] dx = {1, 0, -1 ,0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        //지도 입력받기
        arr = new String[R][C];
        for(int i=0; i<R; i++) arr[i] = br.readLine().split("");

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(arr[i][j].equals("X")) check(j, i);
            }
        }
        //잠기는 섬 바다로 바꾸기
        for(Node node : list) arr[node.y][node.x] = ".";
        
        //출력할 지도 범위 구하기
        int minX=Integer.MAX_VALUE, maxX=0, minY=Integer.MAX_VALUE, maxY=0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(arr[i][j].equals("X")){
                    minX = Math.min(minX, j);
                    maxX = Math.max(maxX, j);
                    minY = Math.min(minY, i);
                    maxY = Math.max(maxY, i);
                }
            }
        }
        //지도 출력하기
        for(int i=minY; i<=maxY; i++){
            for(int j=minX; j<=maxX; j++) sb.append(arr[i][j]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void check(int x, int y){
        int cnt = 0; //바다 면 체크
        for(int i=0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            //범위를 벗어나는 곳 -> 바다
            if(nextX<0 || nextX>=C || nextY<0 || nextY>=R) {
                cnt++;
                continue;
            }
            // . 인 곳 -> 바다
            if(arr[nextY][nextX].equals(".")) cnt++;
        }
        //3면이상 바다인 섬은 따로 저장
        if(cnt>=3) list.add(new Node(y, x));
    }
}