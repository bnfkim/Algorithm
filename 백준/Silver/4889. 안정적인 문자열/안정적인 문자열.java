import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int idx = 1;
        while(true) {
            input=br.readLine();
            if(input.contains("-")) break;

            System.out.println(idx + ". " + solution(input));
            idx++;
        }

    }
    public static int solution(String input) {
        int cnt = 0;

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<input.length(); i++) {
            char ch = input.charAt(i);
            
            if(ch=='{') {
                stack.push(ch);
            } else {
                if(stack.isEmpty()) {
                    cnt++;
                    stack.push('{'); //이미 바꿔서 넣음
                } else {
                    stack.pop(); // {}가 될 경우 pop
                }
            }
        }
        cnt += stack.size()/2;

        if(stack.isEmpty()) return cnt;
        return cnt;
    }
}