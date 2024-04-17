import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        System.out.println(canTransform(S, T) ? 1 : 0);
    }

    private static boolean canTransform(String S, String T) {
        StringBuilder sbT = new StringBuilder(T);

        while (S.length() < sbT.length()) {
            if (sbT.charAt(sbT.length() - 1) == 'B') {
                sbT.deleteCharAt(sbT.length() - 1);
                sbT.reverse();
            } else {
                sbT.deleteCharAt(sbT.length() - 1);
            }
        }
        return S.equals(sbT.toString());
    }
}