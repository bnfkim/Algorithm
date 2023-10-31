import java.util.*;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int T = sc.nextInt();
            Queue<Integer> q = new LinkedList<>();
            for(int i=0; i<8; i++) q.add(sc.nextInt());

            int idx = 1;
            while(true) {

                int item = q.poll();
                int num = item - idx;
                if(num <= 0) {
                    num = 0;
                    q.add(num);
                    break;
                }
                q.add(num);

                if(idx == 5) idx = 0;
                idx++;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(T).append(" ");
            while(!q.isEmpty()){
                sb.append(q.poll()).append(" ");
            }
            System.out.println(sb.toString());
        }
    }
}