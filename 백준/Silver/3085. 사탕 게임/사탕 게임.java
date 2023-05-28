import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    /**
     * 11:30
     * 해결방법 -> 완전탐색 방법
     * 양 옆이 서로 다른 색상일시 교환
     */
    static int n;
    static int result = 1;
    static String[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n][n];
        for(int i=0; i<n; i++) arr[i] = br.readLine().split("");
        
        for(int i=0; i<n; i++){
            result = Math.max(result, checkCol(i));
            result = Math.max(result, checkRow(i));
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(j<n-1) { //오른쪽 swap
                    if(!arr[i][j].equals(arr[i][j+1])) {
                        swap(i, j, i, j+1);
                        result = Math.max(result, checkRow(i));
                        result = Math.max(result, checkCol(j));
                        result = Math.max(result, checkCol(j+1));
                        swap(i, j, i, j+1);
                    }
                }
                if(i<n-1) { //아래쪽 swap
                    if(!arr[i][j].equals(arr[i+1][j])) {
                        swap(i, j, i+1, j);
                        result = Math.max(result, checkRow(i));
                        result = Math.max(result, checkRow(i+1));
                        result = Math.max(result, checkCol(j));
                        swap(i, j, i+1, j);
                    }
                }
            }
        }
        System.out.println(result);
    }
    public static void swap(int x1, int y1, int x2, int y2) {
        String tmp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = tmp;
    }

    private static int checkRow(int y) {
        String item = arr[y][0];
        int cnt = 1;
        int tmp = 1;

        for(int i=1; i<arr.length; i++) {
            if(!arr[y][i].equals(item)) {
                item = arr[y][i];
                cnt = Math.max(cnt, tmp);
                tmp = 1;
            } else tmp++;
        }
        return Math.max(tmp, cnt);
    }
    private static int checkCol(int x){
        String itemY = arr[0][x];
        int cnt = 1;
        int tmp = 1;

        for(int i=1; i<arr.length; i++) {
            if(!arr[i][x].equals(itemY)){
                itemY = arr[i][x];
                cnt = Math.max(cnt, tmp);
                tmp = 1;
            } else tmp++;
        }
        return Math.max(tmp, cnt);    
    }
}