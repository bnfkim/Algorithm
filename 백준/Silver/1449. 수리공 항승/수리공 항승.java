import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        /**
         * 1:10 - 1:50
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //물이 새는 곳 개수
        int L = Integer.parseInt(st.nextToken()); //테이플 길이

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int idx = 0;
        int cnt  = 1; //필요한 테이프 최소 개수
        for(int i=idx+1; i<N; i++){
            //한 테이프로 붙일 수 있는 범위를 넘어가면 업데이트
            if(arr[idx] + L - 1 < arr[i]) {
                cnt++;
                idx = i;
            }
        }
        System.out.println(cnt);
    }
}