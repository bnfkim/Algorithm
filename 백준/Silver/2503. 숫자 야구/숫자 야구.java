import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main{
    /**
     * 11:30 -
     */
    static int N;
    static String[] nums;
    static int[] strike, ball;
    public static void main(String[] args) throws IOException {
        /**
         * 해결방법
         * 서로다른 세자리수를 모두 질문 조건으로 체크하는 방법
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new String[N];
        strike = new int[N];
        ball = new int[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums[i] = st.nextToken();
            strike[i] = Integer.parseInt(st.nextToken());
            ball[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        for(int i=1; i<10; i++){
            for(int j=1; j<10; j++){
                if(i==j) continue;
                for(int k=1; k<10; k++){
                    if(i==k || j==k) continue;

                    StringBuilder sb = new StringBuilder().append(i).append(j).append(k);
                    if(check(sb.toString())) result++;
                }
            }
        }
        System.out.println(result);
    }
    private static boolean check(String str) {
        for(int i=0; i<N; i++){
            int cntS = 0;
            int cntB = 0;

            String n = nums[i];
            int s = strike[i];
            int b = ball[i];
            //스트라이크 체크
            for(int j=0; j<3; j++) if(str.charAt(j) == n.charAt(j)) cntS++;
            if (cntS != s) return false;

            //볼 체크
            for(int j=0; j<3; j++){
                if(str.contains(String.valueOf(n.charAt(j))) && str.charAt(j) != n.charAt(j)) cntB++;
            }
            if (cntB != b) return false;
        }
        return true;
    }
}