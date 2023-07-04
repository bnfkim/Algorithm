import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    /**
     * 3:17 - 3:27
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 후보의 수
        int score = Integer.parseInt(br.readLine()); //다솜이표

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n-1; i++) list.add(Integer.parseInt(br.readLine())); //다른 후보 예상 표 입력받기
        int cnt = 0; //매수해야하는 사람의 최솟값

        if(n==1) System.out.println(0); //다솜이 혼자 나왔을 경우
        else {
            while (true) {
                //내림차순으로 정렬
                Collections.sort(list, Collections.reverseOrder());
                if(score > list.get(0)) {
                    break;
                }else {
                    list.set(0, list.get(0)-1);
                    score++;
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}