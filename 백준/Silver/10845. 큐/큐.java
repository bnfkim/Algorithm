import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] queue;
    public static int first = 0;
    public static int last = 0;

    static void push(int item){
        queue[last] = item;
        last++;
    }
    static int pop(){
        if (last == first){
            return -1;
        } else {
            int pop = queue[first];
            queue[first] = 0;
            first++;
            return pop;
        }
    }
    static int size(){
        return last-first;
    }

    static int empty(){
        if (first == last){
            return 1;
        } else {
            return 0;
        }
    }
    static int front(){
        if (first == last){
            return -1;
        } else {
            return queue[first];
        }
    }
    static int back(){
        if (first == last){
            return -1;
        } else {
            return queue[last-1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        queue = new int[10001];

        //입력값 받기
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()){
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    sb.append(pop()).append("\n");
                    break;

                case "size":
                    sb.append(size()).append("\n");
                    break;

                case "empty":
                    sb.append(empty()).append("\n");
                    break;

                case "front":
                    sb.append(front()).append("\n");
                    break;

                    case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}