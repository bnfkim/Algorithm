import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static final int ARCHER_NUM = 3;
    static int R, C, D, RES = 0;
    static int[][] map;
    static int[][] copyMap;
    static int[] pos;
    static int[] dy = {0, -1, 0};
    static int[] dx = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); //행의 수
        C = Integer.parseInt(st.nextToken()); //열의 수
        D = Integer.parseInt(st.nextToken());

        map = new int[R+1][C];
        pos = new int[ARCHER_NUM];

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combination(0, 0);
        System.out.println(RES);
    }

    //TODO: 궁수의 위치를 선택하는 모든 경우의 수 구하기
    static void combination(int dep, int start) {
        if(dep == ARCHER_NUM) {
            start();
            return;
        }

        for(int i = start; i<C; i++) {
            pos[dep] = i;
            combination(dep+1, i+1);
        }
    }
    //TODO: 이동시키기 및 적 죽이기 진행
    static void start() {
        copyMap = copyOriginal();
        int kill = 0;

        for(int lv = 0; lv <= R; lv++) { //위 칸으로 궁수 이동
            ArrayList<Point> shootPoint = new ArrayList<>();

            for (int i=0; i<ARCHER_NUM; i++) {
                Point point = getShootPoint(i, lv);
                if(point != null) shootPoint.add(point);
            }

            //저장된 위치 쏘기
            for(Point point : shootPoint) {
                if(copyMap[point.y][point.x] == 0) continue; //이미 다른 궁수가 쏜 경우

                copyMap[point.y][point.x] = 0; //죽임
                kill++;
            }
        }
        RES = Math.max(kill, RES);
    }

    static int[][] copyOriginal() {
        int[][] arr = new int[R+1][C];
        for(int i=0; i<=R; i++) {
            arr[i] = map[i].clone();
        }
        return arr;
    }


    //TODO : 해당 적이 죽일 수 있는 최적의 위치 구해서 반환
    static Point getShootPoint(int idx, int lv) {
        Deque<Point> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[R+1][C];

        int x = pos[idx];
        int y = R - lv;
        visit[y][x] = true;
        queue.add(new Point(x, y));

        int dep = 0;
        while (!queue.isEmpty()) {
            if(dep > D) break;

            int size = queue.size();
            for(int k=0; k<size; k++) {
                Point point = queue.poll();

                //가장 우선순위 높게 만난 경우
                if(copyMap[point.y][point.x] == 1) {
                    return point;
                }

                for(int i=0; i<3; i++) {
                    int nx = point.x + dx[i];
                    int ny = point.y + dy[i];

                    if(ny == y) continue;
                    if(outOfRange(nx, ny) || visit[ny][nx]) continue;

                    queue.add(new Point(nx, ny));
                    visit[ny][nx] = true;
                }
            }
            dep++;
        }
        return null; //사정거리 내에 죽일 적이 없는 경우
    }

    static boolean outOfRange(int x, int y) {
        return x<0 || y<0 || x>=C || y>=R;
    }
}