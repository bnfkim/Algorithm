import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    /**
     * 11:08 -
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            int item = Integer.parseInt(br.readLine());
            if(item == 0) {
                if(q.isEmpty()) System.out.println(0);
                else System.out.println(q.poll());
            } else {
                q.offer(item);
            }
        }
    }
}