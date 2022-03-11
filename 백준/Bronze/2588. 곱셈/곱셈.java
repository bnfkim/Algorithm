import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int A, B;
        A = sc.nextInt();
        B = sc.nextInt();

        int C = A*B;

        ArrayList<Integer> arrNum = new ArrayList<>();
        while(B > 0) {
            arrNum.add(B %10);
            B /= 10;
        }

        System.out.println(A * arrNum.get(0));
        System.out.println(A * arrNum.get(1));
        System.out.println(A * arrNum.get(2));
        System.out.println(C);
    }
}