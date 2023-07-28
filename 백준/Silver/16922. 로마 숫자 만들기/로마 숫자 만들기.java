import java.io.*;
import java.util.*;

class Main{
    /**
     *  1. 각 배열 요소를 저장한 뒤 조건이 충족되면 계산
     *  2. dfs를 진행하면서 동시에 덧셈 진행
     */
    static int N;
    static int[] nums = {1, 5, 10, 50};
    static boolean[] visit; //방문한 숫자 배열 (중복방지 하는 용)
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // (1 ≤ N ≤ 20)
        visit = new boolean[1001]; //50을 20번 더하면 1000이므로

        //중복가능, 대신 순서는 상관없음
        dfs(N, 0, 0);
        System.out.println(cnt);
    }

    /**
     * @param len : 남아있는 문자
     * @param idx : 1, 5, 10, 50 배열에 접근하는 인덱스
     * @param sum : 지금까지 더한 값
     */
    public static void dfs(int len, int idx, int sum) {
        if(len == 0){ //모든 문자를 다 조합했을 경우
            if(!visit[sum]){ //한번도 나온 적 없는 숫자의 경우
                cnt++; //다른 문자 갯수 카운드 변수 증가
                visit[sum] = true; //중복제거를 위해 체크
            }
            return;
        }
        for(int i=idx; i<4; i++){ //4개의 숫자 중 하나를 선택하여 더함
            dfs(len-1, i, sum + nums[i]);
        }
    }
}