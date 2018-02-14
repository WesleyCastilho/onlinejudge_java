/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 1878 Contests in Sequence
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1878
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

public class P1878_Contests_in_Sequence {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while ((input = br.readLine()) != null) {
            String[] st = input.split(" ");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);
            int[][] contests = new int[n][m];
            int[] T = new int[n];
            st = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    contests[i][j] = Integer.parseInt(st[j]);
                }
            }

        }
        bw.flush();
    }

    private static int getRanking(int[] contest) {
        int rank = 0;

        return rank;
    }

}
