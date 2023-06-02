import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main{
    public static void main(String[] args) throws IOException {
        /**
         * 3:38 -
         *
         * ex.
         * 30 - (40 + 50 + 60) - 30 + 20 - 10 - 30 -10 + 100 + 200
         * 30 / 40 + 50 + 60 / 30 + 20 / 10 / 30 / 10 + 100 + 200
         *
         * [해결방법]
         * - 를 기준으로 나눈다 (arr)
         * arr를 + 기준으로 나눈다 (tmp)
         * tmp 안에 있는 숫자끼리 서로 더
         */
//        String str = "abc+def";
//        String[] arr = str.split("-");
//        System.out.println(arr.length);
//        for(int i=0; i<arr.length; i++) System.out.print(i + "번째 >>> " + arr[i] + " ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        ArrayList<Integer> numList = new ArrayList<>();
        String[] arr = str.split("-");

//        System.out.println("(-) 로 쪼갠 배열");
//        for(String a : arr) System.out.print(a + " ");
//        System.out.println();

        for(int i=0; i<arr.length; i++) {
            String[] tmp = arr[i].split("\\+");

//            System.out.print("------ (+) 로 쪼갠 배열 >> ");
//            for(String t : tmp) System.out.print(t + " ");
//            System.out.println();

            int sum = 0;
            //마지막은 숫자라는 조건을 위한 코드
//            if(i==arr.length-1){
//                if(tmp.length != 1) {
//                    last = Integer.parseInt(tmp[tmp.length-1]);
//                    tmp[tmp.length-1] = "0";
//                }
//            }
            for(int j=0; j<tmp.length; j++) {
                sum += Integer.parseInt(tmp[j]);
            }
            numList.add(sum);
        }

        int result = numList.get(0);
        for(int i=1; i<numList.size(); i++) result -= numList.get(i);
        System.out.println(result);
    }
}