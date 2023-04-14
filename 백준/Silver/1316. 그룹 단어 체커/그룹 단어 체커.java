import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //단어개수
        int cnt = 0;
        while(n-->0) if(checkGroup(br.readLine())) cnt++;
        System.out.println(cnt);
    }

    public static boolean checkGroup(String str){
        if(str.length()<=2) return true;
        ArrayList<Character> list = new ArrayList<>();
        for(int i=0; i<str.length(); i++){
            Character ch = str.charAt(i);
            if(list.contains(ch)) {
                if(ch != str.charAt(i-1)) return false;
            }
            else list.add(ch);
        }
        return true;
    }
}