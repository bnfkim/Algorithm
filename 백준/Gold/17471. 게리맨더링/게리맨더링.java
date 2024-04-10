import java.io.*;
import java.util.*;

public class Main {
  static int N, MIN_DIFF;
  static int[] peoples;
  static boolean[] isA, visit;
  static ArrayList<ArrayList<Integer>> connection;

  public static void main(String[] args) throws IOException{
    input();
    divideField(0);
    System.out.println(MIN_DIFF == 0x3f3f3f3f ? -1 : MIN_DIFF);
  }

  //입력
  public static void input() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    MIN_DIFF = 0x3f3f3f3f;

    peoples = new int[N + 1];
    isA = new boolean[N + 1];

    st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= N; i++) {
      peoples[i] = Integer.parseInt(st.nextToken());
    }

    connection = new ArrayList<>();
    for(int i = 0; i <= N; i++) connection.add(new ArrayList<>());

    for(int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int nearNum = Integer.parseInt(st.nextToken());

      for (int j = 0; j < nearNum; j++) {
        connection.get(i).add(Integer.parseInt(st.nextToken()));
      }
    }
  }

  //부분집합
  static void divideField(int dep) {
    if(dep == N + 1) {
      ArrayList<Integer> listA = new ArrayList<>();
      ArrayList<Integer> listB = new ArrayList<>();

      for(int i = 1; i <= N; i++) {
        if(isA[i]) listA.add(i);
        else listB.add(i);
      }

      if(listA.isEmpty() || listB.isEmpty()) return;
      if(isConnect(listA) && isConnect(listB)) {
        MIN_DIFF = Math.min(MIN_DIFF, getDiff(listA, listB));
      }
      return;
    }

    isA[dep] = true;
    divideField(dep + 1);

    isA[dep] = false;
    divideField(dep + 1);
  }

  //연결이 되었는지 (bfs)
  private static boolean isConnect(ArrayList<Integer> list) {
    visit = new boolean[N + 1];

    ArrayDeque<Integer> q = new ArrayDeque<>();
    q.add(list.get(0));
    visit[list.get(0)] = true;
    int cnt = 1;

    while(!q.isEmpty()) {
      int cur = q.poll();
      for(int i = 0; i < connection.get(cur).size(); i++) {
        int num = connection.get(cur).get(i);
        if(list.contains(num) && !visit[num]) {
          q.add(num);
          visit[num] = true;
          cnt++;
        }
      }
    }
    return cnt == list.size(); //모든 구역이 연결된 것
  }

  //각 합 구하기
  private static int getDiff(ArrayList<Integer> listA, ArrayList<Integer> listB) {
    int sumA = 0, sumB = 0;
    for (Integer a : listA) sumA += peoples[a];
    for (Integer b : listB) sumB += peoples[b];
    return Math.abs(sumA - sumB);
  }
}