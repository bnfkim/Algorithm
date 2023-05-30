import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    /**
     * 4:12 - 36
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numStr = br.readLine();
        int numInt = Integer.parseInt(numStr);

        if (numInt < 10) System.out.println(numInt);
        else {
            int sum = 0;
            for(int i=0; i<numStr.length()-1; i++){
                //System.out.println("9 * " + (int) Math.pow(10, i) + " * " + (i+1));
                sum  += 9 * (int) Math.pow(10, i) * (i+1);
            }
            //System.out.println("(" + numInt + " - " + ((int) Math.pow(10, numStr.length()-1) - 1) + ") * " + numStr.length());
            sum +=  (numInt - ((int) Math.pow(10, numStr.length()-1) - 1)) * numStr.length();
            System.out.println(sum);
        }
    }
}