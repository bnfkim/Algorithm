import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N, M, K, result;
    static ArrayList<Microbe>[][] map;
    static ArrayList<Microbe> microbeList;
    static int[] dc = {0, 0, 0, -1, 1};
    static int[] dr = {0, -1, 1, 0, 0};

    static class Microbe {
        int r, c, n, d;

        public Microbe(int r, int c, int n, int d) {
            this.r = r;
            this.c = c;
            this.n = n;
            this.d = d;
        }

        @Override
        public boolean equals(Object object) {
            if(object instanceof Microbe) {
                return this.r == ((Microbe)object).r && this.c == ((Microbe)object).c;
            }
            return false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   //셀의 개수 (5 ≤ N ≤ 100)
            M = Integer.parseInt(st.nextToken());   //격리 시간 (1 ≤ M ≤ 1,000)
            K = Integer.parseInt(st.nextToken());   //미생물 군집  (5 ≤ K ≤ 1,000)

            //각 군집의 정보는 세로 위치, 가로 위치, 미생물 수, 이동 방향 순
            //각 위치는 0번부터 시작
            map = new ArrayList[N][N];
            microbeList = new ArrayList<>();
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    map[i][j] = new ArrayList<>();
                }
            }

            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                Microbe microbe = new Microbe(r, c, n, d);
                map[r][c].add(microbe);
                microbeList.add(microbe);
            }

            solve();

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    static void print(){

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solve() {
        //M 시간 후 남아있는 미생물 수의 총 합
        for(int t = 1; t<=M; t++) {
            //(1) 이동
            move();

            //(2) 약품 칠해진 곳 만났는지 확인
            checkDieZone();

            //(3) 겹치는 위치에 만났는지 확인
            checkMeetZone();
        }
        result = getRemainMicrobe();
    }
    public static void move() {

        Iterator<Microbe> iterator = microbeList.iterator();
        while(iterator.hasNext()){
            Microbe microbe = iterator.next();
            map[microbe.r][microbe.c].remove(microbe);
            microbe.r += dr[microbe.d];
            microbe.c += dc[microbe.d];
            map[microbe.r][microbe.c].add(microbe);
        }

//        for(Microbe microbe : microbeList) {
//            //1시간마다 이동방향에 있는 다음 셀로 이동
//            map[microbe.r][microbe.c].remove(microbe);
//            microbe.r += dr[microbe.d];
//            microbe.c += dc[microbe.d];
//            map[microbe.r][microbe.c].add(microbe);
//        }
    }

    public static void checkDieZone() {
        Iterator<Microbe> iterator = microbeList.iterator();
        while(iterator.hasNext()){
            Microbe microbe = iterator.next();
            if(inDieZone(microbe.r, microbe.c)) {
                microbe.n /= 2; //(1-1) 미생물의 절반이 죽음
                microbe.d = changeDirection(microbe.d); //(1-2) 이동 방향 바뀜
                if(microbe.n == 0) iterator.remove(); //(1-3) 미생물 수 =  0 -> 군집 사라짐
            }
        }

//        for (Microbe microbe : microbeList) {
//            if(inDieZone(microbe.r, microbe.c)) {
//                microbe.n /= 2; //(1-1) 미생물의 절반이 죽음
//                microbe.d = changeDirection(microbe.d); //(1-2) 이동 방향 바뀜
//
//                if(microbe.n == 0) microbeList.remove(microbe); //(1-3) 미생물 수 =  0 -> 군집 사라짐
//            }
//        }
    }

    private static void checkMeetZone() {
        for(int i=1; i<N-1; i++) {
            for(int j=1; j<N-1; j++) {
                if(map[i][j].size() <= 1) continue;

                //(2) 두 개 이상의 군집이 한 셀에 모이는 경우
                int sumN = 0;
                int maxN = 0;
                int maxD = 0;

                for(Microbe microbe : map[i][j]) {
                    //(2-1) 군집들이 합쳐짐
                    sumN += microbe.n;

                    if(microbe.n > maxN) {
                        maxN = microbe.n;
                        maxD = microbe.d; //(2-2) 군집 이동방향 = 미생물 수가 가장 많은 군집의 이동방향
                    }
                }
                Microbe newMicrobe = new Microbe(i, j, sumN, maxD);
                map[i][j].clear();
                map[i][j].add(newMicrobe);

                microbeList.removeIf(microbe -> microbe.equals(newMicrobe));
                microbeList.add(newMicrobe);
            }
        }
    }
    private static boolean inDieZone(int r, int c) {
        return r == 0 || c == 0 || r == (N-1) || c == (N-1);
    }
    private static int changeDirection(int d) {
        //(상: 1, 하: 2, 좌: 3, 우: 4)
        if(d == 1) return 2;
        if(d == 2) return 1;
        if(d == 3) return 4;
        if(d == 4) return 3;
        return d;
    }

    public static int getRemainMicrobe() {
        int sum = 0;
        for(Microbe microbe : microbeList) {
            sum += microbe.n;
        }
        return sum;
    }
}