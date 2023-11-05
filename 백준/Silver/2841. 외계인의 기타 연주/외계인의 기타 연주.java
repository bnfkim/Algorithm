import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 음의 수
        int P = Integer.parseInt(st.nextToken()); //프렛의 수

        Stack<Integer>[] stack = new Stack[7];
        for(int i=1; i<7; i++) stack[i] = new Stack<>();

        int cnt = 0;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken()); //줄의 번호
            int fret = Integer.parseInt(st.nextToken()); //프렛의 번호

            while(!stack[line].isEmpty()) {
                //스택에 들어있는 fret 보다 입력받은 fret이 더 큰 경우
                if(stack[line].peek() < fret) {
                    stack[line].push(fret);
                }
                //스택에 들어있는 fret 보다 입력받은 fret이 더 작은 경우
                else if (stack[line].peek() > fret) {
                    stack[line].pop();
                } else {
                    break;
                }
                cnt += 1;
            }
            if(stack[line].isEmpty()) {
                stack[line].push(fret);
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}
