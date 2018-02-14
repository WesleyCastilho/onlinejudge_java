/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 1729 - Average is not Fast Enough!
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1729
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
package uri.Trying.NOSTATUS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1729_Average_is_not_Fast_Enough {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        double d = Double.parseDouble(input[1]);
        String line;
        while ((line = br.readLine()) != null) {
            input = line.split(" ");
            if (input[1].equals("-:--:--") || input[2].equals("-:--:--")) {
                bw.append(input[0] + ": -\n");
            } else {

            }
        }
    }

}
