import java.io.BufferedReader;
import java.io.InputStreamReader;
class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            int sum = 0;
            for(int i=0; i<n; i++){
                String str = br.readLine();
                for(int j=0; j<n; j++){
                    arr[i][j] = str.charAt(j) - '0';
                    sum += arr[i][j];
                }
            }
            int mid = n/2;
            int a = 0; //위왼쪽
            for(int i=0; i<mid; i++){
                for(int j=0; j<mid-i; j++){
                    a += arr[i][j];
                }
            }
            int b = 0; //위오른쪽
            for(int i=0; i<mid; i++){
                for(int j=mid+1+i; j<n; j++){
                    b += arr[i][j];
                }
            }
            int c = 0; //아래왼쪽
            for(int i=mid+1; i<n; i++){
                for(int j=0; j<i-mid; j++){
                    c += arr[i][j];
                }
            }
            int d = 0; //아래오른쪽
            for(int i=mid+1; i<n; i++){
                for(int j=n-1; j>=n-i+mid; j--){
                    d += arr[i][j];
                }
            }
            sum -= (a+b+c+d);
            System.out.println("#" + tc + " " + sum);
        }
    }
}