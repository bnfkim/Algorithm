import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    static int[] dp = new int[11];
    public static void main(String[] args) throws IOException {

        /**
         *  입력)
         *  첫째 줄 -> N의 진짜 약수의 개수 (N<=50)
         *  둘째 줄 -> N의 진짜 약수
         *  출력) 첫째 줄에 N을 출력
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //배열 정렬하기
        Arrays.sort(arr);

        int result = 0;

        if(N%2 == 0) {
            result = arr[0] * arr[N-1];
        } else {
            result = (int)Math.pow(arr[N/2], 2);
        }

        System.out.println(result);
    }
}