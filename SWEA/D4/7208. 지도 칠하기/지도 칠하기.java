import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int N, result;
    static int[] origin, update;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            //초기화
            N = Integer.parseInt(br.readLine());
            origin = new int[N];
            update = new int[N];
            map = new int[N][N];
            result = Integer.MAX_VALUE;

            //색상 입력받기
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                origin[i] = Integer.parseInt(st.nextToken());
            }

            //인접 국가 입력 받기
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            permutation(0);
            sb.append("#" + tc + " " + result + "\n");
        }
        System.out.println(sb.toString());
    }
    static void permutation(int dep) {
        if(dep == N){ // 색의 조합을 모두 뽑았을 때
            
            int cnt = 0;
            //모든 인접 국가끼리 색이 안 겹치는지 확인
            for(int i=0; i<N; i++) {
                if(!check(i)) return; //색이 겹치면 -> 해당 색 조합은 안 되는 조합이므로 조합 다시 해 !
                if(origin[i] != update[i]) cnt++; //색이 안 겹치면 -> 원본 색이랑 변화가 있는지 아닌지 확인
            }
            result = Math.min(cnt, result);
            return;
        }

        for(int color=1; color<=4; color++) {
            update[dep] = color;
            permutation(dep+1);
        }
    }

    //순열로 만든 색 조합이 서로 안 겹치는 색상 조합인지 체크하는 메서드
    static boolean check(int idx) {
        for(int i=idx+1; i<N; i++) {
            //인접 국가랑 색이 같으면
            if(map[idx][i] == 1 && update[i] == update[idx]) {
                return false;
            }
        }
        return true;
    }
}