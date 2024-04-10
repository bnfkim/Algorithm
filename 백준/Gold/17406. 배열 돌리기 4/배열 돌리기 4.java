import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K, result = Integer.MAX_VALUE;
    static int[][] map, copyMap;
    static Command[] commands;
    static class Command {
        int r, c, s;

        public Command(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }

        @Override
        public String toString() {
            return "Command{" +
                "r=" + r +
                ", c=" + c +
                ", s=" + s +
                '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());       //세로
        M = Integer.parseInt(st.nextToken());       //가로
        K = Integer.parseInt(st.nextToken());       //회전 연산 개수

        map = new int[N + 1][M + 1];
        commands = new Command[K];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < K ; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            commands[i] = new Command(r, c, s);
        }
        permutation(0);
        System.out.println(result);
    }

    //순열 dfs 방법
    public static void permutation(int dep) {
        if(dep == K) {
            copyMap();
            for (Command command : commands) {
                int r = command.r;
                int c = command.c;
                int s = command.s;
                solve(r, c, s);
            }
            result = Math.min(result, getMinRowValue());
            return;
        }

        for(int i = dep; i < K; i++) {
            swap(i, dep);
            permutation(dep + 1);
            swap(i, dep);
        }
    }

    public static void solve(int r, int c, int s) {
        int startR = r - s;
        int endR = r + s;
        int startC = c - s;
        int endC = c + s;

        while(startR < endR && startC < endC) {
            rotate(startR, endR, startC, endC);
            startR++; startC++;
            endR--; endC--;
        }
    }

    public static void rotate(int startR, int endR, int startC, int endC) {
        int tmp = copyMap[startR][startC];

        //위로 이동 ⬆️
        for(int i = startR; i < endR; i++) copyMap[i][startC] = copyMap[i + 1][startC];

        //왼쪽 이동 ⬅
        for(int i = startC; i < endC; i++) copyMap[endR][i] = copyMap[endR][i + 1];

        //아래로 이동 ⬇️️
        for(int i = endR; i > startR; i--) copyMap[i][endC] = copyMap[i - 1][endC];

        //왼쪽 이동 ➡️
        for(int i = endC; i > startC + 1; i--) copyMap[startR][i] = copyMap[startR][i - 1];

        copyMap[startR][startC + 1] = tmp;
    }

    //각 행에 있는 모든 수의 합 중 최솟값을 구하는 메소드
    public static int getMinRowValue() {
        int rowMin = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++) {
            int tmp = 0;
            for(int j = 1; j <= M; j++) tmp += copyMap[i][j];
            rowMin = Math.min(tmp, rowMin);
        }
        return rowMin;
    }

    private static void copyMap() {
        copyMap = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++) {
            System.arraycopy(map[i], 0, copyMap[i], 0, M + 1);
        }
    }

    private static void swap(int a, int b) {
        Command tmp = commands[a];
        commands[a] = commands[b];
        commands[b] = tmp;
    }

    private static void print() {
        for(int i = 0; i <= N ; i ++) {
            for(int j = 0; j <= M; j++) {
                System.out.print(copyMap[i][j] + " ");
            }
            System.out.println();
        }
    }
}