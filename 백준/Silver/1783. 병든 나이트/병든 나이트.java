import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        /**
         * 	1) 2칸 위로, 1칸 오른쪽
         * 	2) 1칸 위로, 2칸 오른쪽
         * 	3) 1칸 아래로, 2칸 오른쪽
         * 	4) 2칸 아래로, 1칸 오른쪽
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //세로길이
        int m = Integer.parseInt(st.nextToken()); //가로길이

        int result = 0;
        if(n == 1) result = 1; //이동불가
        else if (n == 2) { //상하 한칸씩 이동만 가능
            result = Math.min((m+1)/2, 4);
        } else {
            // m<7  ->  네방향 불가
            // m>=7 ->  네방향 가능
            //네방향 이동 후에는 오른쪽으로 가는게 1씩 이동인게 최소
            if(m<7) result = Math.min(m, 4);
            else result = m-2; //모든 방향을 이동하기 위해서 오른쪽으로 두칸씩 2번 이동한 것 때문에 -2
        }
        System.out.println(result);
    }
}