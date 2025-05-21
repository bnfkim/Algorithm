import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        String color1 = sc.next();
        String color2 = sc.next();
        String color3 = sc.next();
                
        int number1 = change(color1);
        int number2 = change(color2);
        int number3 = (int)Math.pow(10, change(color3));
        
        long result = (long)(number1 * 10 + number2) * number3;
        
        System.out.println(result);
        
    }
    public static int change(String color) {
        String[] colors = new String[]{"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        
        for (int i=0; i<10; i++) {
            if(colors[i].equals(color)) {
                return i;
            }
        }
        return 0;
    }
}
