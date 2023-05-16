import java.util.Scanner;
class Solution {
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            System.out.println("#" + tc);
            int n = sc.nextInt();
            int[][] arr = new int[n+1][n+1];
            boolean[][] visit = new boolean[n+1][n+1];

            int add = 1; //1씩 증가하는 숫자
            int top = 1;
            int left = 1;
            int bottom = n;
            int right = n;
            while(add <= n*n) {
                //(1)오른쪽
                for(int i=left; i<n+1; i++){
                    if(visit[top][i]) continue;
                    arr[top][i] = add;
                    visit[top][i] = true;
                    add++;
                }
                top++;
                //(2)아래쪽
                for(int i=top; i<n+1; i++) {
                    if(visit[i][right]) continue;
                    arr[i][right] = add;
                    visit[i][right] = true;
                    add++;
                }
                right--;
                //(3)왼쪽
                for(int i=right; i>0; i--){
                    if(visit[bottom][i]) continue;
                    arr[bottom][i] = add;
                    visit[bottom][i] = true;
                    add++;
                }
                bottom--;
                //(4)위쪽
                for(int i=bottom; i>0; i--){
                    if(visit[i][left]) continue;
                    arr[i][left] = add;
                    visit[i][left] = true;
                    add++;
                }
                left++;
            }

            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++) System.out.print(arr[i][j] + " ");
                System.out.println();
            }
        }
    }
}