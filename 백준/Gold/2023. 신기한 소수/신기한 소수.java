import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] data;
    static int[] canAddNum = {1, 3, 7, 9};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N];

        permutation(0,0);
    }
    public static void permutation(int dep, int num) {
        //System.out.println("dep = " + dep + ", num = " + num);
        if(dep != 0 && !isPrimeNumber(num)) return;

        if(dep == N) { //4자리 수까지 왔을 때
            System.out.println(num);
            return;
        }

        //맨 처음 들어왔을 때 먼저 판별
        if(dep == 0) {
            //2,3,5,7
            permutation(dep+1, 2);
            permutation(dep+1, 3);
            permutation(dep+1, 5);
            permutation(dep+1, 7);
        } else {
            for(int n : canAddNum) {
                permutation(dep+1, num*10 + n);
            }
        }
    }

    //약수인지 판단하는 함수
    public static boolean isPrimeNumber(int num) {
        if(num <= 1) return false;

        int tmp = (int) Math.sqrt(num);
        for(int i=2; i<=tmp; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}