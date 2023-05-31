import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int n,m,r;
    static int min;
    static int[][] arr;
    //왼쪽으로 넣고, 위로넣고, 오른쪽으로 넣고, 아래로 넣는 순서
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //세로
        m = Integer.parseInt(st.nextToken()); //가로
        r = Integer.parseInt(st.nextToken()); //회전
        arr = new int[n][m];

        //0) 배열 입력받기
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //1) 회전시켜야하는 라인의 갯수 구하기
        int min = Math.min(n, m)/2; //돌아가는 라인

        //2) 구한 라인 갯수만큼 반복하여 회전
        for(int i=0; i<r; i++){ //회전 횟수만큼 반복
            for(int j=0; j<min; j++) { //라인들 전부 돌리기
                int x = j;
                int y = j;
                int tmp = arr[x][y]; //맨 마지막 값 넣어두기

                int idx = 0;
                while(idx < 4) {
                    int nx = x + dx[idx];
                    int ny = y + dy[idx];
                    //범위 안이라면
                    if(nx < n-j && ny < m-j && nx>=j && ny>=j){
                        //System.out.println("arr[" + x + ", " + y + "] (" + arr[x][y] + ") <- arr[" + nx + ", " + ny + "] (" + arr[nx][ny] + ")");
                        arr[x][y] = arr[nx][ny];
                        x = nx;
                        y = ny;
                    }
                    //범위를 벗어났다면 다음 방향으로 이동
                    else idx++;
                }
                //빼놓은 값 넣어줌
                arr[j+1][j] = tmp;
            }
        }
        //3) 출력하기
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

}