import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //(1 ≤ N ≤ 26)
        Double[] arr = new Double[N];
        String input = sc.next();
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextDouble();
        }

        Stack<Double> stack = new Stack<>();
        for(int i=0; i<input.length(); i++) {
            char ch = input.charAt(i);

            if(ch >= 65 && ch <= 90) {
                int idx = ch - 65;
                stack.push(arr[idx]);
            } else {
                double b = stack.pop();
                double a = stack.pop();

                if(ch == '+') {
                    stack.push(a+b);
                }
                else if(ch == '-') {
                    stack.push(a-b);
                }
                else if(ch == '*') {
                    stack.push(a*b);
                }
                else if(ch == '/') {
                    stack.push(a/b);
                }
            }
        }
        System.out.printf("%.2f%n", stack.pop());
    }
}