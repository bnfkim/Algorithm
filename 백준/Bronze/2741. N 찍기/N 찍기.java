import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        br.close();
        for(int i=1; i<N+1; i++){
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();

        //Scanner sc = new Scanner(System.in);
        //int N = sc.nextInt();

        //for(int i = 1; i < N+1; i++){
        //    System.out.println(i);
        //}
    }
}