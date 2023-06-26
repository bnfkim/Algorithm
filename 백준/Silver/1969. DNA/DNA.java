import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        /**
         * 12:15 -
         * [문제]
         * Hamming Distance의 합이 가장 작은 DNA s를 구하는 것
         * [문제해결방법]
         * 문자열을 하나씩 순서대로 체크해서 가장 공통된 것이 많은 것을 선택
         * 공통된 문자가 아닌 것은
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //DNA 수
        int m = Integer.parseInt(st.nextToken()); //문자열의 길이
        String[] arr = new String[n];
        for(int i=0; i<n; i++) arr[i] = br.readLine();

        int hd = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            //맨 문자 앞에서 가장 많은 것 체크하기
            HashMap<Character, Integer> map = new HashMap<>();
            for(int j=0; j<n; j++) {
                char ch = arr[j].charAt(i);
                map.put(ch, map.getOrDefault(ch, 0)+1);
            }
            int cnt = 0;
            for(int v : map.values()) cnt = Math.max(cnt, v);
            //가장 수 많은 value 로 키찾기
            ArrayList<Character> list = new ArrayList<>();
            for(Map.Entry<Character, Integer> entry : map.entrySet()){
                if(entry.getValue().equals(cnt)) list.add(entry.getKey());
            }
            //DNA가 여러 개 있을 때에는 사전순으로 가장 앞서는 것을 출력하기 위한 조건
            Collections.sort(list);
            sb.append(list.get(0));
            hd += n-cnt;
        }
        System.out.println(sb);
        System.out.println(hd);
    }
}