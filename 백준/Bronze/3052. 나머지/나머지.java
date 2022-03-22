import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> arr = new ArrayList<>();

        // 수 입력받고 나머지 배열에 저장하기
        for(int i =0; i <10; i++){
            int num = Integer.parseInt(br.readLine());
            arr.add(num%42);
        }
        // set을 통해 중복값 제거하기
        HashSet<Integer> set = new HashSet<>(arr);
        // set을 다시 배열로 변환
        ArrayList<Integer> resultArr = new ArrayList<>(set);

        bw.write(resultArr.size() + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}