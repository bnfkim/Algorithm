import java.io.IOException;
import java.util.Scanner;

class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;

        //봉지는 3킬로그램과 5킬로만 있음
        while(true){
            if(n%5 == 0) {
                System.out.println(n / 5 + cnt);
                break;
            }
            if(n<0){
                System.out.println(-1);
                break;
            }
            n -= 3;
            cnt++;
        }
    }
}