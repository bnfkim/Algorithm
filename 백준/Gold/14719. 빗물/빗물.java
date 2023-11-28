import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken()); //높이
        int W = Integer.parseInt(st.nextToken()); //가로

        int[] height = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int volume = getVolume(W, height);
        System.out.println(volume);
    }

    private static int getVolume(int W, int[] height) {
        int volume = 0; // 빗물 총량

        int left = 0;
        int right = W -1;
        int leftMax = height[0];
        int rightMax = height[W -1];

        while(left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(leftMax <= rightMax) {
                volume += leftMax - height[left];
                left++;
            } else {
                volume += rightMax - height[right];
                right--;
            }
        }
        return volume;
    }
}