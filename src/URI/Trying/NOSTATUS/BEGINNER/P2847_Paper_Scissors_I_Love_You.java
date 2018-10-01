package URI.Trying.NOSTATUS.BEGINNER;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge:
 * @Problem:
 * @Link:
 * @Timelimit: 2 Seconds
 * @Status: WA 45%
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class P2847_Paper_Scissors_I_Love_You {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        text = text.replace(" ", "");
        char[] tArr = text.toCharArray();
        int tSize = text.length();
        int count = 0;
        int i = 0;
        loop:
        while (i < tSize) {
            if (tArr[i] == 'I') {
                if (i + 8 < tSize && text.substring(i, i + 8).equals("Iloveyou")) {
                    count++;
                    i += 8;
                    continue loop;
                }
                if (i <= tSize - 1 && i - 7 >= 0 && text.substring(i - 7, i + 1).equals("uoyevolI")) {
                    count++;
                }
            }
            i++;
        }
        System.out.println(count);
    }

}
