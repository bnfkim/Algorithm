import java.util.Scanner;
class Solution {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt(); //배열 길이
            int k = sc.nextInt(); //단어의 수
            int[][] arr = new int[n][n];
            int cnt = 0;
            //흰색(1), 검은색(0) => 1일때 단어를 넣을 수 있음
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++) arr[i][j] = sc.nextInt();
            }
            //가로 & 세로 글자 수 만큼 찾기
            for(int i=0; i<n; i++){
                int x = 0;
                int y = 0;
                for(int j=1; j<=n; j++){
                    //가로
                    if(arr[i][j-1] == 1) x += arr[i][j-1];
                    else {
                        if(x==k) cnt++;
                        x = 0;
                    }
                    //세로
                    if(arr[j-1][i] == 1) y += arr[j-1][i];
                    else {
                        if(y==k) cnt++;
                        y = 0;
                    }
                }
                if(x == k) cnt++;
                if(y == k) cnt++;
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }
}