import java.util.Scanner;
class Solution {
    /**
     * 40분 소요
     */
    public static void main(String args[]) throws Exception  {
        Scanner sc = new Scanner(System.in);
        for(int tc=1; tc<=10; tc++){
            int T = sc.nextInt();
            int[][] arr = new int[100][100];
            int result = 0;
            for(int i=0; i<100; i++) for(int j=0; j<100; j++) arr[i][j] = sc.nextInt();

            //가로 합, 세로합 구하기
            int sumX = 0;
            int sumY = 0;
            int maxX = 0;
            int maxY = 0;
            for(int i=0; i<100; i++){
                for(int j=0; j<100; j++){
                    sumX += arr[i][j];
                    sumY += arr[j][i];
                }
                maxX = Math.max(maxX, sumX);
                maxY = Math.max(maxY, sumY);
                sumX = 0;
                sumY = 0;
            }

            //왼쪽대각선 오른쪽 대각선 합 구하기
            int sumA = 0;
            int sumB = 0;
            for(int i=0; i<100; i++){
                sumA += arr[i][i];
                sumB += arr[100-i-1][i];
            }
            result = Math.max(Math.max(maxX, maxY), Math.max(sumA, sumB));
            System.out.println("#" + tc + " " + result);
        }
    }
}