package URI.Trying.WRITING.PARADIGMS;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: BEGINNER
 * @Problem: 2716 - Splitting Assignments II
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2716
 * @Level: 2
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: optimum difference left and right
 * @Note:
 */

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.io.IOException;

public class P2716_Splitting_Assignments_II {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (sc.hasNext()) {
            int n = sc.nextInt();
            long rangelsum = 0;
            long guguSum = 0;
            int[] work = new int[n];
            for (int i = 0; i < n; i++) {
                work[i] = sc.nextInt();
            }
            int i = -1;
            int j = n - 1;
            while (i < j) {
                if (rangelsum <= guguSum) {
                    rangelsum += work[++i];
                } else {
                    guguSum += work[j--];
                }
            }
            bw.append(Math.abs(rangelsum - guguSum) + "\n");
            bw.flush();
        }
        bw.flush();

    }

}
