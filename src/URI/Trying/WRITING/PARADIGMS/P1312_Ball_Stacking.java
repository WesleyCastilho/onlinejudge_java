/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: PARADIGMS
 * @Problem: 1312 - Ball Stacking
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1312
 * @Level:
 * @Timelimit:
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: custom structure and knapsack algorithm
 * @Note:
 */

package URI.Trying.WRITING.PARADIGMS;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1312_Ball_Stacking {

    private class Ball {
        Ball top;
        Ball bottom;
        int value;

        public Ball(int value) {
            this.value = value;
        }

        public void setBottom(Ball bottom) {
            this.bottom = bottom;
        }

        public void setTop(Ball top) {
            this.top = top;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while (!(in = br.readLine()).equals("0")) {
            int n = Integer.parseInt(in);

        }
        bw.flush();
    }

}