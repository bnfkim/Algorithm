import java.io.*;
import java.util.*;

public class Solution {
    static int H, W, N;
    static int X, Y, D;
    static char[][] map;
    static char[] input;
    static int[] dx = {1, 0, -1, 0}; //0(동) 1(남) 2(서) 3(북)
    static int[] dy = {0, 1, 0, -1};
    static List<Character> carShape = Arrays.asList('>', 'v', '<', '^');

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H][W];
            for(int i=0; i<H; i++) {
                String str = br.readLine();
                for(int j=0; j<W; j++) {
                    map[i][j] = str.charAt(j);

                    if (carShape.contains(map[i][j])) {
                        switch (map[i][j]) {
                            case '>' : D = 0;
                            break;
                            case 'v' : D = 1;
                            break;
                            case '<' : D = 2;
                            break;
                            case '^' : D = 3;
                            break;
                        }
                        X = j;
                        Y = i;
                    }
                }
            }

            N = Integer.parseInt(br.readLine());
            input = br.readLine().toCharArray();

            solve();

            sb.append("#" + tc + " " + print());
        }
        System.out.println(sb);
    }

    static void solve() {
        //System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`");

        for (int i=0; i<N; i++) {
            char action = input[i];
            //System.out.println("==" + action + "==");

            if (action == 'S') {
                shoot(X, Y, D);
            } else {
                if (action == 'U') D = 3;
                else if (action == 'D') D = 1;
                else if (action == 'L') D = 2;
                else if (action == 'R') D = 0;

                map[Y][X] = carShape.get(D);
                int nx = X + dx[D];
                int ny = Y + dy[D];

                if(outOfRange(nx, ny)) continue;
                if(!canGo(nx, ny)) continue;

                map[ny][nx] = carShape.get(D);
                map[Y][X] = '.';
                X = nx;
                Y = ny;
            }
        }
    }

    static boolean outOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= W || y >= H;
    }

    static boolean canGo(int x, int y) {
        return map[y][x] == '.'; //평지
    }

    static void shoot(int x, int y, int d) {
        while (true) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(outOfRange(nx, ny)) return;

            if(map[ny][nx] == '#') return; //강철인 경우 못 부수고 포탄 사라짐
            if(map[ny][nx] == '*') { //벽돌로 만들어진 경우 평지로 만들고 포탄 사라짐
                map[ny][nx] = '.';
                return;
            }
            x = nx;
            y = ny;
        }
    }

    static String print() {
        StringBuilder tmp = new StringBuilder();
        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                tmp.append(map[i][j]);
            }
            tmp.append("\n");
        }
        return tmp.toString();
    }
}