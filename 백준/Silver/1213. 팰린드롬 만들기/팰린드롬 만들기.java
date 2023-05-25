import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    /**
     * 12:28 -
     */
    static String[] arr;
    static HashMap<String, Integer> map;
    public static void main(String[] args) throws IOException {
        /**
         * 이름이 짝수일때 -> 나온 갯수가 모두 짝수여야 함
         * 이름이 홀수일때 -> 1글자만 홀수여야 함
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().split("");
        map = new HashMap<>();
        String error = "I'm Sorry Hansoo";

        for (int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        int checkResult = check();
        if (checkResult == -1) System.out.println(error);
        else {
            ArrayList<String> list = new ArrayList<>();
            for(String key : map.keySet()) {
                int tmp = map.get(key)/2;
                while(tmp --> 0) list.add(key);
            }
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for(String s : list) sb.append(s);
            for(int i=list.size()-1; i>=0; i--){
                sb.append(list.get(i));
            }
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                if(entry.getValue().equals(checkResult) ){
                    sb.insert(arr.length/2, entry.getKey());
                }
            }
            System.out.println(sb);
        }
    }
    // 펠린드롬 불가(0), 짝수(0), 홀수(홀수갯수)
    private static int check() {
        //이름이 짝수일때
        if(arr.length % 2 == 0){
            for(int v : map.values()){
                if(v % 2 != 0) return -1;
            }
            return 0;
        } else { //이름이 홀수일때
            int cnt = 0;
            int value = 0;
            for(int v : map.values()) {
                if(v % 2 != 0) {
                    cnt++;
                    value = v;
                }
                if(cnt == 2) return -1;
            }
            return value;
        }
    }
}