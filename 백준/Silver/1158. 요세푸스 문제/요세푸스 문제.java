import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> linkedList = new LinkedList<>();

        for(int i=1; i<=N; i++) {
            linkedList.add(i);
        }

        int idx = 1;
        while(!linkedList.isEmpty()) {
            int person = linkedList.poll();

            if(idx % K == 0) sb.append(person).append(", ");
            else linkedList.add(person);
            
            idx++;
        }

        sb.insert(0, "<");
        sb.replace(sb.length()-2, sb.length()-1, ">");

        System.out.println(sb.toString());
    }
}