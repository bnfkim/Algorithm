import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] nums, result;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nums = new int[9];
        visit = new boolean[9];

        result = new int[7];
        for(int i=0; i<9; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        dfs(0,0);
    }

    public static void dfs(int dep, int start) {
        if(dep == 7) {
            if(!sum100()) return;

            for(int r : result) System.out.println(r);
            return;
        }

        for(int i=start; i<9; i++) {
            if(visit[i]) continue;

            visit[i] = true;
            result[dep] = nums[i];
            dfs(dep+1, i+1);
            visit[i] = false;
        }
    }

    public static boolean sum100() {
        int sum = 0;
        for(int r : result) {
            sum+=r;
        }
        if(sum != 100) return false;
        return true;
    }
}