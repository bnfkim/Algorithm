import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[9];

        for(int i =0; i<9; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }

        int max = 0;
        int count = 0;

        for(int i = 0; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                count = i+1;
            }
        }
        System.out.println(max);
        System.out.println(count);
    }
}