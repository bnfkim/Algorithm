import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) list.add(i);
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int cnt = 1;
        while(list.size() != 0) {
            for(int i=0; i<list.size(); i++){
                if(cnt == k) {
                    int tmp = list.get(i);
                    sb.append(tmp).append(", ");
                    list.remove(i);
                    i -= 1;
                    cnt = 1;
                } else {
                    cnt++;
                }
            }
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
        System.out.println(sb);
    }
}