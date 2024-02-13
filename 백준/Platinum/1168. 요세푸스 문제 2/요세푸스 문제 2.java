import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] tree;
    static StringJoiner sb = new StringJoiner(", ", "<", ">");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        tree = new int[N * 4];
        init(1, N, 1);

        solve();
    }

    private static void solve() {
        int index = K;

        for(int i=0; i<N; i++) { //사이즈만큼 제거해야함
            if(index % tree[1] == 0) index = tree[1]; // 남은 수의 개수로 나누어 떨어질 때는 x = (남은 수의 개수)로 만든다
            else index %= tree[1];

            int num = find(1, N, 1, index);
            update(1, N, 1, num);

            index += K-1 ; //이미 제거했기 때문에 (K-1)
        }

        System.out.println(sb.toString());
    }

    private static int init(int start, int end, int node) {
        if (start == end) { //리프 노드에 사람 수 1명 넣음
            return tree[node] = 1;
        }

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    private static int find(int start, int end, int node, int idx) {
        if(start == end) {
            //실제로 제거하는 사람의 번호 수
            return start;
        }

        int mid = (start + end) >> 1;

        if(idx <= tree[node * 2]) return find(start, mid, node*2, idx);
        else return find(mid+1, end, node*2+1, idx - tree[node*2]);
    }

    private static void update(int start, int end, int node, int num) {
        /*
        Bottom-Top 방식
        리프노트를 바꾸고, 다시 연산을 해주는 방식
         */

        if (start == end) {
            tree[node] = 0;
            sb.add(String.valueOf(start));
            return;
        }

        int mid = (start + end) >> 1;

        if (num <= mid) update(start, mid, node * 2, num);
        else update(mid + 1, end, node * 2 + 1, num);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}