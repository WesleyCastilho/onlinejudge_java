package URI.Trying.NOSTATUS.DATA_STRUCTURES_AND_LIBRARIES;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 1274 - P-Networks
 * @Link: https://www.urionlinejudge.com.br/repository/UOJ_1274_en.html
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class P1274_P_Networks {

    static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while (!(in = br.readLine()).equals("0")) {
            String[] st = in.split(" ");
            int n = Integer.parseInt(st[0]);
            int[] stoke = new int[n];
            for (int i = 1; i <= n; i++) {
                stoke[i] = Integer.parseInt(st[i]);
            }

            LinkedList<Integer> answer = new LinkedList<>();
            //find


            //
            int size = answer.size();
            if (size <= (4 * (Math.pow(size, 4)))) {
                bw.append("" + size);
                for (Integer ans : answer) {
                    bw.append(" " + ans);
                }
                bw.newLine();
            } else {
                bw.append("No solution\n");
            }
        }
        bw.flush();
    }

}
