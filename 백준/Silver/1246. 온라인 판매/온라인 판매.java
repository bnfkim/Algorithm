import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        /**
         * 1:42 - 2:02
         * 최대 수익을 올릴 수 있는 가장 낮은 가격 책정
         * 한 구객에게 두 개 이상의 달걀은 판매 안 함
         * ex. 100원에 달걀을 판다고 하면, 100원보다 크거나 같은 모든 고객은 달걀을 산다는 뜻
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //달걀의 수
        int m = Integer.parseInt(st.nextToken()); //잠재적인 고객
        Integer[] arr = new Integer[m];
        for(int i=0; i<m; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int price = 0; //책정한 가격
        int benefit = 0; //수익
        for(int i=0; i<m; i++) {
            int tmpPrice = arr[i]; //임시 가격
            int tmpBenefit = 0;    //임시 수익

            //구매 가능한 잠재고객의 수 > 달걀의 수 -> 최대 달걀의 수만큼 구매한 것으로 계산
            if (m-i<n) tmpBenefit = tmpPrice * (m-i);
            else tmpBenefit = tmpPrice * n;

            if(benefit < tmpBenefit) {
                benefit = tmpBenefit;
                price = tmpPrice;
            }
        }
        System.out.println(price + " " + benefit);
    }
}