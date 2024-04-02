import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc<=T; tc++) {
            int N = sc.nextInt();
            if(N < 3) System.out.println(1);
            else {
                long[] arr = new long[N + 1];
                arr[1] = 1;
                arr[2] = 1;
                for(int i = 3; i <= N; i++) {
                    arr[i] = arr[i-2] + arr[i-3];
                }
                System.out.println(arr[N]);
            }
        }
    }
}