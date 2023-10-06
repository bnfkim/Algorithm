
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //테스트 케이스

        while(T-->0){
            int n = Integer.parseInt(br.readLine()); //지원자의 숫자
            int[][] arr = new int[n][2];
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken()); //서류 점수
                arr[i][1] = Integer.parseInt(st.nextToken()); //면접 점수
            }
            //서류 등수 순으로 정렬
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int top = arr[0][1]; //서류 1등의 면접점수 (서류 1등은 무조건 통과)
            int cnt = 0; //탈락자 수
            for(int i=1; i<n; i++) {
                if(top < arr[i][1]) { //서류 등수가 더 높은 지원자보다 면접 등수가 낮으면 탈락
                    cnt++;
                    continue;
                }
                top = arr[i][1]; //탈락 안 된 지원자의 면접점수
            }
            System.out.println(n-cnt);
        }
    }
}