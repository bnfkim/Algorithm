import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        //입력받은 숫자문자이 0-9 각 숫자가 몇개로 조합됐는지 확인
        int sum = 0;
        int[] numArr = new int[10];
        for(int i=0; i<str.length(); i++){
            int num = Integer.parseInt(str.substring(i, i+1));
            numArr[num]++;
            sum += num;
        }
        //30의 배수가 되는 조건이 안 되면 -1 반환
        if(!str.contains("0") || sum%3!=0) System.out.println(-1);
        else { //가장 큰수이므로, 큰수부터 다시 재배열
            StringBuilder sb = new StringBuilder();
            for(int i=9; i>=0; i--) {
                while(numArr[i]>0) {
                    sb.append(i);
                    numArr[i]--;
                }
            }
            System.out.println(sb);
        }
    }
}