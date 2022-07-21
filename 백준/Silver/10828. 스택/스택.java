import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] stack;
    public static int size = 0;

    static void push(int item){
        stack[size] = item;
        size++;
    }
    static int pop(){
        if (size == 0){
            return -1;
        } else {
            int pop = stack[size-1];
            stack[size-1] = 0;
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
    static int top(){
        if (size == 0){
            return -1;
        } else {
            return stack[size-1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //입력값 받기
        int N = Integer.parseInt(br.readLine());
        stack = new int[N];

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

                case "top":
                    sb.append(top()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}