/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge:
 * @Categories:
 * @Problem:
 * @Link:
 * @Level:
 * @Timelimit:
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

package URI.Trying.WRITING.DP;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1166_Hanoi_Tower_Troubles_Again {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            bw.append(solv(n) + "\n");
        }
        bw.flush();
    }


    static int solv(int n) {
        int sum = 0;

        int k = 0, sumK = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                k = (i % 3 == 0 ? k += 2 : k + 1);
                sumK = k;
                k++;
            }
            System.out.println("sum=" + sum);
            System.out.println("i=" + i);
            System.out.println("k=" + sumK);
            System.out.println();
            sum += i;
        }
        return sum + sumK;
    }

}