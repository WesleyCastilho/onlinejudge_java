package URI.Trying.NOSTATUS.AD_HOC.english;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: STRING
 * @Problem:
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2021
 * @Timelimit: 1 sec
 * @Status: Accepted
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note: นับจำนวนหลอดไฟที่เสีย
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class P2021_Christmas_Lights {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m, n, p, total;
        String input;
        while (!(input = br.readLine()).equals("0 0 0")) {
            String[] st = input.split(" ");
            m = Integer.parseInt(st[0]);
            n = Integer.parseInt(st[1]);
            p = Integer.parseInt(st[2]);
            int x = p;
            total = 0;
            while (x-- > 0) {
                int position = Integer.parseInt(br.readLine());
                if (position > n && position > m) {
                    int max = m > n ? m : n;
                    total += (position - max);
                    continue;
                }
                if (position > n) {
                    total += (m - position);
                } else {
                    total += (n - position);
                }
            }
//            total += p;
            bw.append("Lights: " + total + "\n");
        }
        bw.flush();
    }

}
