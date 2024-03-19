import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        if(input.isEmpty()) System.out.println(0);
        else System.out.println(input.split(" ").length);
    }
}