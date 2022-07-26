import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] counting = new int[20000001]; // 입력받는 수의 범위 : -10,000,000 ~ 10,000,000

        //상근이 숫자카드
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            counting[Integer.parseInt(st.nextToken()) + 10000000]++; //해당 인덱스의 값 증가
        }

        //확인용 숫자카드
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            sb.append(counting[Integer.parseInt(st.nextToken()) + 10000000]).append(' ');
        }

        System.out.println(sb);
    }
}