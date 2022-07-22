import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] Deque;
    public static int first = 10000;
    public static int last = 10000;
    public static int size = 0;

    static void push_front(int item){
        Deque[first] = item;
        first--;
        size++;
    }
    static void push_back(int item){
        last++;
        size++;
        Deque[last] = item;
    }
    static int pop_front(){
        if (size == 0){
            return -1;
        } else {
            int pop = Deque[first + 1];
            first++;
            size--;
            return pop;
        }
    }
    static int pop_back(){
        if (size == 0){
            return -1;
        } else {
            int pop = Deque[last];
            last--;
            size--;
            return pop;
        }
    }
    static int size(){
        return size;
    }

    static int empty(){
        if (size == 0){
            return 1;
        } else {
            return 0;
        }
    }
    static int front(){
        if (first == last){
            return -1;
        } else {
            return Deque[first + 1];
        }
    }
    static int back(){
        if (first == last){
            return -1;
        } else {
            return Deque[last];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque = new int[20001];

        //입력값 받기
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()){
                case "push_front":
                    push_front(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back":
                    push_back(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    sb.append(pop_front()).append("\n");
                    break;

                case "pop_back":
                    sb.append(pop_back()).append("\n");
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