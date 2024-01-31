import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, R;
    static boolean[] learned = new boolean[26];
    static String[] words;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        init();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //단어의 개수
        K = Integer.parseInt(st.nextToken()); //글자의 개수
        R = K-5; //기본 단어를 빼고 조합 해야 하는 수

        //단어 입력 받기
        words = new String[N];
        for(int i=0; i<N; i++) words[i] = br.readLine();

        solve();
        System.out.println(result);
    }
    static void init() {
        //남극 단어 a,n,t,c,i 미리 세팅하기
        learned['a' - 'a'] = true;
        learned['n' - 'a'] = true;
        learned['t' - 'a'] = true;
        learned['i' - 'a'] = true;
        learned['c' - 'a'] = true;
    }
    static void solve() {
        if (K<5) return;
        //getData();
        combination(0,0);
    }
    static void combination(int dep, int start) {
        if(dep == R) {
            result = Math.max(result, getResult());
            return;
        }

        for(int i=start; i<26; i++) {
            if(learned[i]) continue;

            learned[i] = true;
            combination(dep+1, i+1);
            learned[i] = false;
        }
    }

    static int getResult() {
        int cnt = 0;

        for(String word : words) {
            boolean flag = false;
            for(int i=0; i< word.length(); i++) {
                int tmp = word.charAt(i) - 'a';
                if(!learned[tmp]) {
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            cnt++;
        }
        return cnt;
    }
    static void print() {
        for(int i=0; i<26; i++) {
            if(learned[i]) System.out.print(1 + " ");
            else System.out.print(0 + " ");
        }
    }
}