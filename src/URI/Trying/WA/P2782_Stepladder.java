package URI.Trying.WA;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: BEGINNER
 * @Problem: 2782 - Stepladder
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2782
 * @Timelimit:
 * @Status: WA 15%
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2782_Stepladder {

    static int step = 0;
    static Integer direction = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(1);
        } else {
            String[] st = br.readLine().split(" ");
            int ladder = Integer.parseInt(st[0]);
            for (int i = 1; i < n; i++) {
                int x = Integer.parseInt(st[i]);
                if (x == ladder) {
                    if (direction == null || direction != 0) {
                        step++;
                        direction = 0;
                    }
                } else if (x > ladder) {
                    if (direction == null || direction != 1) {
                        step++;
                        direction = 1;
                    }

                } else {
                    if (direction == null || direction != 2) {
                        step++;
                        direction = 2;
                    }
                }
                ladder = x;
            }

            System.out.println(step);
        }
    }


}
