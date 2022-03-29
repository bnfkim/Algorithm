import java.io.*;
import java.util.ArrayList;

public class Main {
    // self num을 구하는 함수
    public static int d(int num){
        int sum = num;
        while (num>0){
            sum += num %10;
            num = num/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        boolean[] arr = new boolean[10001];
        for (int i=1; i<10001; i++){
            int self_num = d(i);
            if(self_num<10001){
                //self num인 숫자는 true로 변경
                arr[self_num] = true;
            }
        }
        for(int i=1; i<10001; i++){
            // self num이 아닌 숫자는 false로 되어있음
            // false로 되어있는 숫자만 출력
            if(!arr[i]) {
                System.out.println(i);
            }
        }
    }
}