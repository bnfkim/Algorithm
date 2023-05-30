import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while(!(line = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();
            boolean flag = false;
            for(int i=0; i<line.length(); i++){
                char item = line.charAt(i);
                if (item == '(' || item == '[') {
                    stack.push(item);
                }
                else if (item == ')' || item == ']') {
                    //열린 괄호가 없으면 균형 불가
                    if (stack.isEmpty()) {
                        flag = true;
                        break;
                    }
                    //소괄호, 대괄호가 안 맞으면 균형 불가
                    char popItem = stack.pop();
                    if (item == ')' && popItem != '(') {
                        flag = true;
                        break;
                    }
                    if (item == ']' && popItem != '[') {
                        flag = true;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()) flag = true;
            if (flag) System.out.println("no");
            else System.out.println("yes");
        }
    }
}