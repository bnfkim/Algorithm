import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static ArrayList<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>(); //감소하는 수를 저장할 리스트

        //0-9 한자리수는 모두 감소하는 수
        if (N <= 10) System.out.println(N);
        else {
            //0부터 9까지의 숫자로 시작하는 감소하는 수를 찾기 위해 반복문 시작
            //감소하는 수 찾기 시작
            for (int i = 0; i < 10; i++) {
                set(i, 1);
            }

            if(N >= list.size()) System.out.println(-1);
            else {
                Collections.sort(list); //감소하는 수들을 오름 차순으로 정렬
                System.out.println(list.get(N));
            }
        }
    }

    /**
     *
     * @param num : 현재 수
     * @param idx : 자릿 수
     */
    public static void set(long num, int idx) {
        if(idx > 10) return; //자릿수가 10이상이면 감소하는 수를 만들 수 없으므로 종료

        //System.out.println("num = " + num + ", idx = " + idx);
        list.add(num);
        for(int i = 0; i < num % 10; i++) {
            set((num*10) + i, idx + 1);
        }
    }
}