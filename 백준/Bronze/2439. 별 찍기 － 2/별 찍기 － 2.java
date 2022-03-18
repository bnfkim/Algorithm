import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //테스트케이스 수 입력받기
        int N = Integer.parseInt(br.readLine());
        // write 내에서는 "*" * i 가 되지 않아서 이중으로 사용
        for(int i=1; i<N+1; i++){
            for(int j=N-i; j>0; j--){
                bw.write(" ");
            }
            for(int j=1; j<i+1; j++){
                bw.write("*");
            }
            bw.write("\n" );
        }
        br.close();
        bw.flush();
        bw.close();

    }
}