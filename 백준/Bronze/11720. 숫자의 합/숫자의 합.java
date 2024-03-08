import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] num = sc.next().split("");

        int sum = 0;
        for(int i=0; i<N; i++) {
            sum += Integer.parseInt(num[i]);
        }

        System.out.println(sum);
    }
}