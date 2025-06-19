import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] durability;
    static boolean[] robot;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        durability = new int[2 * N];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i  < N * 2; i++) {
            durability[i] = Integer.parseInt(st.nextToken());
        }

        int step = 0;
        while (true) {
            step++;

            rotateBelt();
            moveRobot();
            putRobot();

            if(isZeroDurability()) break;
        }
        System.out.println(step);
    }

    //(1)컨베이어벨트 이동
    private static void rotateBelt() {
        //컨베이어 벨트 이동
        int last = durability[2 * N - 1];
        for(int i = 2 * N - 1; i > 0; i--){
            durability[i] = durability[i - 1];
        }
        durability[0] = last;

        //로봇도 이동
        for(int i = N - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false; //로봇 올라갈 자리 마련
        robot[N - 1] = false; //마지막 칸일 때는 로봇 내리기
    }
    //(2) 로봇 움직이기
    private static void moveRobot() {
        for (int i = N - 1; i > 0; i--) {
            if (durability[i] > 0 //내구도가 0이 아니어야 하고
            && !robot[i] //다음 이동 자리에 로봇이 없어야 하고
            && robot[i - 1] //현재 자리에 로봇이 있어야 함
            ) {
                robot[i] = true; //로봇 다음 자리에 이동시키고
                robot[i - 1] = false; //이전자리는 리셋
                durability[i]--; //내구도 감소
            }
        }
    }

    //(3) 로봇 올려놓기
    private static void putRobot() {
        if(durability[0] > 0) {
            robot[0] = true;
            durability[0]--;
        }
    }

    public static boolean isZeroDurability() {
        int cnt = 0;
        for (int i = 0; i < 2 * N; i++) {
            if(durability[i] == 0) cnt++;

            if(cnt == K) return true;
        }
        return false;
    }
}