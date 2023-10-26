import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int cnt = 0;

            for(int x=1; x<=N; x++){
                for(int y=1; y<=N; y++){

                    if(Math.pow(x,2) + Math.pow(y,2) <= Math.pow(N,2)) cnt++;
                }
            }
            cnt *= 4;
            cnt += N*4;

            System.out.println( "#" + test_case + " " + (cnt+1));
		}
	}
}