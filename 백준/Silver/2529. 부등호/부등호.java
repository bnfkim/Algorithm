import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int k;
    static String[] sign;
    static int[] nums;
    static boolean[] visit;
    static ArrayList<String> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //9까지 있는 boolean 배열을 하나. (idx=숫자, value=사용여부)
        //숫자 값을 넣을 int 배열 하나
        //결과 값을 집어넣을 String 배열 하나
        //완전 탐색 bf + 재귀 + 백트래킹

        //입력받기
        k = Integer.parseInt(br.readLine());
        sign = br.readLine().split(" ");

        nums = new int[k+1]; //숫자저장 배열
        Arrays.fill(nums, -1);
        visit = new boolean[10];

        insert(0, nums, visit);

        Collections.sort(results);
        System.out.println(results.get(results.size()-1));
        System.out.println(results.get(0));
    }
    public static void insert(int idx, int[] nums, boolean[] visit) {

        //종료조건1
        if(idx == k+1) {
            results.add(intArrToString(nums));
            return;
        }

        for(int i=0; i<10; i++) {
            if(visit[i]) continue;

            if(idx != 0) {
                if(sign[idx-1].equals("<")) {
                    if (nums[idx-1] > i) continue;
                }
                else {
                    if (nums[idx-1] < i) continue;
                }
            }

            visit[i] = true; //방문한 것으로 변경
            nums[idx] = i; //숫자 배열에 숫자 넣음
            insert(idx+1, nums, visit);
            nums[idx] = 0;
            visit[i] = false;
        }
    }

    static String intArrToString (int[] nums) {
        StringBuilder sb = new StringBuilder();
        for(int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }
}