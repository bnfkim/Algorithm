import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    //에라토스테네스의 체
    boolean[] isPrime = new boolean[1_000_000_0];
    Arrays.fill(isPrime, true);
    isPrime[1] = false;
    for(int i = 2; i < isPrime.length; i++) {
      if(!isPrime[i]) continue;
      for(int j = i * 2; j < isPrime.length; j += i) {
        isPrime[j] = false;
      }
    }

    while(!isPrime[N] || !isPalindrome(N)) {
      N++;
    }
    System.out.println(N);
  }

  public static boolean isPalindrome(int num) {
    if(num < 10) return true;

    String str = String.valueOf(num);
    int start = 0;
    int end = str.length()-1;
    while(start < end) {
      if(str.charAt(start) != str.charAt(end)) return false;
      start++;
      end--;
    }
    return true;
  }
}