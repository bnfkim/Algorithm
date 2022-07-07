import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static void hanoi(int n, int start, int mid, int end){
        if (n==1){
            sb.append(start + " " + end + "\n");
            return;
        }
        hanoi(n-1, start, end, mid);
        sb.append(start + " " + end + "\n");
        hanoi(n-1, mid, start, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        //이동횟수
        int move = (int)Math.pow(2, num) - 1;
        System.out.println(move);
        hanoi(num, 1, 2,3);
        System.out.println(sb);
    }
}