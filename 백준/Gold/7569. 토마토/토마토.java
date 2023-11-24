import java.io.*;
import java.util.*;

class Tomato {
    int x;
    int y;
    int z;
    public Tomato(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
class Main {
    public static int N,M,H;
    public static int[][][] box;
    //public static boolean[][][] visit;
    public static int[] dx = {1,-1,0,0,0,0,};
    public static int[] dy = {0,0,1,-1,0,0};
    public static int[] dz = {0,0,0,0,1,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //토마토 상자 입력받기
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];

        ArrayList<Tomato> tomatoes = new ArrayList<>(); //익은 토마토 위치를 저장
        for(int h=0; h<H; h++) {
            for(int n=0; n<N; n++) {
                st = new StringTokenizer(br.readLine());
                for(int m=0; m<M; m++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    box[h][n][m] = tomato;
                    if(tomato==1) tomatoes.add(new Tomato(m,n,h));
                }
            }
        }
        bfs(tomatoes);

        //안 익은 토마토가 있는지 확인
        int result = 0;
        boolean check = true;

        for(int h=0; h<H; h++) {
            for(int n=0; n<N; n++) {
                for(int m=0; m<M; m++) {
                    if(box[h][n][m]==0) {
                        check = false;
                        break;
                    }
                    result = Math.max(result, box[h][n][m]);
                }
                if(!check) break;
            }
            if(!check) break;
        }

        System.out.println((check) ? result-1 : -1);

    }
    public static void bfs(ArrayList<Tomato> tomatoes) {
        Queue<Tomato> queue = new LinkedList<>(tomatoes);

        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            //System.out.println("(" + tomato.x + "," + tomato.y + "," + tomato.z + ")");

            for(int i=0; i<6; i++) {
                int z = tomato.z + dz[i];
                int y = tomato.y + dy[i];
                int x = tomato.x + dx[i];

                if(x<0 || y<0 || z<0 || x>=M || y>=N || z>=H) continue;
                if(box[z][y][x] != 0) continue;

                box[z][y][x] += box[tomato.z][tomato.y][tomato.x] + 1;
                queue.add(new Tomato(x,y,z));
            }
        }
    }
}