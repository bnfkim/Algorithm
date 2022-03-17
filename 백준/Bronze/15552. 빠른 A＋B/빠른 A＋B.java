import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // readLine의 경우 try/catch가 필요
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // String이 리던값이라 int로 형변환
        int num = Integer.parseInt(br.readLine());
        // read한 데이터는 Line 단위로만 나눠지기에 공백단위로 데이터 가공을 하기 위한 작업 필요
        // StringTokenizer에 nextToken()함수를 쓰면 readLine()을 통해 입력받은 값을 공백단위로 구분
        StringTokenizer st;
        
        for (int i=0; i<num; i++){
            st = new StringTokenizer(br.readLine());
            bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) )
            + "\n");
        }
        br.close();
        bw.flush(); //남아있는 데이터 모두 출력
        bw.close();
    }
}