import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //원소 갯수
        int n = Integer.parseInt(br.readLine());

        //기억해야할 수
        int num=0;

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){

            int item = Integer.parseInt(br.readLine());

            if (item > num) {
                for(int j=num; j<item; j++){
                    stack.push(j+1);
                    sb.append("+").append("\n");
                }
                num = item;
            } else if(stack.peek() != item) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }
}