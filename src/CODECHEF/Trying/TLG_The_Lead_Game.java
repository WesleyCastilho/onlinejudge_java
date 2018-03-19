package CODECHEF.Trying;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: CODECHEF
 * @Categories:
 * @Problem:
 * @Link:
 * @Timelimit: 1 sec
 * @Status: WA
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note: AC with Python 3.5
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class TLG_The_Lead_Game {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int MaximumLead = 0;
        int pWinner = 0;
        int p1Score = 0, p2Score = 0;
        while (n-- > 0) {
            String[] st = br.readLine().split(" ");
            p1Score += Integer.parseInt(st[0]);
            p2Score += Integer.parseInt(st[1]);

            if (p1Score > p2Score && p1Score - p2Score > MaximumLead) {
                pWinner = 1;
                MaximumLead = p1Score - p2Score;
            } else if (p2Score > p1Score && p1Score - p2Score > MaximumLead) {
                pWinner = 2;
                MaximumLead = p1Score - p2Score;
            }

        }
        bw.append(pWinner + " " + MaximumLead + "\n");
        bw.flush();
    }

}
