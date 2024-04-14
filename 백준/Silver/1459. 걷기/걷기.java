import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long x = Long.parseLong(st.nextToken());
    long y = Long.parseLong(st.nextToken());
    long w = Long.parseLong(st.nextToken());    //한블럭
    long s = Long.parseLong(st.nextToken());    //대각선

    // 직선으로만 이동하는 경우
    long straightTime = (x + y) * w;
    // 두 좌표 중 더 작은 값까지 대각선으로 이동 후, 남은 거리는 직선으로 이동
    long diagonalTime = Math.min(x, y) * s + Math.abs(x - y) * w;
    //대각선 비용이 더 싼 경우 (짝수이면 딱 맞게 가지만, 홀수이면 한블런 전까지만 이동하고 걸어간다)
    long mixTime = ((x + y) % 2 == 0) ? Math.max(x, y) * s : (Math.max(x, y) - 1) * s + w;
    // 위의 세 가지 방법 중 가장 시간이 적게 걸리는 방법을 선택
    long minTime = Math.min(Math.min(straightTime, diagonalTime), mixTime);


    System.out.println(minTime);
  }
}