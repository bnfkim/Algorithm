import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;

        //두 글자씩 끊어서 다중집합의 원소로 만들기
        ArrayList<String> list1 = makeStringSet(str1.toUpperCase());
        ArrayList<String> list2 = makeStringSet(str2.toUpperCase());
        
        //공집합일 경우 처리
        if(list1.size() == 0 && list2.size() == 0) return 65536;
        
        //교집합, 합집합 처리하기
        ArrayList<String> inter = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        
        for(String set : list1) { //겹치는 집합은 교집합에 추가
            if(list2.remove(set)) inter.add(set);
            union.add(set);
        }
        for(String set : list2) { //안 겹치고 남은 집합은 합집합에 추가
            union.add(set);
        }
        
        return cal(inter.size(), union.size());
    }
    public static ArrayList<String> makeStringSet(String str){
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<str.length()-1; i++) {
            if(str.charAt(i) - '0' < 17 || str.charAt(i) - '0' > 42) continue;
            if(str.charAt(i+1) - '0' < 17 || str.charAt(i+1) - '0' > 42) continue;
            
            list.add(str.substring(i, i+2));
        }
        return list;
    }
    public static int cal(double interSize, double unionSize){
        int answer = 0;
        double jac = (double) interSize/unionSize;
        answer = (int) (jac * 65536.0);
        return answer;
    }
}