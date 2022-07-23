import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();

        //입력값 받기
        int N = Integer.parseInt(br.readLine());

        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        //정렬하기
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int result = 0;
        for(int i=0; i<N; i++){
            int sum = A[i] * B[i];
            result += sum;
        }
        System.out.println(result);
    }
}