import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main{
    public static void main(String[] args) throws IOException {
        /**
         * 3:40 - 4: 20
         * [해결방법]
         * - 를 기준으로 나눈다 (arr)
         * arr를 + 기준으로 나눈다 (tmp)
         * tmp 안에 있는 숫자끼리 서로 더한다
         * 맨 앞 값을 빼고 나머지는 다 빼준다
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        ArrayList<Integer> numList = new ArrayList<>();
        String[] arr = str.split("-");

        for (String a : arr) {
            String[] tmp = a.split("\\+");
            int sum = 0;
            for (String t : tmp) sum += Integer.parseInt(t);
            numList.add(sum);
        }

        int result = numList.get(0);
        for(int i=1; i<numList.size(); i++) result -= numList.get(i);
        System.out.println(result);
    }
}