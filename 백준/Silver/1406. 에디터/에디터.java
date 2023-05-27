import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        /**
         * L(왼쪽 한칸), D(오른쪽 한칸), B(왼쪽문자 삭제), P (왼쪽에 추가)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stackL = new Stack<>(); //커서를 기준으로 왼쪽
        Stack<String> stackR = new Stack<>(); //커서를 기준으로 오른쪽

        String[] arr = br.readLine().split("");
        for (String a : arr) stackL.push(a);

        int m = Integer.parseInt(br.readLine());
        while(m-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "L":
                    if(!stackL.isEmpty()) stackR.push(stackL.pop());
                    break;
                case "D":
                    if(!stackR.isEmpty()) stackL.push(stackR.pop());
                    break;
                case "B":
                    if(!stackL.isEmpty()) stackL.pop();
                    break;
                case "P":
                    stackL.push(st.nextToken());
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stackL.isEmpty()) stackR.push(stackL.pop());
        while(!stackR.isEmpty()) sb.append(stackR.pop());
        System.out.println(sb);
    }
}