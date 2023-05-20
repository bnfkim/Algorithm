
import java.util.Scanner;
class Solution {
    public static void main(String args[]) throws Exception  {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++)  {
            //스도쿠 만들기 + 가로체크
            int[][] arr = new int[9][9];
            for(int i=0; i<9; i++) for(int j=0; j<9; j++) arr[i][j] = sc.nextInt();

            int result = 1;
            for(int i=0; i<9; i++){
                boolean[] checkX = new boolean[10];
                boolean[] checkY = new boolean[10];
                for(int j=0; j<9; j++){
                    //가로체크
                    int x = arr[i][j];
                    if(!checkX[x]) checkX[x] = true;
                    else {
                        result = 0;
                        break;
                    }
                    //세로체크
                    int y = arr[j][i];
                    if(!checkY[y]) checkY[y] = true;
                    else {
                        result = 0;
                        break;
                    }
                }
                if(result == 0) break;
            }
            if (result != 0) {
                //가운데 체크
                int xIdx = 0;
                int yIdx = 0;

                while (yIdx<9) {
                    boolean[] checkM = new boolean[10];
                    for(int i=yIdx; i<yIdx+3; i++){
                        for(int j=xIdx; j<xIdx+3; j++){
                            int m = arr[i][j];
                            if(!checkM[m]) checkM[m] = true;
                            else {
                                result = 0;
                                break;
                            }
                        }
                    }
                    if (result == 0) break;
                    xIdx += 3;
                    if(xIdx == 9){
                        xIdx = 0;
                        yIdx += 3;
                    }
                }

            }

            System.out.println("#" + tc + " " + result);
        }
    }
}