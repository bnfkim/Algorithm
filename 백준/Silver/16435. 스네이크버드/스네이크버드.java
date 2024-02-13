import java.util.*;
import java.io.*;

public class Main {

    static int N, L; //과일의 개수, 초기 길이
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();

        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for(int a : arr) {
            if(L < a) break;
            L++;
        }

        System.out.println(L);
    }
}