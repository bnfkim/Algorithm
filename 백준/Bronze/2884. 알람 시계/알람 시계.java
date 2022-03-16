import java.util.*;
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int min = sc.nextInt();
        
        if ((hour>=0 && hour<=23) && (min>=0 && min<=59)){
            if (min < 45) {
                if (hour == 0) {
                    hour = 23;
                    System.out.println(hour + " " + (min+15));
                } else {
                    System.out.println((hour-1) + " " + (min+15));
                }
            } else {
                System.out.println(hour + " " + (min-45));
            }
        } else {
            System.exit(0);
        }
    }
}