import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); //시작시간
            arr[i][1] = Integer.parseInt(st.nextToken()); //종료시간
        }

        //시작시간과 끝에 시간 차이가 적은 순서대로 정렬
        Arrays.sort(arr, (o1, o2) -> {
           if(o1[1] == o2[1]) { //종료시간이 같은 경우, 시작시간이 빠른 순
               return o1[0] - o2[0];
           }
           return o1[1] - o2[1];
        });

        int cnt = 0;
        int end = 0;
        for(int i=0; i<N; i++){
            if(end <= arr[i][0]) {
                end = arr[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}