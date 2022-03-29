import java.io.*;

public class Main {
    // 등차수열을 판별하는 함수
    public static int arithmetic(int num){
        int count = 0;
        // 1000이하의 등차수열을 미리 구해놔서 if로 n의 크기를 미리 잡아둬서 리턴해주는 식 ..?
        // 1부터 99까지는 등차수열
        if (num>0 && num <100){
            return num;
        } else {
            count = 99;
            if(num == 1000) {
                num=999;
            }
            for(int i=100; i <= num; i++){
                // 차례로 백,십,일 자릿수 저장하는 변수
                int x = i/100;
                int y = (i/10)%10;
                int z = i%10;
                // 각 자릿수가 수열을 이룰 경우
                if((x-y) == (y-z)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(arithmetic(Integer.parseInt(br.readLine())));
    }
}