import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        /**
         * (1) 뒤집기
         * 뒤집는다 -> 라는 발상을 진짜 배열을 뒤집는 것이 아닌
         * 덱을 사용하는 식으로 방법을 생각해야 함
         * (2) 자르기
         * 문자열을 자를 때 stringTokenizer 을 사용해서 자르도록 함
         * split이나 replace로 자르면 "" 가 들어가 있다
         */
        ArrayDeque<Integer> deque;
        StringTokenizer st;

        //테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        while(T -- >0){

            String command = br.readLine(); //수행할 함수
            int n = Integer.parseInt(br.readLine()); //배열에 들어있는 수의 개수

            //배열에 들어 있는 정수
            st = new StringTokenizer(br.readLine(), "[],");

            deque = new ArrayDeque<>();

            //덱에 배열 원소 넣어주기
            for(int i=0; i<n; i++){
                deque.add(Integer.parseInt(st.nextToken()));
            }

            AC(command, deque);
        }
        System.out.println(sb);
    }

    public static void makePrint(ArrayDeque<Integer> deque, boolean isRight){
        sb.append("[");

        if(deque.size() > 0) {

            if(isRight) { //정방향일 경우
                sb.append(deque.pollFirst());
                while (!deque.isEmpty()){ //반점 + 앞에서부터
                    sb.append(",").append(deque.pollFirst());
                }
            } else { //역방향일 경우
                sb.append(deque.pollLast());
                while (!deque.isEmpty()){ //반점 + 뒤에서부터
                    sb.append(",").append(deque.pollLast());
                }
            }
        }
        sb.append("]").append("\n");
    }

    public static void AC(String command, ArrayDeque<Integer> deque) {

        boolean isRight = true;

        for(char cmd : command.toCharArray()){

            if(cmd == 'R') {
                isRight = !isRight;
                continue;
            }

            //D일 경우
            if(isRight){ //정방향
                //반환 된 원소가 없을 경우 error 출력 후 함수 종료
                if(deque.pollFirst() == null){
                    sb.append("error").append("\n");
                    return;
                }

            } else { //역방향
                //반환 된 원소가 없을 경우 error 출력 후 함수 종료
                if(deque.pollLast() == null){
                    sb.append("error").append("\n");
                    return;
                }
            }
        }
        makePrint(deque, isRight);
    }
}