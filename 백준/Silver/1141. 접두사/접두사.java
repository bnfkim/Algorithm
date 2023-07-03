import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    /**
     * [해결방법]
     * 문자열 길이 순서대로 내림정렬
     * 맨 앞에 단어가 포함되지 않는 경우에 set에 추가하기
     * set.size() 반환
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<n; i++) list.add(br.readLine());

        //문자열 길이를 기준으로 내림차순
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        
        HashSet<String> set = new HashSet<>();
        for(String s1 : list) {
            if(set.size() == 0) {
                set.add(s1);
                continue;
            }
            //set에 있는 문자열 중에 s1을 포함하는게 있으면 추가 x
            boolean check = true;
            for(String s2 : set) {
                //만약 접두사가 있으면 (접두사여야 하므로 indexOf == 0 사용)
                if(s2.indexOf(s1) == 0) {
                    check = false;
                    break;
                }
            }
            if(check) set.add(s1);
        }
        System.out.println(set.size());
    }
}