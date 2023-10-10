
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //기타의 개수
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<n; i++) list.add(br.readLine());

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()) {
                    if(idxSum(s1) == idxSum(s2)) {
                        return s1.compareTo(s2); //(3) 사전 순
                    }
                    return idxSum(s1) - idxSum(s2); //(2) 합이 작은게 먼저
                }
                return s1.length() - s2.length(); //(1) 짧은 것이 먼저
            }
        });

        for(String l : list) System.out.println(l);
    }

    public static int idxSum(String s) {
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch - '0' < 10) sum += (ch - '0'); //숫자만 더함
        }
        return sum;
    }
}