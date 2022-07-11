import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //입력값
        int[][] bulk = new int[n][2];

        //덩치 데이터 저장
        for(int i=0; i<n; i++){
            StringTokenizer st =  new StringTokenizer(br.readLine());
            bulk[i][0] = Integer.parseInt(st.nextToken()); //몸무게
            bulk[i][1] = Integer.parseInt(st.nextToken()); //키
        }

        for(int i=0; i<n; i++){
            int rank = 1;
            for(int j=0; j<n; j++){
                if (i==j) continue;
                // 키와 몸무게가 둘 다 큰 경우에만 rank ++
                if(bulk[i][0] < bulk[j][0] && bulk[i][1] < bulk[j][1]){
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }
}