import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Pos implements Comparable<Pos>{
        int r, c, d;
        public Pos(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }

        @Override
        public int compareTo(Pos o) {
            return this.d - o.d;
        }

        @Override
        public String toString() {
            return "Pos{" + "r=" + r + ", c=" + c + ", d=" + d + '}';
        }
    }

    static int N, answer, personNum; //한 방의 변의 길이
    static int[][] map;
    static boolean[] isStair1;
    static ArrayList<Pos> waitingStair1;
    static ArrayList<Pos> waitingStair2;
    static ArrayList<Pos> personPos;
    static Pos stair1, stair2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            personPos = new ArrayList<>();
            stair1 = null; stair2 = null;

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if(map[i][j] == 1) personPos.add(new Pos(i, j, 0));
                    if(map[i][j] >= 2) {
                        if (stair1 == null) stair1 = new Pos(i, j, map[i][j]);
                        else stair2 = new Pos(i, j, map[i][j]);
                    }
                }
            }
            answer = Integer.MAX_VALUE;
            solve();
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    public static void solve() {
        //(1) 계단 2개 별로 사람 세우기
        personNum = personPos.size();
        isStair1 = new boolean[personNum];
        subset(0);
    }

    public static void subset(int cnt) {
        if(cnt == personNum) {
            makeWaitingQueue();
            return;
        }
        isStair1[cnt] = true;
        subset(cnt+1);

        isStair1[cnt] = false;
        subset(cnt+1);
    }

    public static void makeWaitingQueue() {
        waitingStair1 = new ArrayList<>();
        waitingStair2 = new ArrayList<>();

        for(int i=0; i<personNum; i++) {
            Pos p = personPos.get(i);

            //(2) 계단까지 이동 시간 구하기
            //계단 입구에 도착하면, 1분 후 아래칸으로 내려 갈 수 있다.
            if(isStair1[i]) {
                p.d = getMoveTime(p, stair1) + 1; //이동 시간 + 1분 후 시간까지 포함
                waitingStair1.add(p);
            } else {
                p.d = getMoveTime(p, stair2) + 1;
                waitingStair2.add(p);
            }
        }

        Collections.sort(waitingStair1);
        Collections.sort(waitingStair2);

        downStair();
    }

    public static void downStair() {
        //계단1 계산
        for(int i = 0; i < waitingStair1.size(); i++) {
            if(i < 3) {
                waitingStair1.get(i).d += stair1.d;
            } else {
                if (waitingStair1.get(i - 3).d > waitingStair1.get(i).d) {
                    waitingStair1.get(i).d = waitingStair1.get(i - 3).d + stair1.d;
                } else {
                    waitingStair1.get(i).d += stair1.d;
                }
            }
        }

        //계단2 계산
        for(int i = 0; i < waitingStair2.size(); i++) {
            if(i < 3) {
                waitingStair2.get(i).d += stair2.d;
            } else {
                if (waitingStair2.get(i - 3).d > waitingStair2.get(i).d) {
                    waitingStair2.get(i).d = waitingStair2.get(i - 3).d + stair2.d;
                } else {
                    waitingStair2.get(i).d += stair2.d;
                }
            }
        }
        answer = Math.min(answer, getDownTime());
    }

    public static int getDownTime() {
        //계단1과 계단2를 모두 내려간 것 중에 더 큰 것을 구함
        int stair1Time = 0;
        int stair2Time = 0;
        if(!waitingStair1.isEmpty()) stair1Time = waitingStair1.get(waitingStair1.size()-1).d;
        if(!waitingStair2.isEmpty()) stair2Time = waitingStair2.get(waitingStair2.size()-1).d;
        return Math.max(stair1Time, stair2Time);
    }

    public static int getMoveTime(Pos person, Pos stair) {
        return Math.abs(person.r - stair.r) + Math.abs(person.c - stair.c);
    }
}