package URI.Trying.WA.BEGINNER;


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

                ladder = x;
            }

            System.out.println(step);
        }
    }


}
