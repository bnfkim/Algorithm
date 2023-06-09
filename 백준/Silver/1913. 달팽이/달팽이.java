import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main{
    /**
     * 3:00 - 3:21
     *
     * 49 26 27 28 29 30 31
     * 48 25 10 11 12 13 32
     * 47 24  9  2  3 14 33
     * 46 23  8  1  4 15 34
     * 45 22  7  6  5 16 35
     * 44 21 20 19 18 17 36
     * 43 42 41 40 39 38 37
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //홀수가 주어짐
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        boolean[][] visit = new boolean[n][n];

        int x = 0;
        int y = 0;

        //거꾸로 채워가기 n^2 -> 1
        int cnt = (int) Math.pow(n, 2);
        int l = 0, t = 0, r = n-1, b = n-1;
        while(cnt != 0) {
            //아래
            for(int i=t; i<=b; i++) {
                arr[i][l] = cnt;
                cnt--;
            }
            l++;
            //오른쪽
            for(int i=l; i<=r; i++){
                arr[b][i] = cnt;
                cnt--;
            }
            b--;
            //위
            for(int i=b; i>=t; i--) {
                arr[i][r] = cnt;
                cnt--;
            }
            r--;
            //왼쪽
            for(int i=r; i>=l; i--) {
                arr[t][i] = cnt;
                cnt--;
            }
            t++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                sb.append(arr[i][j]).append(" ");
                if(arr[i][j] == m) {
                    x = j;
                    y = i;
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
        System.out.println((y+1) + " " + (x+1));

    }
}