import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // string 형식으로 받기 -> charAt을 통해 char로 변경 -> 변수 word 정의를 통해 int type으로 변경
        int word = br.readLine().charAt(0);

        bw.write(word + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}