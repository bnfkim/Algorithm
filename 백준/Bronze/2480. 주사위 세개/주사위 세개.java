import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int di1 = sc.nextInt();
        int di2 = sc.nextInt();
        int di3 = sc.nextInt();
        int mon = 0;

        // 다 같은 경우
        if (di1 == di2 && di1 == di3 && di2 == di3){
            mon = 10000 + di1 * 1000;
            System.out.println(mon);
        }
        // 다 다른경우
        else if (di1 != di2 && di1 != di3 && di2 != di3) {
            int mx_di = 0;
            if (di1 > di2) {
                if(di1 > di3) {
                    mx_di = di1;
                } else {
                    mx_di = di3;
                }
            } else if (di2 > di1){
                if (di2 > di3){
                  mx_di = di2;
                } else {
                    mx_di = di3;
                }
            }
            mon = mx_di * 100;
            System.out.println(mon);
        } // 두 개가 겹치는 경우
        else {
            if (di1 == di2 || di1 ==di3){
                mon = 1000 + di1 * 100;
                System.out.println(mon);
            } else if (di2 == di3) {
                mon = 1000 + di2 * 100;
                System.out.println(mon);
            }
        }
    }
}