import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static String FAIL_MESSAGE = "IMPOSSIBLE";
    static int  R, C, time;
    static char[][] map;
    static boolean[][] visit;
    static ArrayList<Pos> fireList;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Pos {
        int x; int y; int t;
        public Pos(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visit = new boolean[R][C];
        Pos start = null;
        fireList = new ArrayList<>();

        for(int i = 0; i < R; i++) {
            String input = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
                if(map[i][j] == 'J') start = new Pos(j, i, 0);
                if(map[i][j] == 'F') fireList.add(new Pos(j, i, 0));
            }
        }
        bfs(start);
        System.out.println(time == 0 ? FAIL_MESSAGE : time);
    }

    public static void bfs(Pos start) {
        ArrayDeque<Pos> person = new ArrayDeque<>();
        ArrayDeque<Pos> fire = new ArrayDeque<>(fireList);
        person.add(start);

        visit[start.y][start.x] = true;

        while (!person.isEmpty()) {
            int fireSize = fire.size();
            for(int i = 0; i < fireSize; i++) {
                Pos cur = fire.poll();

                for(int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    if(canEscape(nx, ny)) continue;

                    if(map[ny][nx] == '.') {
                        map[ny][nx] = 'F';
                        fire.add(new Pos(nx, ny, 0));
                    }
                }
            }
            int personSize = person.size();
            for(int i = 0; i < personSize; i++) {
                Pos cur = person.poll();

                for(int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];


                    if(canEscape(nx, ny)) {
                        time = cur.t + 1;
                        return;
                    }

                    if(!visit[ny][nx] && map[ny][nx] == '.') {
                        person.add(new Pos(nx, ny, cur.t + 1));
                        visit[ny][nx] = true;
                    }
                }
            }
        }
    }

    public static boolean canEscape(int x, int y) {
        return x < 0 || y < 0 || x >= C || y >= R;
    }

    public static void print(){
        System.out.println("===");
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}