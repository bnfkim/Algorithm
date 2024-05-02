import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        long sum = 0;
        for(int i = 0; i < 3; i++) {
            sum += input.nextLong();
        }
        System.out.println(sum);
    }
}