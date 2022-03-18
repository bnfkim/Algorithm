import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //테스트케이스 수 입력받기
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            //문자열 쪼개주는 class
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            bw.write("Case #" + (i+1) + ": " + A + " + " + B + " = " + (A+B) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();

    }
}