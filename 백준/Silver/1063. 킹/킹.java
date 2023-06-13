import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static char[] king, rock;
    public static void main(String[] args) throws IOException {
        /**
         * 12.13 - 1:10
         * [조건!] 돌과 같은 곳으로 이동할 때 주의
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        king = st.nextToken().toCharArray();
        rock = st.nextToken().toCharArray();
        int n = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            String cmd = br.readLine();
            char[] nextKing = move(cmd, king);
            if(check(nextKing)) { //킹을 움직이고 범위에 있다면
                if(nextKing[0] == rock[0] && nextKing[1] == rock[1]) { //위치가 겹치면
                    char[] nextRock = move(cmd, rock);
                    if(check(nextRock)) { //돌을 움직이고 범위에 있다면
                        king = nextKing;
                        rock = nextRock;
                    }
                } else king = nextKing; //위치가 안 겹치면 킹만 이동
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(king[0]).append(king[1]).append("\n").append(rock[0]).append(rock[1]);
        System.out.println(sb);
    }
    public static boolean check(char[] arr){
        if(arr[0]<'A' || arr[0]>'H' || arr[1]<'1' || arr[1]>'8') return false;
        return true;
    }
    public static char[] move(String cmd, char[] target) {
        char[] result = target.clone();
        switch (cmd) {
            case "R": //오른쪽
                result[0]++;
                break;
            case "L": //왼쪽
                result[0]--;
                break;
            case "B": //아래
                result[1]--;
                break;
            case "T" : //위
                result[1]++;
                break;
            case"RT":
                result[0]++;
                result[1]++;
                break;
            case"LT":
                result[0]--;
                result[1]++;
                break;
            case"RB":
                result[0]++;
                result[1]--;
                break;
            case"LB":
                result[0]--;
                result[1]--;
                break;
        }
        return result;
    }
}