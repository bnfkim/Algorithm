import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class V {
    int x;
    int y;
    V (int y, int x){
        this.y = y;
        this.x = x;
    }
}
class Main{
    /**
     * 4:52 -
     */
    static int N, M; //세로, 가로
    static int maxSafeZone = 0; //결과값
    static int[][] arr; //연구소를 받기 위한 배열
    static ArrayList<V> virus; //바이러스 위치를 저장하는 리스트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0 (빈칸) 1(벽) 2(바이러스)
        // 2<=바이러스 개수<= 10
        // 벽 3개 -> 안전 영역 크기 최댓값 구하기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로
        arr = new int[N][M];
        virus = new ArrayList<>();
        //입력받기
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int item = Integer.parseInt(st.nextToken());
                arr[i][j] = item;
                if (item == 2) virus.add(new V(i, j));
            }
        }
        makeWalls(0);
        System.out.println(maxSafeZone);
    }
    //벽 3개 설치하는 작업
    public static void makeWalls(int cnt){
        //벽이 3개 설치된 경우 bfs 탐색 시작
        if(cnt == 3) {
            bfs();
            return;
        }
        //벽 3개 고르기
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 0) {
                    arr[i][j] = 1; //벽 세우기
                    makeWalls(cnt+1);
                    arr[i][j] = 0; //다시 복구
                }
            }
        }
    }
    //감염시키고, 안전 지역이 몇개 인지 알려주는 함수
    public static void bfs() {
        //세이프 존으로만 갈 수 있음
        Queue<V> queue = new LinkedList<>();
        for(V v : virus) queue.offer(v);

        //원본 연구소를 바꾸지 않기 위한 카피맵 사용
        int copyZone[][] = new int[N][M];
        for (int i = 0; i < N; i++) copyZone[i] = arr[i].clone();

        //바이러스 감염시키기
        while (!queue.isEmpty()) {
            V v = queue.poll();
            int nowX = v.x;
            int nowY = v.y;

            //상
            if(nowY>0 && copyZone[nowY-1][nowX] == 0){
                copyZone[nowY-1][nowX] = 2;
                queue.offer(new V(nowY-1, nowX));
            }
            //하
            if(nowY<N-1 && copyZone[nowY+1][nowX] == 0){
                copyZone[nowY+1][nowX] = 2;
                queue.offer(new V(nowY+1, nowX));
            }
            //좌
            if(nowX>0 && copyZone[nowY][nowX-1] == 0){
                copyZone[nowY][nowX-1] = 2;
                queue.offer(new V(nowY, nowX-1));
            }
            //우
            if(nowX<M-1 && copyZone[nowY][nowX+1] == 0){
                copyZone[nowY][nowX+1] = 2;
                queue.offer(new V(nowY, nowX+1));
            }
        }

        //세이프존 수 세기
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copyZone[i][j] == 0) cnt++;
            }
        }
        //System.out.println("세이프 존 갯수는 : " + cnt);
        maxSafeZone = Math.max(maxSafeZone, cnt);
    }
}