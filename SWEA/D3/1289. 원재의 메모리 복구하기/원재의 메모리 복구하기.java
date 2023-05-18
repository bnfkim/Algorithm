import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

class Solution {
    static int[] arr;
    static int[] result;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            String str = br.readLine();
            arr = new int[str.length()];
            result = new int[str.length()];
            int cnt = 0;

            for(int i=0; i<str.length(); i++) arr[i] = str.charAt(i) - '0';

            int start;
            int bit = 1;
            while(true){
                start = check();
                if(start == -1) break;
                for(int i=start; i<arr.length; i++){
                    result[i] = bit;
                }
                bit = Math.abs(bit - 1);
                cnt++;
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }
    public static int check() {
        for(int i=0; i<arr.length; i++){
            if(arr[i] != result[i]) return i;
        }
        return -1;
    }
}