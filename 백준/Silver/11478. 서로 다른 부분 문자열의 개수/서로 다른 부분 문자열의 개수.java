import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Main{
    public static void main(String[] args) throws IOException {
        /**
         * 12:20 - 12:33
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        HashSet<String> set = new HashSet<>();

        for(int i=1; i<str.length(); i++){
            for(int j=0; j<str.length(); j++){
                if(j+i > str.length()) break;
                set.add(str.substring(j, j+i));
            }
        }
        System.out.println(set.size()+1);
    }
}