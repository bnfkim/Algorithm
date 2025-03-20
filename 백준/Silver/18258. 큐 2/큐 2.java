import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 출력 최적화를 위한 StringBuilder
        Deque<Integer> q = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine()); // 빠른 입력

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄 입력 받기
            String cmm = st.nextToken(); // 명령어 추출
            
            if (cmm.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                q.offer(num);
            } else if (cmm.equals("front")) {
                sb.append(q.isEmpty() ? -1 : q.peekFirst()).append("\n");
            } else if (cmm.equals("back")) {
                sb.append(q.isEmpty() ? -1 : q.peekLast()).append("\n");
            } else if (cmm.equals("size")) {
                sb.append(q.size()).append("\n");
            } else if (cmm.equals("empty")) {
                sb.append(q.isEmpty() ? 1 : 0).append("\n");
            } else if (cmm.equals("pop")) {
                sb.append(q.isEmpty() ? -1 : q.poll()).append("\n");
            }
        }
        
        System.out.print(sb.toString()); // 한 번에 출력
    }
}