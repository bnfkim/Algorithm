import java.io.*;
import java.util.*;

class Main{
    /**
     * 1:45 -
     */
    static int s, col, row;
    static String n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        n = st.nextToken();
        col = 2*s + 3;
        row = s+2;

        //각자 숫자대로 배열 만들어 저장하기
        ArrayList<String[][]> list = new ArrayList<>();
        for(int i=0; i<n.length(); i++){
            int tmp = n.charAt(i) - '0';
            list.add(makeNumber(tmp));
        }
        //출력하기
        for(int j=0; j<col; j++){
            for(int num=0; num< list.size(); num++) {
                for(int k=0; k<row; k++){
                    System.out.print(list.get(num)[j][k]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static String[][] makeNumber(int n){
        String[][] arr = new String[col][row];
        for(String tmp[] : arr) Arrays.fill(tmp, " ");
        //1
        if(n==1){
            verTop(arr, row-1);
            verBottom(arr, row-1);
        } else if (n==2) {
            hori(arr,0);
            hori(arr, col/2);
            hori(arr, col-1);
            verTop(arr, row-1);
            verBottom(arr, 0);
        } else if (n==3){
            hori(arr,0);
            hori(arr, col/2);
            hori(arr, col-1);

            verTop(arr, row-1);
            verBottom(arr, row-1);
        } else if (n==4){
            hori(arr, col/2);

            verTop(arr, 0);
            verTop(arr, row-1);
            verBottom(arr, row-1);
        } else if (n==5){
            hori(arr,0);
            hori(arr, col/2);
            hori(arr, col-1);

            verTop(arr, 0);
            verBottom(arr, row-1);
        } else if (n==6){
            hori(arr,0);
            hori(arr, col/2);
            hori(arr, col-1);

            verTop(arr, 0);
            verBottom(arr, 0);
            verBottom(arr, row-1);
        } else if (n==7){
            hori(arr,0);

            verTop(arr, row-1);
            verBottom(arr, row-1);
        } else if (n==8){
            hori(arr,0);
            hori(arr, col/2);
            hori(arr, col-1);

            verTop(arr, 0);
            verBottom(arr, 0);
            verTop(arr, row-1);
            verBottom(arr, row-1);
        } else if (n==9){
            hori(arr,0);
            hori(arr, col/2);
            hori(arr, col-1);

            verTop(arr, 0);
            verTop(arr, row-1);
            verBottom(arr, row-1);
        } else {
            hori(arr,0);
            hori(arr, col-1);

            verTop(arr, 0);
            verBottom(arr, 0);
            verTop(arr, row-1);
            verBottom(arr, row-1);
        }
        return arr;
    }

    public static String[][] hori (String[][] arr, int idx) {
        for(int i=1; i<=s; i++) arr[idx][i] = "-";
        return arr;
    }
    public static String[][] verTop (String[][] arr, int idx){
        for(int i=1; i<=s; i++) {
            arr[i][idx] = "|";
        }
        return arr;
    }
    public static String[][] verBottom (String[][] arr, int idx){
        for(int i=col/2+1; i<col-1; i++) arr[i][idx] = "|";
        return arr;
    }
}