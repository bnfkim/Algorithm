import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //단어의 개수
        String[] arr = new String[n];
        for(int i=0; i<n; i++) arr[i] = br.readLine();
        int len = arr[0].length();
        int cnt = 0;

        for(int i=0; i<n; i++) { //단어 A
            for(int j=i+1; j<n; j++) { //단어 B
                boolean check = true;
                HashMap<Character, Character> hashMap = new HashMap<>();

                for(int k=0; k<len; k++){
                    char origin = arr[i].charAt(k); //단어 A의 문자
                    char change = arr[j].charAt(k); //단어 B의 문자

                    if(hashMap.containsKey(origin)){ //이미 바꾼적이 있는 경우
                        //매칭되어있는 단어가 다른 단어인 경우 -> 패스
                        if(hashMap.get(origin) != change){
                            check = false;
                            break;
                        }
                    }else{ //바꾼 적이 없는 경우
                        for(Character key : hashMap.keySet()) {
                            //이미 단어A 문자가 단어B 랑 같은 경우 -> 패스
                            if(hashMap.get(key) == change) {
                                check = false;
                                break;
                            }
                        }
                        //새로운 단어 조합이고 + 다른 단어 조합일 때 -> map 에 추가
                        if(check) hashMap.put(origin, change);
                    }
                }
                if(check) cnt ++;
            }
        }
        System.out.println(cnt);
    }
}