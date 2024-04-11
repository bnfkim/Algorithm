import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int peopleNum, shelfHeight, minHeight;
    static int[] peopleHeightList;
    static boolean[] used;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            peopleNum = Integer.parseInt(st.nextToken());
            shelfHeight = Integer.parseInt(st.nextToken());
            minHeight = Integer.MAX_VALUE;

            peopleHeightList = new int[peopleNum];
            used = new boolean[peopleNum];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < peopleNum; i++) {
                peopleHeightList[i] = Integer.parseInt(st.nextToken());
            }

            setOfPeople(0);
            sb.append("#").append(tc).append(" ").append(minHeight - shelfHeight).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    //직원들의 키를 이용해서 부분집합를 구한다
    //재귀할 때 가장 중요한 것 (1)기저조건 (2)되돌려놓기
    public static void setOfPeople(int cnt) {
        //모든 점원들을 선택했다면
        if(cnt == peopleNum) {
            int sumOfHeight = 0;
            for(int i = 0; i < peopleNum; i++) {
                if(!used[i]) continue;  //사용하지 않은 경우는 패스

                sumOfHeight += peopleHeightList[i];
            }
            //점원들의 키 합산 값이 선반보다 높고 그 차이가 작을 때 업데이트
            if(sumOfHeight >= shelfHeight && sumOfHeight < minHeight) minHeight = sumOfHeight;

            return;
        }

        //점원 선택하기
        used[cnt] = true;
        setOfPeople(cnt + 1);

        //점원 선택하지 않기
        used[cnt] = false;
        setOfPeople(cnt + 1);
    }
}