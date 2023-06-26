import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        /**
         * 11:26 - 12:01
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //칸의 개수
        int m = Integer.parseInt(st.nextToken()); //바구니크기
        int j = Integer.parseInt(br.readLine()); //떨어지는 사과 개수

        int left = 1;
        int right = left + (m-1);
        int move = 0;
        for(int i=0; i<j; i++) {
            int pos = Integer.parseInt(br.readLine());
            if(pos>right) { //바구니 위치보다 오른쪽에 떨어질 때
                move += pos - right;
                right = pos;
                left = pos - (m-1);
            } else if (pos<left) { //바구니 위치보다 왼쪽에 떨어질때
                move += left - pos;
                left = pos;
                right = pos + (m-1);
            }
        }
        System.out.println(move);
    }
}