/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge:
 * @Categories:
 * @Problem:
 * @Link:
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
package URI2.Trying.NOSTATUS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1610_Dudu_Service_Maker {

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(ow);
        int n, m;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] st = br.readLine().split(" ");
            n = Integer.parseInt(st[0]);
            m = Integer.parseInt(st[1]);
            int[][] connection = new int[n][n];
            int a, b;
            while (m-- > 0) {
                br.readLine().split(" ");
                a = Integer.parseInt(st[0]);
                b = Integer.parseInt(st[1]);
                connection[a - 1][b - 1] = 1;
            }
        }
        bw.flush();
    }

}
