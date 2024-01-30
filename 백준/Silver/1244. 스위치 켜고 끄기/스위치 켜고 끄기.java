import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    //6:20 -
    static int switchNum;
    static boolean[] switches;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        switchNum = Integer.parseInt(br.readLine()); //스위치 개수
        switches = new boolean[switchNum+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=switchNum; i++) {
            if(Integer.parseInt(st.nextToken()) == 1) switches[i] = true;
            else switches[i] = false;
        }

        //남학생은 1로, 여학생은 2로 표시
        //남학생은 자기가 받은 수의 배수 스위치 상태 바꿈, 여학생은 좌우대칭 구간 찾아서 스위치의 상태 모두 바꿈
        int studentNum = Integer.parseInt(br.readLine());

        for(int i=0; i<studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());

            if(gender == 1) {
                changeMale(position);
            } else {
                changeFemale(position);
            }
        }
        print();
    }

    static void changeMale(int pos) {
        for(int i=pos; i<=switchNum; i+=pos) {
            switches[i] = !switches[i];
        }
    }

    static void changeFemale(int pos) {
        int idx = 1;
        while (true) {
            if(pos-idx < 1 || pos+idx > switchNum) break;
            if(switches[pos-idx] != switches[pos+idx]) break;

            idx++;
        }
        idx--;
        for(int i=pos-idx; i<=pos+idx; i++) {
            switches[i] = !switches[i];
        }
    }
    static void print() {
        for(int i=1; i<=switchNum; i++) {
            if(switches[i]) System.out.print(1 + " ");
            else System.out.print(0 + " ");

            if(i%20 == 0) System.out.println();
        }
    }
}

//0 1 0 1 0 0 0 1 1 1 0 1 0 1 0 0 0 1 1 1 0