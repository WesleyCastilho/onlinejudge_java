/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: AD-HOC
 * @Problem: 2564 - Swap It or Not?
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2564
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
package URI.Trying.NOSTATUS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2564_Swap_It_or_Not {

    static int N, P, R;
    static String[] in;
    static int[][] prize;

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(ow);
        String input;
        while ((input = br.readLine()) != null) {
            N = Integer.parseInt(input) - 1;
            prize = new int[N][2];
            int max = 0;
            int mostN = 0;

            int r = 0;
            while (N-- > 0) {
                in = br.readLine().split(" ");
                P = Integer.parseInt(in[0]);
                if (max < P) {
                    mostN = r;
                    max = P;
                }
                R = Integer.parseInt(in[1]);
                prize[r][0] = P;
                prize[r][1] = R;
                r++;
            }
            int times = 0;
            int now = prize[0][0];
            for (int i = 1; i < mostN; i++) {
                if (now != prize[i][0]) {
                    continue;
                }
                if (now < prize[i][0]) {
                    now = prize[i][0];
                    times++;
                } else if (prize[i][1] == 1) {
                    times++;
                }
            }
            bw.append(times + "\n");
            bw.flush();
        }
        bw.flush();
    }

}
