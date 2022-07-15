import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //좌표값 넣기기
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = br.readLine();
        }

        //compare 메소드는 3가지 리턴 값에 의해 위치를 바꿀지 결정
        //3가지 리턴 값 -> 양의 정수(위치바꿈), 0(그대로), 음의 정수(그대로)
//        Arrays.sort(arr, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if(o1.length() == o2.length()) { //두 번째 원소가 같다면 첫 번째 원소끼리 비교
//                    return o1.compareTo(o2);
//                } else {
//                    return o1.length() - o2.length();
//                }
//            }
//        });

        Arrays.sort(arr, (e1, e2) -> {
            if(e1.length() == e2.length()) { //두 번째 원소가 같다면 첫 번째 원소끼리 비교
                return e1.compareTo(e2);
            } else {
                return e1.length() - e2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append('\n');
        for(int i=1; i<n; i++){
            if(!arr[i].equals(arr[i-1])){
                sb.append(arr[i]).append('\n');
            }
        }
        System.out.println(sb);
    }
}