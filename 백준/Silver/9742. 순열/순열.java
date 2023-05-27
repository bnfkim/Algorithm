import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int n;
    static int cnt;
    static boolean flag, noPermutation;
    static String[] arr, result;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(line);
            if(!st.hasMoreTokens()) break;

            String input = st.nextToken();
            n = Integer.parseInt(st.nextToken());
            arr = input.split("");
            visit = new boolean[arr.length];
            result = new String[arr.length];
            cnt = 0;
            flag = false;
            noPermutation = false;

            dfs(0);
            if(cnt < n) noPermutation = true;

            StringBuilder sb = new StringBuilder();
            sb.append(input).append(" ").append(n).append(" = ");
            if(noPermutation) sb.append("No permutation");
            else for(String r : result) sb.append(r);
            System.out.println(sb);
        }
    }
    public static void dfs(int depth) {
        if(depth == arr.length) {
            cnt++;
//            System.out.print(">>> cnt : " + cnt + " >>> ");
//            for(String r : result) System.out.print(r);
//            System.out.println();
            if(cnt == n) flag = true;
            return;
        }

        for(int i=0; i< arr.length; i++){
            if(!visit[i]) {
                visit[i] = true;
                result[depth] = arr[i];
                dfs(depth+1);
                if(flag) break;
                visit[i] = false;
            }
        }
    }
}