import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        int cnt = 1;
        int answer = 1;
        int now = arr[0];

        for (int idx=1; idx<N; idx++) {
            int next = arr[idx];

            if(now > next) { //감소할 경우
                cnt++;
            } else  {
                answer = Math.max(cnt, answer);
                cnt = 1;
                now = next;
            }
        }

        System.out.println(Math.max(cnt, answer));
    }
}