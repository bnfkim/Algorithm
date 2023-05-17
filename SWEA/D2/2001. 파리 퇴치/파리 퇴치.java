import java.util.Scanner;
class Solution {
    public static void main(String[] args) throws Exception     {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][n];

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++) arr[i][j] = sc.nextInt();
            }
            int max = 0;
            //필요한 조건 : 파리채가 배열 밖으로 나가지 않게
            for(int i=0; i<n-m+1; i++){ //배열 오른쪽 이동칸수
                for(int j=0; j<n-m+1; j++){ //배열 아래쪽 이동칸수
                    int sum = 0;
                    for(int y=0; y<m; y++){ //파리채 오른쪽 이동칸수
                        for(int x=0; x<m; x++){ //파리채 아래쪽 이동칸수
                            sum += arr[i+y][j+x];
                        }
                    }
                    max = Math.max(sum, max);
                }
            }
            System.out.println("#" + tc + " " + max);
        }
    }
}