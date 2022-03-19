import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int num = N;
        int temp = 0;
        int count = 0;
        br.close();

        do {// 1.개별 자릿수 구해서 더하기
            temp = num/10 + num%10;
            // 2. 새로운 숫자 만들기
            num = (num%10)*10 + temp%10;
            count++;
        } while (N != num);

        bw.write( count + "\n" );
        bw.flush();
        bw.close();
    }
}