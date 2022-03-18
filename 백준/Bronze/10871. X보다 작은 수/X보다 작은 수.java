import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 한 줄에 데이터 2개 값을 받기 위해 한 줄을 StringTokenizer로 받아 Integer로 나누어 변수 선언 해주어야함
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Integer> al = new ArrayList<Integer>();
        // 리스트에 추가할 원소를 읽을 st를 새로 할당
        st = new StringTokenizer(br.readLine());

        // 입력받은 N 수만큼 입력받아 리스트에 추가
        for(int i=0; i<N; i++){
            al.add(Integer.parseInt(st.nextToken()));
        }
        // 입력받은 X 보다 작은 숫자만 출력
        for(int i=0; i<N; i++){
            if (al.get(i) < X){
                bw.write(al.get(i) + " ");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}