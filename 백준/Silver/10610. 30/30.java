import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] num = new int[10];
        int sum = 0;
        for(int i=0; i<str.length(); i++) {
            int n = str.charAt(i) - '0';
            num[n]++;
            sum += n;
        }
        if(!str.contains("0") || sum%3 != 0) System.out.println(-1);
        else {
            StringBuilder sb = new StringBuilder();
            for(int i=9; i>=0; i--) {
                while(num[i] > 0) {
                    sb.append(i);
                    num[i]--;
                }
            }
            System.out.println(sb);
        }
    }
}