import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int min = sc.nextInt();
        int time = sc.nextInt();

        int add_min = (min + time) % 60;
        int add_hour = (min + time) / 60;

        if (min + time < 60) {
            System.out.println(hour + " " + (min + time));
        } else {
            if (hour + add_hour >= 24) {
                hour = (hour + add_hour) - 24;
                System.out.println(hour + " " + add_min);
            } else {
                hour = hour + add_hour;
                System.out.println(hour + " " + add_min);
            }
        }
    }
}