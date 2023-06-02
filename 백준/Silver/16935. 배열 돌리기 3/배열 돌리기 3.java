import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        /**
         * 5:00 -
         * [주의 해야할 점]
         * 연산을 순서대로 적용해야함
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //가로
        int m = Integer.parseInt(st.nextToken()); //세로
        int r = Integer.parseInt(st.nextToken()); //연산
        int[][] arr = new int[n][m];
        //배열 입력받기
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        //연산 입력받기
        char[] command = br.readLine().toCharArray();
        for(char c : command){
            switch (c){
                case '1': //상하반전
                    arr = command1(arr);
                    break;
                case '2': //좌우반전
                    arr = command2(arr);
                    break;
                case '3': //오른쪽90
                    arr = command3(arr);
                    break;
                case '4': //왼쪽90
                    arr = command4(arr);
                    break;
                case '5': //시계방향
                     arr = command5(arr);
                    break;
                case '6': //반시계방향
                    arr = command6(arr);
                    break;
            }
        }
        print(arr);
    }
    private static void print(int[][] arr) {
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++) System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
    private static int[][] command1 (int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] newArr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) newArr[i][j] = arr[n-i-1][j];
        }
        return newArr;
    }
    private static int[][] command2 (int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] newArr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) newArr[i][j] = arr[i][m-j-1];
        }
        return newArr;
    }
    private static int[][] command3 (int[][] arr) { //n=6, m=8
        int n = arr.length;
        int m = arr[0].length;
        int[][] newArr = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++) newArr[i][j] = arr[n-j-1][i];
        }
        return newArr;
    }
    private static int[][] command4 (int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] newArr = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //System.out.println("(" + i + "," + j + ") <- " + arr[n-j-1][i]);
                newArr[i][j] = arr[j][m-i-1];
            }
        }
        return newArr;
    }
    private static int[][] command5 (int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] newArr = new int[n][m];
        for(int i=0; i<n/2; i++){
            for(int j=0; j<m/2; j++){
                newArr[i][j] = arr[i+n/2][j]; //4->1
                newArr[i][j+m/2] = arr[i][j]; //1->2
                newArr[i+n/2][j+m/2] = arr[i][j+m/2]; //2->3
                newArr[i+n/2][j] = arr[i+n/2][j+m/2]; //3->4
            }
        }
        return newArr;
    }
    private static int[][] command6 (int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] newArr = new int[n][m];

        for(int i=0; i<n/2; i++){
            for(int j=0; j<m/2; j++){
                newArr[i][j] = arr[i][j+m/2]; //1<-2
                newArr[i][j+m/2] = arr[i+n/2][j+m/2]; //2<-3
                newArr[i+n/2][j+m/2] = arr[i+n/2][j]; //3<-4
                newArr[i+n/2][j] = arr[i][j]; //4<-1
            }
        }
        return newArr;
    }
}