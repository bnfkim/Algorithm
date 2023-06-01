import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        /**
         * 3:33 - 3:48
         * 연속해서 두칸 이상 있으면 됨
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for(int i=0; i<n; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        int x = 0; //가로로 누울 수 있는 자리
        int y = 0; //세로로 누울 수 있는 자리

        //가로체크
        for(int i=0; i<n; i++){
            int cntX = 0;
            for(int j=0; j<n; j++){
                if(arr[i][j] == '.') cntX++;
                else cntX=0;

                if(cntX == 2) {
                    x++;
                }
            }
        }

        for(int i=0; i<n; i++){
            int cntY = 0;
            for(int j=0; j<n; j++){
                if(arr[j][i] == '.') cntY++;
                else cntY=0;

                if(cntY == 2) {
                    y++;
                }
            }
        }
        System.out.println(x + " " + y);
    }
}