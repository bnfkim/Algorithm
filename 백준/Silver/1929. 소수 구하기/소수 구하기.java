import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[1_000_001];

        //에라토스테네스의 체

        //(1) 배열 초기화
        for(int i=2; i<arr.length; i++) {
            arr[i] = i;
        }

        //(2) 2부터 시작해서 특정 수의 배수에 해당하는 수는 모두 지움
        for(int i=2; i<arr.length; i++) {
            if(arr[i] == 0) continue; //이미 지워진 수라면 패스

            for(int j=i*2; j<arr.length; j+=i) {
                arr[j] = 0; //소수가 아닌 수는 0 으로 지움
            }
        }

        for(int i=M; i<=N; i++) {
            //0이 아닌 수 = 소수인 수
            if(arr[i]!=0) System.out.println(arr[i]);
        }
    }
}