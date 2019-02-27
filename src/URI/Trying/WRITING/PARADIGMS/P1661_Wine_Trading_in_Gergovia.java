package URI.Trying.WRITING.PARADIGMS;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: PARADIGMS
 * @Problem: 1661 - Wine Trading in Gergovia
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1661
 * @Level: 2
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: greedy ,0/1 knapsack
 * @Note:
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1661_Wine_Trading_in_Gergovia {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while ((in = br.readLine()) != null) {
            int n = Integer.parseInt(in);
            String[] st = br.readLine().split(" ");
            long[] number = new long[n];
            for (int i = 0; i < n; i++) {
                number[i] = Long.parseLong(st[i]);
            }

            long minimum = Long.MAX_VALUE;//minimum amount of work units

            bw.append(minimum + "\n");
        }
        bw.flush();
    }
}
