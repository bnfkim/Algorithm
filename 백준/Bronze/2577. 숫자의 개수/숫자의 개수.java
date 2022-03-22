import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int N = A*B*C;
        ArrayList<Integer> arr = new ArrayList<>();

        // arr 배열에 0으로 초기화 하기
        for(int i=0; i<10; i++){
            arr.add(0);
        }

        while ( N > 0 ) {
            // 한자리씩 빼서 해당 숫자를 배열 인덱스 값으로
            int index = N%10;
            N /= 10;
            // 값 +1 추가해주기
            arr.set(index, arr.get(index)+1);
        }
        for(int i=0; i<10; i++){
            bw.write(arr.get(i) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}