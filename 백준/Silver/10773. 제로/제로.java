import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        while(k-->0){
            int item = sc.nextInt();
            if(!stack.isEmpty() && item == 0) {
                int popItem = stack.pop();
                sum -= popItem;
            }
            else {
                stack.push(item);
                sum += item;
            }
        }
        System.out.println(sum);
    }
}