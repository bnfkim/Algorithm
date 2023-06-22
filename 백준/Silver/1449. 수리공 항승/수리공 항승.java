import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        /**
         * 1:10 -
         *
         * 3 2
         * 1 5 7
         *
         * 9 3
         * 1 2 3 4 5 6 7 8 9 10 14 20
         *
         * 123 456 789 10 14 20
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
        int cnt = 0;
        while(idx < N) {
            //시작 파이프에서 테이프로 수리가능한 파이프 위치
            int len = arr[idx] + L - 1;
            for(int i=idx; i<N; i++) {
                if(arr[i] > len) { //10 > 12
                    idx = i;
                    cnt++;
                    break;
                }else if(arr[i] == len){
                     cnt++;
                     idx = i+1;
                     break;
                }else {
                    idx++;
                }
            }
            if(idx == N) {
                if(arr[idx-1] != len) cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}